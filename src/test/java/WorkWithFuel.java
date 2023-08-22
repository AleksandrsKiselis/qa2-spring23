import model.Transport;
import org.junit.jupiter.api.Test;

public class WorkWithFuel {

    @Test
    public void creatingAndUsingFuel() {

        Transport car = new Transport();
        car.setModeOfTransport("Audi");
        car.setFuelUsage(6.5);

        Transport train = new Transport();
        train.setModeOfTransport("TGK2V");
        

    }
}
