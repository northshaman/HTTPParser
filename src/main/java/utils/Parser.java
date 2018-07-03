package utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Parser HTML
 */
public class Parser {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.zoo-zoo.ru/").get();
            Elements elements = doc.getElementsByAttributeValue("class", "media-wrapper");

            elements.forEach(element -> {
                        Elements hElements = element.getElementsByClass("list_title");
                        for (Element helem : hElements) {
                            System.out.println(helem.attr("title"));
                            System.out.println(helem.attr("href"));
                        }
                    }
            );
        } catch (IOException e) {
            System.out.println("Couldn't connect to URL");
            e.printStackTrace();
        }

    }

}
