package gram.matica;

interface IMathResponse {
    public double[] getResponseArray();
}

public class MathResponse implements IMathResponse {
    private double[] responseArray = new double[4];

    public MathResponse(double[] responseArray) {
        this.responseArray = responseArray;
    }

    @Override
    public double[] getResponseArray() {
        return responseArray;
    }
}
