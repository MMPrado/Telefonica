package mx.edu.utng.mmacias.telefoniaestrategymmacias;

/**
 * Created by Dell Latitude on 24/09/2017.
 */

public class Telcel implements Telefonica {


    public double calcularTarifaLocal(int minLocal) {
        return minLocal*2.0;
    }


    public double calcularTarifaLD(int minLD) {
        return minLD*5.0;
    }
}
