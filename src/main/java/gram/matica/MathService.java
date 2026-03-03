package gram.matica;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
interface IMathService {
    @WebMethod
    String calcolaTutto(double a, double b);
}

@WebService(endpointInterface = "gram.matica.IMathService",
        serviceName = "MathServiceService",
        portName = "MathServicePort")
public class MathService implements IMathService {

    @Override
    public String calcolaTutto(double a, double b) {
        double somma = a + b;
        double sottr = a - b;
        double molt = a * b;
        double div;
        if(b != 0) {
            div = a / b;
        }
        else {
            div = 0.0;
        }

        return somma + ", " + sottr + ", " + molt + ", " + div;
    }
}