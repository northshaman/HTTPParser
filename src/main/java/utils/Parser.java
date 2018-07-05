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


//        try {
//            Document doc = Jsoup.connect("http://www.zoo-zoo.ru/").proxy("proxy-gf.esbt.loc",3128).get();
//            Elements elements = doc.getElementsByAttributeValue("class", "media-wrapper ");
////            System.out.println(elements);
//            elements.forEach(element -> {
//                        Elements hElements = element.getElementsByClass("list_title");
////                System.out.println(hElements);
//                        for (Element helem : hElements) {
//                            System.out.println(helem.child(0).text());
//                            System.out.println(helem.child(0).attr("href"));
//                        }
//                    }
//            );
//        } catch (IOException e) {
//            System.out.println("Couldn't connect to URL");
//            e.printStackTrace();
//        }

//        try {
//            Document doc = Jsoup.connect("https://ekb.zarplata.ru/resume").proxy("proxy-gf.esbt.loc", 3128).userAgent("Mozilla").get();
//            Elements elements = doc.getAllElements();
////                    doc.getElementsByAttributeValue("class", "ui segment resume resume-item");
////            doc.getElementsByAttributeValueContaining("class", "ui segment resume resume-item");
////            doc.getElementsByAttributeValueMatching("class","ui segment resume resume-item");
//            System.out.println(elements);
////            elements.forEach(element -> {
////                        Elements hElements = element.getElementsByClass("list_title");
//////                System.out.println(hElements);
////                        for (Element helem : hElements) {
////                            System.out.println(helem.child(0).text());
////                            System.out.println(helem.child(0).attr("href"));
////                        }
////                    }
////            );
//        } catch (IOException e) {
//            System.out.println("Couldn't connect to URL");
//            e.printStackTrace();
//        }

    }

}
