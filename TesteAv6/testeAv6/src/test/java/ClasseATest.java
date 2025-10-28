import models.ClasseA;
import models.ClasseB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ClasseATest {

    @InjectMocks
    ClasseA classeA; // ClasseA classeA = new ClasseA(classeB);

    @Mock
    ClasseB classeB;

    @BeforeEach
    public void setup(){

    }

    @Test
    public void testarSomaDosValores(){
        Mockito.when(classeB.getX()).thenReturn(20);
        Assertions.assertEquals(25, classeA.somarValores());
    }
}
