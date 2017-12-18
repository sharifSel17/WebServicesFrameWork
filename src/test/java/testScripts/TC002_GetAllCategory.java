package testScripts;

import allcetegory.Address;
import allcetegory.AllCategory;
import allcetegory.Company;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import websrevices.Services;


/**
 * Created by Sharif on 12/15/2017.
 */
public class TC002_GetAllCategory {
    Services services;
    Response responseData;

    @Test
    public void getAllItem(){
        services = new Services();
        //returns all the categories
        services.getAllItems();
        System.out.println(services.getAllItems().asString());

        //returns categories wise
        //responseData = services.getAllItems();

        Gson gson = new Gson();
        AllCategory data= gson.fromJson(responseData.asString(), AllCategory.class);


        //returns only company details
        Company detailsCompany = data.getCompany();
        System.out.println(detailsCompany.getName().toString());
        detailsCompany.getCatchPhrase();
        detailsCompany.getBs();


        //returns only address details
        Address detailsAddress= data.getAddress();
        detailsAddress.getCity();
        detailsAddress.getStreet();
        detailsAddress.getSuite();
        detailsAddress.getZipcode();
        detailsAddress.getGeo();







    }
}
