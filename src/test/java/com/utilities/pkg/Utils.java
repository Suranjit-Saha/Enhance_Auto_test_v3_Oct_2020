package com.utilities.pkg;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class Utils{
    //Global Setup Variables
    private static String path;
    private static ReadProperties rp = new ReadProperties();

    //Sets Base URI
    public static void setBaseURI() throws IOException {
        RestAssured.baseURI = rp.readProps("uri");
    }

    public static void cratePath (String resource) throws IOException {
        path = rp.readProps("uri") + resource;
    }

    //Returns response
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(path);
    }

    //Returns response

    public static Response getAuthResponse() {
            return given().
                    auth().oauth("23F36178AA3183A14872A7DD4D9B7124","DA39D286F5A609935C992ECB017B6687",
                    "PLAINTEXT","B4E499C6416932A8AF691381DE3D8456&").
                    get(path);
    }

}