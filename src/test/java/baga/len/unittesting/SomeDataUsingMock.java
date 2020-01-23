package baga.len.unittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SomeDataUsingMock {
    @InjectMocks
    private SomeDataService dataService;
    @Mock
    private DataInterface dataInterface;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataInterface.sumData()).thenReturn(new int[] {1, 2, 3, 4});
        int sumAll = dataService.sumAllData();
        int expected = 10;
        assertEquals(expected, sumAll);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataInterface.sumData()).thenReturn(new int[]{});
        int sumAll = dataService.sumAllData();
        int expected = 0;
        assertEquals(expected, sumAll);
    }

    @Test
    public void calculateSumUsingDataService_onevalue() {
        when(dataInterface.sumData()).thenReturn(new int[] {2});
        int sumAll = dataService.sumAllData();
        int expected = 2;
        assertEquals(expected, sumAll);
    }
}
