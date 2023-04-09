package com.ez.parser;

import jodd.lagarto.EmptyTagVisitor;
import jodd.lagarto.LagartoParser;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dpunosevac
 */
@ApplicationScoped
public class HtmlParser implements Parser {

    @Override
    public ParserType getType() {
        return ParserType.HTML;
    }

    @Override
    public List<String> parse(String input) {
        var texts = new ArrayList<String>();
        var parser = new LagartoParser(input);
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
