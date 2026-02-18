package demo;

import jakarta.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        String url = "http://localhost:8080/hello";
        Endpoint.publish(url, new HelloService());
        System.out.println("SOAP service pubblicato su: " + url);
        System.out.println("WSDL disponibile su: " + url + "?wsdl");
    }
}
