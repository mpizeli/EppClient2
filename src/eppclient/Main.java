/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eppclient;

import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.List;

/**
 *
 * @author nekta
 */
public class Main {

    static EppClient client ;
    
    static private void logit() {
        System.out.println(client.getLastHttpResponseCode());
        System.out.println(client.getLastResponse());
    }
    
    public static void main(String[] args) throws Exception {
        client = new EppClient();

        client.login();

        logit();
        
        List<HttpCookie> cookies = client.getCookieManager().getCookieStore().getCookies();

        for (HttpCookie cookie : cookies) {
            System.out.println("Όνομα: " + cookie.getName() + " | Τιμή: " + cookie.getValue());
        }
        
        client.contactCheck("nektarios");
        
        logit();
    }

}
