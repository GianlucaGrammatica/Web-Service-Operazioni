package gram.matica;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        URL wsdlUrl = new URL("http://localhost:8080/hello?wsdl");

        // Questi QName dipendono dal WSDL generato; qui funzionano con questa classe/package.
        QName serviceName = new QName("http://matica.gram/", "MathServiceeService");
        QName portName    = new QName("http://matica.gram/", "MathServicePort");

        Service service = Service.create(wsdlUrl, serviceName);
        IMathService port = service.getPort(portName, IMathService.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci 2 numeri");
        System.out.print("Primo numero: ");
        double num1 = sc.nextDouble();
        System.out.print("Secondo numero: ");
        double num2 = sc.nextDouble();

        IMathResponse risposta = port.calc(num1, num2);
        System.out.println(risposta);
    }
}
