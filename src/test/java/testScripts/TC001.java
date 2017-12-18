package testScripts;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import responsepojo.PostItemResponsePojo;
import websrevices.Services;

/**
 * Created by Sharif on 12/15/2017.
 */
public class TC001 {
    Services postItemSuccessful;
    Response response;

    @Test
    public void getResponse(){
        postItemSuccessful = new Services();
        response = postItemSuccessful.getItem(1923,1456,"Electronic Heater","abc@gmail.com","concept can be a part of knowledge");
        System.out.println(response.asString());

        Gson gson = new Gson();
        PostItemResponsePojo data = gson.fromJson(response.asString(), PostItemResponsePojo.class);
        System.out.println(data.getPostId());
        System.out.println(data.getId());
        System.out.println(data.getEmail());
        System.out.println(data.getBody());


        //validation of posted data is matching with server response data
       /* Assert.assertEquals(data.getPostId(),"1923");
        Assert.assertEquals(data.getId(),"1456");
        Assert.assertEquals(data.getEmail(),"abc@gmail.com");
        Assert.assertEquals(data.getBody(),"concept can be a part of knowledge");*/



    }
}
