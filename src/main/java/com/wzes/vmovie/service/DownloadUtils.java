package com.wzes.vmovie.service;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Create by xuantang
 * @date on 11/1/17
 */
public class DownloadUtils {


    public static void main(String[] args) {
        try {
            String link = findLink("煎饼侠");
            //System.out.println(link);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String findLink(String movieName) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("show", "title,smalltext");
        formBody.add("tempid", "1");
        formBody.add("tbname", "Article");
        formBody.addEncoded("keyboard", URLEncoder.encode(movieName, "GB2312"));
        RequestBody requestBody = formBody.build();

//        Headers headers = new Headers.Builder()
//                .add("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3192.0 Safari/537.36")
//                .add("Content-Type", "application/xml")
//                .add("Referer", "http://www.6vhao.tv/")
//                .add("Cookie", "UM_distinctid=15e5c9b3a8e390-0f3f3073bdbd1a-632a7124-1fa400-15e5c9b3a8fe41; ecmslastsearchtime=1508979742; CNZZDATA1260799993=812339623-1504790582-null%7C1508975099")
//                .add("Host", "www.6vhao.tv")
//                .add("Connection", "keep-alive")
//                .add("Accept-Encoding", "gzip, deflate")
//                .add("Accept-Language", "en-US,zh-CN;q=0.8,zh;q=0.6,en;q=0.4")
//                .add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//                .build();
        Request request = new Request.Builder()
                .url("http://www.6vhao.tv/e/search/index.php")
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        byte[] responseBytes=response.body().bytes();
        String html = new String(responseBytes, "gb2312");

        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("listInfo");
        int movieCount = 0;
        for(Element element : elements){
            // System.out.println(element.select("a[href]").attr("title") + " " + element.select("a[href]").attr("href"));

            System.out.println("电影 " + movieCount++ + " " + element.select("p").first().text() + "\n详情页面 " + element.select("a[href]").attr("href"));
            Document detail = Jsoup.connect(element.select("a[href]").attr("href"))
                    .get();
            Elements table = detail.getElementsByTag("table");
            if(table.size() != 0){
                //link.
                //System.out.println(table.get(0).html());
                //System.out.println(table.get(0).getElementsByTag("tr"));
                Elements trs = table.get(0).getElementsByTag("tr");
                for(Element tr : trs){
                    //System.out.println(tr.html());
                    if(tr.html().contains("百度网盘")){
                        String link = tr.select("a[href]").attr("href");
                        int index = tr.text().indexOf("密码");
                        String secret= "";
                        if(index != -1){
                            secret = tr.text().substring(index);
                        }
                        // 正则匹配密码
                        Pattern pattern = Pattern.compile("\\w{4}");
                        Matcher matcher = pattern.matcher(secret);
                        if (matcher.find()) {
                            secret = matcher.group();
                        }
                        System.out.println("    Link：　" + link + "\n    Title: " + secret);
                    }else{
                        String href = tr.select("a[href]").attr("href");
                        System.out.println("    Link：　" + href + "\n    Title: " + tr.select("a[href]").text());
                    }
                }
            }
        }

        return html;
    }
}
