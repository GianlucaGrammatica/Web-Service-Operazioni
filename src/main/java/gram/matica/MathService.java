package gram.matica;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
interface IMathService {
    @WebMethod
    public IMathResponse calc(double a, double b);
}

@WebService(endpointInterface = "gram.matica.IMathService",
        serviceName = "MathServiceService",
        portName = "MathServicePort")
public class MathService implements IMathService {

    @Override
    public IMathResponse calc(double a, double b) {
        double[] res = new double[4];

        res[0] = a + b;
        res[1] = a - b;
        res[2] = a * b;
        res[3] = a / b;

        return new  MathResponse(res);
    }
}
