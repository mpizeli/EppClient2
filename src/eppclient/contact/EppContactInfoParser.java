/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eppclient.contact;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author nekta
 */
public class EppContactInfoParser {

    public static EppContactInfo parse(Document document) {
//         eεδω ο κωδικας parsing

        EppContactInfo contactInfo = new EppContactInfo();

        contactInfo.setContactId(document.getElementsByTag("contact:id").text());
        contactInfo.setRoid(document.getElementsByTag("contact:roid").text());
        contactInfo.setVoice(document.getElementsByTag("contact:voice").text());
        contactInfo.setFax(document.getElementsByTag("contact:fax").text());
        contactInfo.setEmail(document.getElementsByTag("contact:email").text());

        Element loc = document.getElementsByTag("contact:postalInfo")
                .first()
                .getElementsByAttributeValue("type", "loc").first();

        contactInfo.setName(loc.getElementsByTag("contact:name").text());
        contactInfo.setOrg(loc.getElementsByTag("contact:org").text());

        Element addr = loc.getElementsByTag("contact:addr").first();

        contactInfo.setLocStreet1(addr.getElementsByTag("contact:street").first().text());
        contactInfo.setLocStreet2(addr.getElementsByTag("contact:street").next().text());
        contactInfo.setLocStreet3(addr.getElementsByTag("contact:street").next().next().text());
        return contactInfo;

    }

}
