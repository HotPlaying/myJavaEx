package com.test.experiment.sitescratch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author trd
 * @since 2022/12/5 14:47
 */
public class Demo01 {
    static String url = "https://wct.logistec.com/web/PROD/apps/wct/v2.13.19/mainfile.php?&APP_VERS=2.13.19&action=tmt_vessel_schedule&set_language=en";

    public static void main(String[] args) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(document);
    }
}
