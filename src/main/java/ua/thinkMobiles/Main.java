package ua.thinkMobiles;

import okhttp3.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
/*
used this libriary and java 1.8
        <dependency>
            <groupId>com.squareup.okhttp3</groupId>
            <artifactId>okhttp</artifactId>
            <version>3.4.1</version>
        </dependency>

 */

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
//        File f = new File("IMG_1717.JPG");
        File f = new File("test.mp4");
        String contentType = Files.probeContentType(Paths.get(f.getPath()));
        MediaType mediaType = MediaType.parse(contentType);
        Request request = new Request.Builder()
                .url("http://localhost:3000/api/v1/upload_file")
                .post(RequestBody.create(mediaType,f))
                .addHeader("content-type", "multipart/form-data")
                .addHeader("authorization", "3xswbjqSwRS9hebyitzhLmCX")

                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
