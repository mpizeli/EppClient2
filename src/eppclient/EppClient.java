/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eppclient;

import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author nekta
 */
public class EppClient {

    private static final String EPP_URL
            = "https://snf-894416.vm.okeanos.grnet.gr/api/epp/";
   
    private final HttpClient httpClient ;
    
    private final CookieManager cookieManager = new CookieManager();

    
    public EppClient() {
        this.httpClient = HttpClient.newHttpClient();
    }
    
    public String send(String xml) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(EPP_URL))
                .header("Content-Type", "application/xml")
                .POST(HttpRequest.BodyPublishers.ofString(xml))
                .build();

        HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        return response.body();
    }

}
