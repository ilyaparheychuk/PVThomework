import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class VKapiTest {

    VKapi vkApi;
    String delResult = "1";
    private static final Logger logger = Logger.getLogger(VKapiTest.class);

    @BeforeTest
    void setUp(){
        vkApi = new VKapi();

    }


    @Test
    public void postMessageTest() throws URISyntaxException, IOException {
        logger.info("test number 1 'POST' are starting.....");
        URIBuilder builder = vkApi.postMessage("Hello");
        String result = EntityUtils.toString(vkApi.execute(builder).getEntity());
        String post_id = result.substring(23, 27);
        logger.info("Test 1 continue....");
        String text = result.substring(2,9);
        Assert.assertEquals("respons", text);
        logger.info("Test 1 assert....");
        URIBuilder builder1 = vkApi.deleteMessage(post_id);
        EntityUtils.toString(vkApi.execute(builder1).getEntity());
        logger.info("Test 1 ended");


    }


    @Test
    public void editMessageTest() throws URISyntaxException, IOException {
        logger.info("test number 2 'EDIT' are starting.....");
        URIBuilder builder = vkApi.postMessage("Hello");
        String result = EntityUtils.toString(vkApi.execute(builder).getEntity());
        String post_id = result.substring(23, 27);
        logger.info("Test 2 edit....");
        URIBuilder builder1 = vkApi.editMessage("Bye", post_id);
        String result1 = EntityUtils.toString(vkApi.execute(builder1).getEntity());
        String edit = result1.substring(23, 27);
        Assert.assertEquals(post_id, edit);
        logger.info("Test 2 assert....");
        URIBuilder builder2 = vkApi.deleteMessage(post_id);
        EntityUtils.toString(vkApi.execute(builder2).getEntity());
        logger.info("Test 2 end....");
    }


    @Test
    public void deleteMessageTest() throws URISyntaxException, IOException {
        logger.info("Test 3 'DELETE' are starting.....");
        URIBuilder builder = vkApi.postMessage("Hello");
        String result = EntityUtils.toString(vkApi.execute(builder).getEntity());
        String post_id = result.substring(23, 27);
        logger.info("Test 3 continue....");
        URIBuilder builder3 = vkApi.deleteMessage(post_id);
        String result3 = EntityUtils.toString(vkApi.execute(builder3).getEntity());
        String delete = result3.substring(12, 13);
        Assert.assertEquals(delResult, delete);
        logger.info("Test 3 assert and end....");
    }





}
