import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;

public class VKapiTest {

    VKapi vkApi;
    String post_id = "979";
    String delResult = "1";

    @BeforeEach
    void setUp(){
        vkApi = new VKapi();

    }


    @Test
    public void postMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkApi.postMessage("Hello");
        String result = EntityUtils.toString(vkApi.execute(builder).getEntity());
        post_id = result.substring(23, 26);
        System.out.println(post_id);


    }


    @Test
    public void editMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkApi.editMessage("Bye", post_id);
        String result = EntityUtils.toString(vkApi.execute(builder).getEntity());
        String edit = result.substring(23, 26);
        Assertions.assertEquals(post_id, edit);
    }


    @Test
    public void deleteMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkApi.deleteMessage(post_id);
        String result = EntityUtils.toString(vkApi.execute(builder).getEntity());
        String delete = result.substring(12, 13);
        Assertions.assertEquals(delResult, delete);
    }





}
