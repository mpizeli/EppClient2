/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eppclient.contact;

import eppclient.EppClient;
import org.jsoup.nodes.Document;

/**
 *
 * @author nekta
 */
public class EppContact {
   
   public EppContactInfo info(EppClient eppClient, String contactId) throws Exception {
        String xml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
            <epp 
              xmlns="urn:ietf:params:xml:ns:epp-1.0"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="urn:ietf:params:xml:ns:epp-1.0 epp-1.0.xsd">
              <command>
                <info>
                  <contact:info 
                    xmlns:contact="urn:ietf:params:xml:ns:contact-1.0"
                    xsi:schemaLocation="urn:ietf:params:xml:ns:contact-1.0 contact-1.0.xsd">
                    """
                + "<contact:id>" + eppClient.getPrefix() + "_" + contactId + "</contact:id>"
                + """
                    <!--
                    Για την ανάκτηση των πλήρη στοιχείων επαφής τρίτου καταχωρητή είναι απαραίτητη η
                    συμπλήρωση του ROID και του κωδικού εξουσιοδότησης του ονόματος χώρου στο οποίο η
                    συγκεκριμένη επαφή έχει δηλωθεί ως φορέας.
                    -->
                    <contact:authInfo>
                      <contact:pw roid="domain-roid">domain-auth-code</contact:pw>
                    </contact:authInfo>
                  </contact:info>
                </info>
                <clTRID>ABC:ics-forth:1079597962952</clTRID>
              </command>
            </epp>                     
        """;
        Document document = eppClient.sendXml(xml);
        if (eppClient.getLastEppResultCode().equals("1000")) {
          return EppContactInfoParser.parse(document);
        } else {
            return null;
        }
    }
    
}
