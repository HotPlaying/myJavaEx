package com.test.experiment.ex7;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tangrd
 * @date 2021/4/3 2:18
 * @description
 */
public class UrlGettingTest {
    @Test
    public void test1(){
//        String string = HttpUtil.get(url);
//        //正则表达式，找到<a>标签的 href里面的值
//        Pattern p = Pattern.compile("<a[^>]*>([^<]*)</a>");
//        Matcher m = p.matcher(string);
//        while (m.find()) {
//            //根目录。需要结束当前循环。
//            if (m.group(1).equals("../")) {
//                continue;
//            }
//            //如果href 里面的值 包含了.png|.jpg等
//            if (m.group(1).contains(".")) {
//                HttpUtil.downloadFile(url + (m.group(1)) + "", config.get("dest"));
//                continue;
//            }
//            //否则的话 递归进行下一个文件寻找
//            recursion(url + m.group(1));
//        }

    }

    @Test
    public void test2() throws MalformedURLException {
        URL url = new URL("https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/1785534.html");
        //协议名
        System.out.println(url.getProtocol());
        //主机名-主机ip
        System.out.println(url.getHost());
        //端口
        System.out.println(url.getPort());
        //地址-文件路径
        System.out.println(url.getPath());
        //文件-全路径
        System.out.println(url.getFile());
        //查询部分-参数
        System.out.println(url.getQuery());

    }
    /**
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553434.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553535.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553636.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553737.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553838.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553939.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554040.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554141.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554242.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554343.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554444.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554545.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554646.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554747.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554848.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554949.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555050.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555151.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555252.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555353.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555454.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555555.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555656.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555757.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555858.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555959.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556060.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556161.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556262.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556363.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556464.html)
     * =HYPERLINK(https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556565.html)
     */

/*    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553434.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553535.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553636.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553737.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553838.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178553939.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554040.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554141.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554242.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554343.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554444.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554545.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554646.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554747.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554848.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178554949.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555050.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555151.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555252.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555353.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555454.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555555.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555656.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555757.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555858.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178555959.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556060.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556161.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556262.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556363.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556464.html
    start "C:\Program Files\Google\Chrome\Application\chrome.exe" https://www.mm1316.com/qihuan/woliyubaiwanshengmingzhishang/178556565.html*/
}
