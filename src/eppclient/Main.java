/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eppclient;

import eppclient.contact.EppContactInfo;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.List;

/**
 *
 * @author nekta
 */
public class Main {

    static EppClient client;

    static private void logit() {
        System.out.println(client.getLastHttpResponseCode());
        System.out.println(client.getLastResponse());
    }

    public static void main(String[] args) throws Exception {
        client = new EppClient();

        client.login();

//        EppContactInfo contactInfo = client.contactInfo("nektarios");
//        System.out.println("contactInfo = " + contactInfo);
//
        EppContactInfo contactInfo = client.contactInfo("nektarios");

        System.out.println(client.getLastEppResultCode());
        System.out.println(client.getLastEppResultMessage());

        System.out.println("contactInfo = " + contactInfo);

        System.out.println("client.getlastResponse = " + client.getLastResponse());
        
    }

}
