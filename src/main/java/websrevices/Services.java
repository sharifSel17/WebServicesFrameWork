package websrevices;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pojoClasses.PostItem;

/**
 * Created by Sharif on 12/15/2017.
 */
public class Services {
    public Response getItem(int postId, int id, String name, String email, String body){

        try {
            PostItem postItem = new PostItem();
            postItem.setPostId(postId);
            postItem.setId(id);
            postItem.setName(name);
            postItem.setEmail(email);
            postItem.setBody(body);

            JSONObject jsonObject = new JSONObject(postItem);

            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.headers("Content-Type","application/json");
            requestSpecification.body(jsonObject.toString());

            Response response = requestSpecification.post(URL.fixedUrl);
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }

    public Response getAllItems(){
         RequestSpecification requestSpecification= RestAssured.given();
         requestSpecification.headers("Content-Type","application/json");
         Response response = requestSpecification.get(URL.fixedUrl_02);

         //System.out.println(response.asString());
         return response;
    }
}
