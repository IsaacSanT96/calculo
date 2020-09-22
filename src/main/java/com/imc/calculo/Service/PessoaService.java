package com.imc.calculo.Service;


public class PessoaService implements  IPessoaService{

 
    @Override
    public Integer getImc(final Integer altura, final Integer peso) {
        final Integer result = peso / (altura * altura);
        return result;
    }
}
