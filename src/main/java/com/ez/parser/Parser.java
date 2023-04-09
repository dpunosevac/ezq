package com.ez.parser;

import java.util.List;

/**
 * @author dpunosevac
 */
public interface Parser {

    ParserType getType();

    List<String> parse(String input);
}
