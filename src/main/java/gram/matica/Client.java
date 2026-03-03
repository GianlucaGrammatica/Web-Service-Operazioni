package gram.matica;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        URL wsdlUrl = new URL("http://localhost:8080/math?wsdl");

        QName serviceName = new QName("http://matica.gram/", "MathServiceService");
        QName portName    = new QName("http://matica.gram/", "MathServicePort");

        Service service = Service.create(wsdlUrl, serviceName);
        IMathService port = service.getPort(portName, IMathService.class);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il primo numero: ");
        double num1 = scanner.nextDouble();

        System.out.print("Inserisci il secondo numero: ");
        double num2 = scanner.nextDouble();

        String response = port.calcolaTutto(num1, num2);
        String[] risultati = response.split(",");

        // 3. MENU
        System.out.println("\nI calcoli sono pronti! Cosa vuoi vedere? 🫶🏻");
        System.out.println("1 - Somma");
        System.out.println("2 - Sottrazione");
        System.out.println("3 - Moltiplicazione");
        System.out.println("4 - Divisione");
        System.out.print("Scelta: ");

        int scelta = scanner.nextInt();

        System.out.println("-------------------------");
        switch (scelta) {
            case 1 -> System.out.println("Somma: " + risultati[0]);
            case 2 -> System.out.println("Sottrazione: " + risultati[1]);
            case 3 -> System.out.println("Moltiplicazione: " + risultati[2]);
            case 4 -> System.out.println("Divisione: " + risultati[3]);
            default -> System.out.println("Tasto errato");
        }
    }
}