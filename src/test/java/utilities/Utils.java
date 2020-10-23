package utilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class Utils {
    //Global Setup Variables

    private  static String uri = "https://api.trademe.co.nz";
    private static String path;


    //Sets Base URI
    public static void setBaseURI() {
        RestAssured.baseURI = uri;
    }

    public static void cratePath (String resource) {
        path = uri + resource;

    }

    //Returns response
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(path);
    }

    //Returns response

    public static Response getAuthResponse() {
        //System.out.print("path: " + path +"\n");
        return given().auth().oauth("23F36178AA3183A14872A7DD4D9B7124","DA39D286F5A609935C992ECB017B6687",
                "PLAINTEXT","B4E499C6416932A8AF691381DE3D8456&").
                get(path);
    }




}