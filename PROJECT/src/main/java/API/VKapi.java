package API;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;


public class VKapi {
    private URIBuilder builder;


    public URIBuilder createBasicURL(String methodName) throws URISyntaxException {
        String urlName = String.format("https://api.vk.com/method/wall.%s?", methodName);
        builder = new URIBuilder(urlName);
        builder.setParameter("access_token", "35fee96315330912e627715f114a38bd4686376bc38d6299928b19a2cc649158d9dabf21c32807ff42b8b")
                .setParameter("owner_id", "32789419")
                .setParameter("v", "5.101");


        return builder;
    }

    public URIBuilder postMessage(String message) throws URISyntaxException {
        URIBuilder builder = createBasicURL("post");
        builder.setParameter("message", message);
        return builder;
    }

    public URIBuilder editMessage(String message, String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicURL("edit");
        builder.setParameter("post_id", post_id);
        builder.setParameter("message", message);
        return builder;
    }

    public URIBuilder deleteMessage(String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicURL("delete");
        builder.setParameter("post_id", post_id);
        return builder;
    }

    public HttpResponse execute(URIBuilder builder) throws URISyntaxException, IOException {
        HttpGet request = new HttpGet(builder.build());
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute(request);
    }
}
