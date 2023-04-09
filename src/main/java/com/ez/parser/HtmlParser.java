package com.ez.parser;

import com.ez.cdi.Html;
import jodd.lagarto.EmptyTagVisitor;
import jodd.lagarto.LagartoParser;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dpunosevac
 */
@ApplicationScoped
@Html
public class HtmlParser implements Parser {

    @Override
    public ParserType getType() {
        return ParserType.HTML;
    }

    @Override
    public List<String> getTexts(String content) {
        var texts = new ArrayList<String>();
        var parser = new LagartoParser(content);
        var tagVisitor = new EmptyTagVisitor() {
            @Override
            public void text(final CharSequence text) {
                texts.add(text.toString());
            }
        };

        parser.parse(tagVisitor);
        return texts;
    }
}
