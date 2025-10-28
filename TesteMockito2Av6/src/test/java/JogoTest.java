
import org.example.models.Jogador;
import org.example.models.Jogo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JogoTest {
    @InjectMocks
    Jogo jogo;

    @Mock
    Jogador jogador;

    @Test
    public void testarMagiaLancada(){
        Mockito.when(jogador.getMagia()).thenReturn("Fogo");
        Assertions.assertEquals("O jogador X lançou a magia: Fogo", jogo.soltarMagia());
    }

    @Test
    public void testarInicializarJogo(){
        this.jogo.iniciarJogo();

        Mockito.verify(jogador, Mockito.times(1)).realizarAlgo();
    }
}
