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
}
