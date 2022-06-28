package cm.modelo;

import br.com.cod3r.cm.modelo.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CampoTest {
    private Campo campo;

    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3,3);
    }

    @Test
    void testeVizinhoRealDistancia1Esquerda(){
        Campo vizinho = new Campo(3,2);
        assertTrue(campo.adicionarVizinho(vizinho));
    }
    @Test
    void testeVizinhoRealDistancia1Direita(){
        Campo vizinho = new Campo(3,4);
        assertTrue(campo.adicionarVizinho(vizinho));
    }

    @Test
    void testeVizinhoRealDistancia2(){
        Campo vizinho = new Campo(4,2);
        assertTrue(campo.adicionarVizinho(vizinho));
    }

    @Test
    void testenaoVizinho(){
        Campo vizinho = new Campo(1,1);
        assertFalse(campo.adicionarVizinho(vizinho));
    }

    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternaMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }
    @Test
    void testeAlternaDuasMarcacao() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAbrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoNaoMarcado() {
        campo.minar();
        assertThrows(Exception.class , () -> {
            campo.abrir();
        });
    }

    @Test
    void testeAbriComVizinhos() {
        Campo campo11 = new Campo(1,1);
        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        assertFalse(campo22.isAberto() && campo11.isAberto());
        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

}
