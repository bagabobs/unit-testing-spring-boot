package baga.len.unittesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListAllTest {
    List<String> mock = mock(List.class);

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void usingSpy() {
        ArrayList listSpy = spy(ArrayList.class);
        listSpy.add("Zero");
        System.out.println(listSpy.size());
        when(listSpy.size()).thenReturn(3); // using this
        System.out.println(listSpy.size());
        listSpy.add("One");
        listSpy.add("Two");
        System.out.println(listSpy.size());
    }
}
