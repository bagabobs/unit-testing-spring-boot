package baga.len.unittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataImplementation implements DataInterface {

    @Override
    public int[] sumData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}

public class SomeDataServiceTest {
    @Test
    public void someTest() {
        SomeDataService data = new SomeDataService();
        data.setDataInterface(new DataImplementation());
        int res = data.sumAllData();
        int sumExpected = 15;
        assertEquals(sumExpected, res);
    }
}
