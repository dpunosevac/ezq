package com.ez.scrapper;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author dpunosevac
 */
@ApplicationScoped
public class WebScrapper {

    public String getPageAsHtmlString(String webPageUrl) throws IOException {
        var sb = new StringBuilder();
        var url = new URL(webPageUrl);
        var reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }
}
