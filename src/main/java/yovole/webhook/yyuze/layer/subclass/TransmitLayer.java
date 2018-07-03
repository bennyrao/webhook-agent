package yovole.webhook.yyuze.layer.subclass;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import yovole.webhook.yyuze.layer.Layer;

import java.io.IOException;

@Component
public class TransmitLayer extends Layer {

    public void transmitContent() {
        String targetURL = this.getWebsite() + this.getURL() + "/?access_token=" + this.getToken();
        String content = this.getContent();

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(targetURL);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        StringEntity se = new StringEntity(content, "utf-8");
        httppost.setEntity(se);
        try {
            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
