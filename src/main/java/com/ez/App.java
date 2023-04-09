package com.ez;

import com.ez.parser.HtmlParser;
import com.ez.scrapper.WebScrapper;

import java.io.IOException;
import java.util.List;

/**
 * @author dpunosevac
 */
//@QuarkusMain
// TODO: Handle properly Exceptions
// TODO: Figure out if cross-site scripting attacks is a problem here https://owasp.org/www-community/attacks/xss/
// TODO: Make a stop words list
public class App {

    public static void main(String[] args) throws IOException {
        var scrapper = new WebScrapper();
        var html = scrapper.getPageAsHtmlString("https://docs.rs/tokio/1.27.0/tokio/");

        var parser = new HtmlParser();
        List<String> texts = parser.parse(html);
        // todo: add lexer
        texts.forEach(System.out::println);
    }
}
