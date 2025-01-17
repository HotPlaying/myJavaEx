package com.test.experiment.sitescratch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;




public class SiteScratch {



    public static void main(String[] args) {
        List<String> proxys = new ArrayList<String>(Arrays.asList(proxies));
        int v = 0;
        while (!proxys.isEmpty()) {
            List<String> proxyA = new ArrayList<String>();
            int i = 1;
            for (String proxy : proxys) {
                CloseableHttpClient hc = HttpClients.custom().setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(8000).build()).build();
                String[] proxyport = proxy.split(":");
                HttpHost proxyhost = new HttpHost(proxyport[0], proxyport.length > 1 ? NumberUtils.toInt(proxyport[1]) : 80, "http");
                RequestConfig config = RequestConfig.custom().setConnectTimeout(8000).setConnectionRequestTimeout(8000).setSocketTimeout(8000).setProxy(proxyhost).build();
                String url = "http://app2.vote.cntv.cn/makeClickAction.do?callback=jQuery" + RandomStringUtils.randomNumeric(20) + "_" + System.currentTimeMillis() + "&type=jsonp&voteId=15595&items_1131400=197462&timstamp=" + System.currentTimeMillis()
                        + "&&_=" + System.currentTimeMillis();
                String ip = RandomUtils.nextInt(1, 254) + "." + RandomUtils.nextInt(1, 254) + "." + RandomUtils.nextInt(1, 254) + "." + RandomUtils.nextInt(1, 254);
                HttpGet httpget = new HttpGet(url);
                httpget.setConfig(config);
                httpget.setHeader(HttpHeaders.HOST, "app2.vote.cntv.cn");
                httpget.setHeader(HttpHeaders.PRAGMA, "no-cache");
                httpget.setHeader(HttpHeaders.VIA, ip);
                httpget.setHeader("X-FORWARDED-FOR", ip);
                httpget.setHeader("X-REAL-IP", ip);
                httpget.setHeader(HttpHeaders.REFERER, "http://news.cctv.com/special/gdzg2017/toupiao2017/");
                httpget.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0." + RandomStringUtils.randomNumeric(4) + ".84 Safari/537.36");



                try {
                    System.out.println((i++) + "/" + proxys.size());
                    CloseableHttpResponse res = hc.execute(httpget);
                    String result = EntityUtils.toString(res.getEntity());
                    // System.out.println(new Date() + "\t" + ip + "\t" + proxy + "\t" + result);
                    if (result.contains("\"success\":\"1\"")) {
                        System.out.println("=============" + (++v));
                        proxyA.add(proxy);
                    }
                } catch (Throwable e) {
                    // System.out.println(new Date() + "\t" + ip + "\t" + proxy + "\t" + e.getMessage());
                } finally {
                    try {
                        hc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            proxys.clear();
            System.out.println(new Date() + "===========\t" + proxyA.toString());
            proxys.addAll(proxyA.isEmpty() ? Arrays.asList(proxies) : proxyA);
        }
    }



    static String[] proxies = {"119.129.99.236:9797", "61.155.164.110:3128", "119.122.1.63:9000"};
}