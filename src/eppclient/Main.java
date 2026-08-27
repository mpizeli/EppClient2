/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eppclient;

/**
 *
 * @author nekta
 */
public class Main {

    public static void main(String[] args) throws Exception {
        EppClient client = new EppClient();

        String helloXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <epp
            xmlns="urn:ietf:params:xml:ns:epp-1.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="urn:ietf:params:xml:ns:epp-1.0 epp-1.0.xsd">
            <hello/>
        </epp>
        """;

        String received = client.send(helloXml);

        System.out.println(received);
    }

}
