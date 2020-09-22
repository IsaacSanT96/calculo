package com.imc.calculo.repository;

import com.imc.calculo.models.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByid(Long id);
  
    


}
