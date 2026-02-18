package demo;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws Exception {
        URL wsdlUrl = new URL("http://localhost:8080/hello?wsdl");

        // Questi QName dipendono dal WSDL generato; qui funzionano con questa classe/package.
        QName serviceName = new QName("http://demo/", "HelloServiceService");
        QName portName    = new QName("http://demo/", "HelloServicePort");

        Service service = Service.create(wsdlUrl, serviceName);
        IHelloService port = service.getPort(portName, IHelloService.class);

        String risposta = port.hello("Matteo");
        System.out.println(risposta); // -> Ciao Matteo
    }
}
