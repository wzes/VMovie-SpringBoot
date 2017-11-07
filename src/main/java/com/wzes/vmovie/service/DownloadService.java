package com.wzes.vmovie.service;

import com.alibaba.fastjson.JSON;
import com.wzes.vmovie.controller.MovieController;
import com.wzes.vmovie.model.MovieLink;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Create by xuantang
 * @date on 11/1/17
 */
@Service
public class DownloadService {
    private static Logger log = LogManager.getLogger(DownloadService.class); //日志输出
    /**
     *
     * @param movieName the name of movie you want to search
     * @return list of result
     * @throws IOException
     */
    public List<MovieLink> findLink(String movieName) throws IOException {

        List<MovieLink> movieLinks = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("show", "title,smalltext");
        formBody.add("tempid", "1");
        formBody.add("tbname", "Article");
        formBody.addEncoded("keyboard", URLEncoder.encode(movieName, "GB2312"));
        RequestBody requestBody = formBody.build();

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
            String title = element.select("p").first().text().substring(3);
            Document detail = Jsoup.connect(element.select("a[href]").attr("href"))
                    .get();
            Elements table = detail.getElementsByTag("table");
            if(table.size() != 0){
                //link.
                Elements trs = table.get(0).getElementsByTag("tr");
                for(Element tr : trs){
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
                        if(link == null || link.length() ==0){

                        }else{
                            MovieLink movieLink = new MovieLink(title, link, secret);
                            movieLinks.add(movieLink);
                            log.info(movieLink.toString());
                        }
                    }else{
                        String link = tr.select("a[href]").attr("href");
                        String secret = "";
                        if(link == null || link.length() ==0){

                        }else{
                            MovieLink movieLink = new MovieLink(title, link, secret);
                            movieLinks.add(movieLink);
                            log.info(movieLink.toString());
                        }
                    }
                }
            }
        }

        return movieLinks;
    }
}
