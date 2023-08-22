import model.Car;
import model.FramePool;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestingWithObjects {
    @Test
    public void creatingAndUsingObjects() {
        Car mercedes = new Car();
        mercedes.setMake("Mercedes");
        mercedes.setModel("c220");
        mercedes.setGearbox("automatic");
        mercedes.setMileage(2456774647L);
        mercedes.setPower(160);
        mercedes.setCubicCapacity(2.1998f);
        mercedes.setPrice(BigDecimal.valueOf(13.999));

        mercedes.printFullMake();

        FramePool aqua = new FramePool();
        aqua.setBrand("AQUA");
        aqua.setHeight(1.60f);
        aqua.setLength(4.80f);
        aqua.setVolume(10658);
        aqua.setWidth(2.60f);
        aqua.setProductId(2873663);
        aqua.setPrice(BigDecimal.valueOf(568.99));

        aqua.printFullArea();
    }


}
