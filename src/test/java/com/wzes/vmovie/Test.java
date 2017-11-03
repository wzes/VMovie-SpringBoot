package com.wzes.vmovie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzes.vmovie.model.Movie;
import okhttp3.*;
import org.dom4j.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * @author Create by xuantang
 * @date on 11/1/17
 */
public class Test {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
//
//        FormBody.Builder formBody = new FormBody.Builder();
//        formBody.add("username", "1552730");
//        formBody.add("password", "123456");
//        RequestBody requestBody = formBody.build();
//
//        Request request = new Request.Builder()
//                .url("http://localhost:9999/vmovie/login")
//                .post(requestBody)
//                .build();
        okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://59.110.136.134:10001/vmovie/" +  "1552730"+ "/movie_collection/" + "25790761")
                .delete()
                .build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
//        Request request = new Request.Builder()
//                .url("http://59.110.136.134:10001/vmovie/1552730/movie_collections")
//                .build();
//        Call call = okHttpClient.newCall(request);
//
//        try {
//            Response execute = call.execute();
//            String response = execute.body().string();
//            System.out.println(response);
//            Document document = DocumentHelper.parseText(response);
//            Element root = document.getRootElement();
//            System.out.println(root.getName());
//            Iterator<Element> movieNodes = root.elementIterator();
//            while(movieNodes.hasNext()){
//                Element movieNode = movieNodes.next();
//                Iterator<Element> mIterator = movieNode.elementIterator();
//                while(mIterator.hasNext()){
//                    Element movie = mIterator.next();
//                    if(movie.getName().equals("data")) {
//
//                        JSONObject jsonObject = JSONObject.parseObject(movie.getText());
//                        Movie m = new Movie();
//                        m.setId(jsonObject.getString("id"));
//                        m.setTitle(jsonObject.getString("title"));
//                        m.setImage(jsonObject.getString("image"));
//                        m.setRating(jsonObject.getString("rating"));
//                        String data = m.toString();
//                        System.out.println(data);
//                    }
//
//                }
//                //System.out.println(e.getName());
//                //listNodes(e);
//            }
//            Request request = new Request.Builder()
//                    .url("https://api.douban.com/v2/movie/us_box")
//                    .build();
//            Call call = okHttpClient.newCall(request);
//
//            try {
//                Response execute = call.execute();
//                String response = execute.body().string();
//                System.out.println(response);
//                JSONObject jsonObject = JSONObject.parseObject(response);
//                // jsonObject.get("subjects");
//                //JSONObject subjects = JSONObject.parseObject(jsonObject.get("subjects").toString());
//                JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("subjects"));
//                for( Object jsonObject1 : jsonArray) {
//                    JSONObject jsonObject2 = JSONObject.parseObject(jsonObject1.toString());
//                    // rank
//                    String rank = jsonObject2.get("rank").toString();
//                    //　box
//                    String box = jsonObject2.get("box").toString();
//
//                    JSONObject jsonObject3 = JSONObject.parseObject(jsonObject2.getString("subject"));
//
//                    JSONObject ratings = JSONObject.parseObject(jsonObject3.get("rating").toString());
//
//                    String rating = ratings.get("average").toString();
//
//                    // title
//                    String title = jsonObject3.get("title").toString();
//                    // images
//                    JSONObject images = JSONObject.parseObject(jsonObject3.get("images").toString());
//                    // large image
//                    String image = images.get("large").toString();
//                    // id
//                    String id = jsonObject3.get("id").toString();
//                    System.out.println(title + " " + id + " " + box + " " + rank + " " + image);
//                }
//            //　average rating
//            String rating = ratings.get("average").toString();
//
//            String year = jsonObject.get("year").toString();
//            String genres = jsonObject.get("genres").toString();
//            String summary = jsonObject.get("summary").toString();
//            // title
//            String title = jsonObject.get("title").toString();
//
//            // countries
//            String countries = jsonObject.get("countries").toString();
//            // comments_count
//            String comments_count = jsonObject.get("comments_count").toString();
//            // collect_count
//            String collect_count = jsonObject.get("collect_count").toString();
//            // id
//            String id = jsonObject.get("id").toString();
//            String ratings_count = jsonObject.get("ratings_count").toString();



//        try {
//            Response execute = call.execute();
//            String response = execute.body().string();
//            // System.out.println(response);
//            JSONObject jsonObject = JSONObject.parseObject(response);
//            // jsonObject.get("subjects");
//            JSONObject ratings = JSONObject.parseObject(jsonObject.get("rating").toString());
//            //　average rating
//            String rating = ratings.get("average").toString();
//
//            String year = jsonObject.get("year").toString();
//            String genres = jsonObject.get("genres").toString();
//            String summary = jsonObject.get("summary").toString();
//            // title
//            String title = jsonObject.get("title").toString();
//
//            // countries
//            String countries = jsonObject.get("countries").toString();
//            // comments_count
//            String comments_count = jsonObject.get("comments_count").toString();
//            // collect_count
//            String collect_count = jsonObject.get("collect_count").toString();
//            // id
//            String id = jsonObject.get("id").toString();
//            String ratings_count = jsonObject.get("ratings_count").toString();
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            Response execute = call.execute();
//            String response = execute.body().string();
//            // System.out.println(response);
//            JSONObject jsonObject = JSONObject.parseObject(response);
//            // jsonObject.get("subjects");
//
//            JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("subjects"));
//            for( Object jsonObject1 : jsonArray) {
//                JSONObject jsonObject2 = JSONObject.parseObject(jsonObject1.toString());
//                // images
//                JSONObject images = JSONObject.parseObject(jsonObject2.get("images").toString());
//                // large image
//                String image = images.get("large").toString();
//
//                JSONObject ratings = JSONObject.parseObject(jsonObject2.get("rating").toString());
//                //　average rating
//                String rating = ratings.get("average").toString();
//
//                // title
//                String title = jsonObject2.get("title").toString();
//
//                // id
//                String id = jsonObject2.get("id").toString();
//                System.out.println(title + " " + id + " " + rating + " " + image);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println(response.body().string());
//
//                JSONObject jsonObject = JSONObject.parseObject(response.body().string());
//                // jsonObject.get("subjects");
//                String string = JSONObject.toJSONString(jsonObject, true);
//                System.out.println(jsonObject);
//
//            }
//        });
    }
    //遍历当前节点下的所有节点
    public static void listNodes(Element node){
        System.out.println("当前节点的名称：" + node.getName());
        //首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
//        //遍历属性节点
//        for(Attribute attribute : list){
//            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());
//        }
        //如果当前节点内容不为空，则输出
        if(!(node.getTextTrim().equals(""))){
            System.out.println( node.getName() + "：" + node.getText());
        }
        //同时迭代当前节点下面的所有子节点
        //使用递归
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }

}
