package br.com.developeracademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    List<String> list;

    @Test
    public void quintoTesteMockito(){
        list.size();
        list.add("");
        InOrder inOrder = Mockito.inOrder(list);
        inOrder.verify(list).size();
        inOrder.verify(list).add("");
    }

    @Test
    public void quartoTesteMockito(){
        int size;
        if (Boolean.FALSE) {
            size = list.size();
        }
        Mockito.verify(list, Mockito.never()).size();
    }

    @Test
    public void terceiroTesteMockito(){
        int size;
        if (Boolean.TRUE) {
            size = list.size();
        }
        Mockito.verify(list, Mockito.times(1)).size();
    }

    @Test
    public void segundoTesteMockito(){
        int size;
        if (Boolean.TRUE) {
            size = list.size();
        }
        Mockito.verify(list).size();
    }

    @Test
    public void primeiroTesteMockito(){
        Mockito.when(list.size()).thenReturn(20);
        int size = list.size();
        Assertions.assertThat(size).isEqualTo(20);
    }
}
