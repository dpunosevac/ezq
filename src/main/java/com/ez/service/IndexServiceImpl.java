package com.ez.service;

import com.ez.cdi.Html;
import com.ez.parser.Parser;
import com.ez.scrapper.WebScrapper;
import com.ez.tokenization.Lexer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

/**
 * @author dpunosevac
 */
@ApplicationScoped
public class IndexServiceImpl implements IndexService {

    @Inject
    WebScrapper webScrapper;

    @Inject
    @Html
    Parser htmlParser;

    @Override
    public void indexWebPage(String contentPath) throws IOException {
        var html = webScrapper.getPageAsHtmlString(contentPath);
        var content = String.join(" ", htmlParser.getTexts(html));
        System.out.println(Lexer.tokenize(content));
    }
}
