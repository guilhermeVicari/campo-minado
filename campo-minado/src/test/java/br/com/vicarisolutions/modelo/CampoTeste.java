package br.com.vicarisolutions.modelo;

import br.com.vicarisolutions.excessao.ExplosaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {

    private Campo campo;

    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3,3);
    }
    @Test
    void testeVizinhoDistancia1(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testeNaoVizinho(){
        Campo vizinho = new Campo(1,1);
        boolean resultado = campo.adicionarVizinho(vizinho);

        Assertions.assertFalse(resultado);
    }

    @Test
    void testeValorPadraoAtributoMarcacao(){
        Assertions.assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        Assertions.assertTrue(campo.isMarcado());
    }
    @Test
    void testeAlternarMarcacaoDuasChamadas(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        Assertions.assertFalse( campo.isMarcado());
    }

    @Test
    void testeAbrirNaoMinadoNaoMarcado(){
        Assertions.assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoMarcado(){
        campo.alternarMarcacao();
        Assertions.assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirComVizinhos(){


        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,2);
        campo12.minar();
        Campo campo22 = new Campo(2,2);

        campo.adicionarVizinho(campo22);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);
        campo.abrir();

        Assertions.assertTrue(campo22.isAberto() && !campo11.isAberto());
    }

    @Test
    void testeAbrirMinadoMarcado(){
        campo.minar();
        Assertions.assertThrows(ExplosaoException.class, () ->{
            campo.abrir();
        });
    }
}
