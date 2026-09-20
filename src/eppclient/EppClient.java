/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eppclient;

import eppclient.contact.EppContactInfo;
import eppclient.contact.EppContact;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/**
 *
 * @author nekta
 */
public class EppClient {

    private static final String EPP_URL
            = "https://snf-894416.vm.okeanos.grnet.gr/api/epp/";

    private final HttpClient httpClient;

    private final CookieManager cookieManager = new CookieManager();

    private final String clID = "acropolis";
    private final String pw = "1234";
    private final String clTRID = "acro";
    private final String prefix = "c78";

    private String lastPayload;
    private String lastResponse;
    private Integer lastHttpResponseCode;
   
    
    private String lastEppResultCode;
    private String lastEppResultMessage;
    
    
    public CookieManager getCookieManager() {
        return cookieManager;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getLastEppResultCode() {
        return lastEppResultCode;
    }

    
    
    
    public EppClient() {
        this.httpClient = HttpClient
                .newBuilder()
                .cookieHandler(cookieManager).build();
//        this.httpClient = HttpClient.newHttpClient();
    }

    public String getLastPayload() {
        return lastPayload;
    }

    public String getLastResponse() {
        return lastResponse;
    }

    public Integer getLastHttpResponseCode() {
        return lastHttpResponseCode;
    }

    public String getLastEppResultMessage() {
        return lastEppResultMessage;
    }
    
    

    public Document sendXml(String xml) throws Exception {
        lastPayload = xml;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(EPP_URL))
                .header("Content-Type", "application/xml")
                .POST(HttpRequest.BodyPublishers.ofString(xml))
                .build();
        HttpResponse<String> response
                = httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );
        lastHttpResponseCode = response.statusCode();
        lastResponse = response.body();
        Document document = Jsoup.parse(lastResponse, Parser.xmlParser());
        lastEppResultCode = document.select("result").attr("code");
        lastEppResultMessage = document.getElementsByTag("msg").text();
        return document;
    }

    public void hello() throws Exception {
        String helloXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <epp
            xmlns="urn:ietf:params:xml:ns:epp-1.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="urn:ietf:params:xml:ns:epp-1.0 epp-1.0.xsd">
            <hello/>
        </epp>
        """;
        sendXml(helloXml);
    }

    public void login() throws Exception {
        String xml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <epp
          xmlns="urn:ietf:params:xml:ns:epp-1.0" 
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
          xsi:schemaLocation="urn:ietf:params:xml:ns:epp-1.0 epp-1.0.xsd">
          <command>
            <login>
                """
                + "<clID>" + this.clID + "</clID>"
                + "<pw>" + this.pw + "</pw>"
                + """
              <pw>
                <![CDATA[&my-password&]]>
              </pw>
              <options>
                <version>1.0</version>
                <lang>el</lang>
              </options>
              <svcs>
                <objURI>urn:ietf:params:xml:ns:contact-1.0</objURI>
                <objURI>urn:ietf:params:xml:ns:domain-1.0</objURI>
                <objURI>urn:ietf:params:xml:ns:host-1.0</objURI>
              </svcs>
            </login>
            """
                + "<clTRID>" + this.clTRID + "</clTRID>"
                + """
            </command>
        </epp>
        """;
        sendXml(xml);
        
    }

    public void contactCheck(String contactId) throws Exception {
        String xml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <epp 
          xmlns="urn:ietf:params:xml:ns:epp-1.0" 
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
          xsi:schemaLocation="urn:ietf:params:xml:ns:epp-1.0 epp-1.0.xsd">
          <command>
            <check>
              <contact:check 
                xmlns:contact="urn:ietf:params:xml:ns:contact-1.0" 
                xsi:schemaLocation="urn:ietf:params:xml:ns:contact-1.0 contact-1.0.xsd">
                """
                + "<contact:id>" + contactId + "</contact:id>"
                + """
                </contact:check>
            </check>
            """
                + "<clTRID>" + this.clTRID + "</clTRID>"
                + """
          </command>
        </epp>
        """;
        sendXml(xml);
    }

    public EppContactInfo contactInfo(String contactId) throws Exception {
        EppContact contact = new EppContact();
        return contact.info(this, contactId);
    }

    

}
