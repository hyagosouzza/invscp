package com.devglan.userportal.Service;

import com.devglan.userportal.Services.BemServiceImpl;
import junit.framework.TestCase;

public class BemServiceImplTeste extends TestCase{

    public void testeQuantidadeAnosDiferenca(){
        String data1 = "29/04/1997";
        String data2 = "29/04/2018";
        int resultadoEsperado = 21;
        BemServiceImpl tester = new BemServiceImpl();
        int resultadoExecutado = tester.quantidadeAnosDiferenca(data1, data2);
        assertEquals(resultadoEsperado, resultadoExecutado, 0);
    }

    public void testeyearIsBisext(){
        int anoTestado = 2016;
        int resultadoEsperado = 1;
        int resultadoExecutado = 0;
        BemServiceImpl tester = new BemServiceImpl();
        boolean resultado = tester.yearIsBisext(anoTestado);
        if (resultado){
            resultadoExecutado = 1;
        }
        assertEquals(resultadoEsperado, resultadoExecutado, 0);
    }

    public void testeGetDaysMonth(){
        int mesTestado = 02;
        int anoTestado = 2016;
        int resultadoEsperado = 29;
        BemServiceImpl tester = new BemServiceImpl();
        int resultadoExecutado = tester.getDaysMonth(mesTestado, anoTestado);
        assertEquals(resultadoEsperado, resultadoExecutado, 0);
    }

    public void testeCalculoDepcreciacaoEletro(){
        float valorCompraTestado = 1000;
        float valorAtualTestado = valorCompraTestado;
        String materialTestado = "ELETRO";
        int quantAnosTestado = 1;
        float resultadoEsperado = 900;
        BemServiceImpl tester = new BemServiceImpl();
        float resultadoExecutado = tester.calculoDepcreciacao(valorCompraTestado, valorAtualTestado, materialTestado, quantAnosTestado);
        assertEquals(resultadoEsperado, resultadoExecutado, 0);
    }

    public void testeCalculoDepcreciacaoInformatica(){
        float valorCompraTestado = 1000;
        float valorAtualTestado = valorCompraTestado;
        String materialTestado = "INFORMATICA";
        int quantAnosTestado = 1;
        float resultadoEsperado = 800;
        BemServiceImpl tester = new BemServiceImpl();
        float resultadoExecutado = tester.calculoDepcreciacao(valorCompraTestado, valorAtualTestado, materialTestado, quantAnosTestado);
        assertEquals(resultadoEsperado, resultadoExecutado, 0);
    }

    public void testeCalculoDepcreciacaoFerramenta(){
        float valorCompraTestado = 1000;
        float valorAtualTestado = valorCompraTestado;
        String materialTestado = "FERRAMENTA";
        int quantAnosTestado = 1;
        float resultadoEsperado = 900;
        BemServiceImpl tester = new BemServiceImpl();
        float resultadoExecutado = tester.calculoDepcreciacao(valorCompraTestado, valorAtualTestado, materialTestado, quantAnosTestado);
        assertEquals(resultadoEsperado, resultadoExecutado, 0);
    }
}
