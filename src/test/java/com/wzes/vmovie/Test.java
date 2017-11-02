package com.wzes.vmovie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
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
        Request request = new Request.Builder()
                .url("https://api.douban.com/v2/movie/subject/1764796")
                .build();
        Call call = okHttpClient.newCall(request);

        try {
            Response execute = call.execute();
            String response = execute.body().string();
            // System.out.println(response);
            JSONObject jsonObject = JSONObject.parseObject(response);
            // jsonObject.get("subjects");
            JSONObject ratings = JSONObject.parseObject(jsonObject.get("rating").toString());
            //　average rating
            String rating = ratings.get("average").toString();

            String year = jsonObject.get("year").toString();
            String genres = jsonObject.get("genres").toString();
            String summary = jsonObject.get("summary").toString();
            // title
            String title = jsonObject.get("title").toString();

            // countries
            String countries = jsonObject.get("countries").toString();
            // comments_count
            String comments_count = jsonObject.get("comments_count").toString();
            // collect_count
            String collect_count = jsonObject.get("collect_count").toString();
            // id
            String id = jsonObject.get("id").toString();
            String ratings_count = jsonObject.get("ratings_count").toString();




        } catch (IOException e) {
            e.printStackTrace();
        }

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
}
