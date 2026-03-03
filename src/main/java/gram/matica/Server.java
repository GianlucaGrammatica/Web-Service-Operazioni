package gram.matica;

import jakarta.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        String url = "http://localhost:8080/math";
        Endpoint.publish(url, new MathService());

        System.out.println("Calcolatrice SOAP pronta su: " + url);
        System.out.println("WSDL disponibile su: " + url + "?wsdl");
        System.out.println("Waiting for requests...");
    }
}