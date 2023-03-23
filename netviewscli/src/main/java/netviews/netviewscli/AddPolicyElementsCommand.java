package netviews.netviewscli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import javax.xml.soap.*;

/*
 * The SOAP client code in this command was used from a stackoverflow
 * forum response at:
 * https://stackoverflow.com/questions/15940234/how-to-do-a-soap-web-service-call-from-java-class
 */
@Command ( name = "AddPolicyElementsCommand",
		description = "Takes string representationof policy graph nodes, "
				+ "associations, and assignments and adds them to the policy graph.",
        mixinStandardHelpOptions = true )
public class AddPolicyElementsCommand implements Runnable {
	// TODO: get rid of default value? Might not make sense in this context
    @Parameters ( paramLabel = "<new policy info>", defaultValue = "default",
            description = "String representation of the new policy graph elements to add." )
    private final String[] message = { "default" };

    @Override
    public void run () {
    	/*
    	 * The example below requests from the Web Service at:
    	 * https://www.w3schools.com/xml/tempconvert.asmx?op=CelsiusToFahrenheit
    	 * 
    	 * 
    	 * To call other WS, change the parameters below, which are:
    	 * - the SOAP Endpoint URL (that is, where the service is responding from)
    	 * - the SOAP Action
    	 * 
    	 * Also change the contents of the method createSoapEnvelope() in this class. It constructs
    	 * the inner part of the SOAP envelope that is actually sent.
    	 */
    	// TODO: change these to our Urls and stuff once we know them.
    	String soapEndpointUrl = "https://www.w3schools.com/xml/tempconvert.asmx";
    	String soapAction = "https://www.w3schools.com/xml/CelsiusToFahrenheit";

    	callSoapWebService(soapEndpointUrl, soapAction);
    }

    // TODO: change to our stuff
    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "myNamespace";
        String myNamespaceURI = "https://www.w3schools.com/xml/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="https://www.w3schools.com/xml/">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:CelsiusToFahrenheit>
                        <myNamespace:Celsius>100</myNamespace:Celsius>
                    </myNamespace:CelsiusToFahrenheit>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("CelsiusToFahrenheit", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Celsius", myNamespace);
        soapBodyElem1.addTextNode("100");
    }

    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
        	// Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
}
