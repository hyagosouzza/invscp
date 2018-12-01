package com.devglan.userportal.Services;

import com.devglan.userportal.Enums.GrupoMaterialEnum;
import com.devglan.userportal.Enums.Situacao;
import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Repo.BemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BemServiceImpl implements BemService{
    @Autowired
    private BemRepository repository;

    @Override
    public Bem create(Bem bem) {
        return repository.save(bem);
    }

    @Override
    public Bem delete(int id) {
        Bem bem = findById(id);
        if(bem != null){
            repository.delete(bem);
        }
        return bem;
    }

    @Override
    public List<Bem> findAll() {
        return repository.findAll();
    }

    @Override
    public Bem findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Bem update(Bem bem) {
        return repository.save(bem);
    }

    @Override
    public List<Bem> findAllByNumTombamento(String numTombamento) {
        List<Bem> listaTotal = repository.findAll();
        List<Bem> listaFiltrada = new ArrayList();

        for(int contador = 0; contador < listaTotal.size(); contador ++) {
            if (listaTotal.get(contador).getNumTombamento().toLowerCase().contains(numTombamento.toLowerCase())) {
                listaFiltrada.add(listaTotal.get(contador));
            }
        }

        return listaFiltrada;
    }

    @Override
    public List<Bem> findAllByMarca(String marca) {
        List<Bem> listaTotal = repository.findAll();
        List<Bem> listaFiltrada = new ArrayList();

        for(int contador = 0; contador < listaTotal.size(); contador ++) {
            if (listaTotal.get(contador).getMarca().toLowerCase().contains(marca.toLowerCase())) {
                listaFiltrada.add(listaTotal.get(contador));
            }
        }

        return listaFiltrada;
    }

    @Override
    public List<Bem> findAllBySalaGm(String sala){
        List<Bem> listaTotal = repository.findAll();
        List<Bem> listaFiltrada = new ArrayList();

        for(int contador = 0; contador < listaTotal.size(); contador ++) {
            if(listaTotal.get(contador).getSala().getNum().equals(sala)){
                listaFiltrada.add(listaTotal.get(contador));
                }
        }
        return listaFiltrada;
    }

    @Override
    public List<Bem> findAllByDenominacao(String denominacao) {
        List<Bem> listaTotal = repository.findAll();
        List<Bem> listaFiltrada = new ArrayList();

        for(int contador = 0; contador < listaTotal.size(); contador ++) {
            if (listaTotal.get(contador).getDenominacao().toLowerCase().contains(denominacao.toLowerCase())) {
                listaFiltrada.add(listaTotal.get(contador));
            }
        }

        return listaFiltrada;
    }

    @Override
    public List<Bem> findInventario() throws ParseException {
        List<Bem> listaTotal = repository.findAll();
        List<Bem> listaFiltrada = new ArrayList();
        Situacao sit;
        GrupoMaterialEnum mat;
        String situacaoStr;
        String materialStr;
        String dataAquis;
        String dataAtual;
        int quantAnos;
        float valorAtual;

        for(int contador = 0; contador < listaTotal.size(); contador ++){
            sit = listaTotal.get(contador).getSituacao();
            situacaoStr = sit.toString();
            if (!(situacaoStr.equals("BAIXADO"))){
                dataAquis = dataAquisFormat(listaTotal.get(contador).getDataAquis());
                dataAtual = dataAtual();
                quantAnos = quantidadeAnosDiferenca(dataAquis, dataAtual);
                quantAnos = quantAnos - 1;
                mat = listaTotal.get(contador).getGrupoMaterial();
                materialStr = mat.toString();
                valorAtual = listaTotal.get(contador).getValorCompra();
                if (quantAnos < 1){
                    listaTotal.get(contador).setValorAtual(listaTotal.get(contador).getValorCompra());
                } else {
                    for (int contador2 = 1; contador2 <= quantAnos; contador2++) {
                        if ((materialStr.equals("ELETRO")) || (materialStr.equals("MOVEIS")) || (materialStr.equals("DIDATICO"))) {
                            valorAtual = (valorAtual - (valorAtual / 10));
                            listaTotal.get(contador).setValorAtual(valorAtual);
                        } else if ((materialStr.equals("INFORMATICA"))) {
                            valorAtual = (valorAtual - (valorAtual / 5));
                            listaTotal.get(contador).setValorAtual(valorAtual);
                        } else if ((materialStr.equals("FERRAMENTA"))) {
                            valorAtual = (valorAtual - (valorAtual / 10));
                            listaTotal.get(contador).setValorAtual(valorAtual);
                        } else if ((materialStr.equals("EQUIPAMENTO_INDUSTRIAL"))) {
                            valorAtual = (valorAtual - (valorAtual / 10));
                            listaTotal.get(contador).setValorAtual(valorAtual);
                        } else if ((materialStr.equals("VEICULO_LEVE")) || (materialStr.equals("VEICULO_PESADO"))) {
                            valorAtual = (valorAtual - (valorAtual / 5));
                            listaTotal.get(contador).setValorAtual(valorAtual);
                        }
                    }
                }
                listaFiltrada.add(listaTotal.get(contador));
            }
        }
        return listaFiltrada;
    }

    private String dataAquisFormat(Date dataAquis) throws ParseException {
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data = out.format(in.parse(dataAquis.toString()));
        return data;
    }

    private String dataAtual(){
        Calendar dataAtual = Calendar.getInstance();
        Integer ano = dataAtual.get(Calendar.YEAR);
        Integer mes = dataAtual.get(Calendar.MONTH);
        Integer dia = dataAtual.get(Calendar.DAY_OF_MONTH);
        mes += 1;

        String strDia, strMes, strAno;

        if (dia < 10) {
            strDia = "0" + dia;
        } else {
            strDia = Integer.toString(dia);
        }
        if (mes < 10) {
            strMes = "0" + mes;
        } else {
            strMes = Integer.toString(mes);
        }

        strAno = Integer.toString(ano);

        String data;

        data = strDia + "/" + strMes + "/" + strAno;

        return data;
    }

    private int quantidadeAnosDiferenca(String dataInit, String dataFinish){
        int[] data1 = new int[3];
        int[] data2 = new int[3];
        int dias = 0;
        //Desmembra dia, mes e ano das datas;
        data1[0] = Integer.parseInt(dataInit.substring(0, 2)); //dia;
        data1[1] = Integer.parseInt(dataInit.substring(3, 5)); //mes;
        data1[2] = Integer.parseInt(dataInit.substring(6, 10)); //ano;
        data2[0] = Integer.parseInt(dataFinish.substring(0, 2)); //dia;
        data2[1] = Integer.parseInt(dataFinish.substring(3, 5)); //mes;
        data2[2] = Integer.parseInt(dataFinish.substring(6, 10)); //ano;
        int m1 = getDaysMonth(data1[1], data1[2]);
        int m2 = getDaysMonth(data2[1], data2[2]);
        if (data2[2] == data1[2]) { // Calculo para o mesmo ano;
            if (data1[1] == data2[1]) {
                dias = data2[0] - data1[0];
            } else {
                int diasMes1 = (m1 - data1[0]) + 1; 	// numero de dias do primeiro mes (do dia x até o dia 30);
                int diasMes2 = m2 - (m2 - data2[0]);	// numero de dias do ultimo mes (do dia 1 até o dia x);
                int interMeses = (data2[1] - data1[1]);	// quantidade de meses entre o primeiro e o ultimo mes;
                if (interMeses == 0) {
                    dias = diasMes1 + diasMes2;
                } else {
                    for (int i = 1; i < interMeses; i++) {
                        dias += getDaysMonth(data1[1] + i, data1[2]);
                    }
                    dias += (diasMes1 + diasMes2);
                }
            }
        } else {//Calculo para anos diferentes
            int mesesAno1 = 12 - data1[1];	    	//Numero de Meses ate o fim do ano (O Mes1 não está incluído);
            int diasMes1 = m1 - data1[0];		//Numero de dias do Mes1(inicial);
            for (int i = 0; i < mesesAno1; i++) {
                dias += getDaysMonth(data1[1] + i, data1[2]);
            }
            dias += diasMes1;
            int diasMes2 = m2 - (m2 - data2[0]);	    //Numero de dias do ultimo mes do periodo;
            int mesesAno2 = data2[1] - 1;	            //Numero de meses do mes 1 ate o mes x do novo ano;
            for (int i = 0; i < mesesAno2; i++) {
                dias += getDaysMonth(data2[1], data2[2]);
            }
            dias += diasMes2;
            if (data2[2] - data1[2] > 1) {
                dias += 365 * (data2[2] - data1[2] - 1);    // quantidade de anos entre o primeiro e o ultimo ano;
            }
        }

        double anosDouble = (dias/365.5);

        anosDouble = Math.round(anosDouble);

        int anos = (int) anosDouble;

        return anos;
    }

    private int getDaysMonth(int month, int year) {
        //O ano valor do ano será usado para verificar se o ano é bisexto
        int[] mes = new int[12];
        mes[0] = 31;
        if (yearIsBisext(year)) {
            mes[1] = 29;
        } else {
            mes[1] = 28;
        }
        mes[2] = 31;
        mes[3] = 30;
        mes[4] = 31;
        mes[5] = 30;
        mes[6] = 31;
        mes[7] = 31;
        mes[8] = 30;
        mes[9] = 31;
        mes[10] = 30;
        mes[11] = 31;
        return mes[month - 1];
    }

    private boolean yearIsBisext(int year) {
        //Ano Bisexto (Regras do Calendário Gregoriano):
        // 1 - Todo ano divisível por 4 é bissexto
        // 2 - Todo ano divisível por 100 não é bissexto
        // 3 - Mas se o ano for também divisível por 400 é bissexto
        // FONTE: http://blog.webcalc.com.br/2006/04/29/o-que-e-ano-bissexto/
        boolean retorno;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            } else {
                retorno = true;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }
}
