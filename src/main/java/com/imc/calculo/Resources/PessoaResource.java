package com.imc.calculo.Resources;

import com.imc.calculo.Service.IPessoaService;
import com.imc.calculo.Service.PessoaService;
import com.imc.calculo.models.Pessoa;
import com.imc.calculo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    IPessoaService pessoaService ;


    @GetMapping("/pessoas")
    public List<Pessoa> listPessoas(){
        return pessoaRepository.findAll();
    }


    @GetMapping("/pessoa/{id}")
    public Pessoa listPessoa(@PathVariable(value = "id") long id){
        return pessoaRepository.findByid(id);
    }

    @PostMapping("/pessoa")
    public Pessoa salvaPessoa(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/pessoa")
    public void deletePessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.delete(pessoa);
    }

    @PutMapping("/pessoa")
    public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @GetMapping("/pessoa/imc/{cpf}")
    public ResponseEntity<Integer> PessoaImc(@PathParam(value = "cpf") String cpf){

        Pessoa pessoa = Pessoa.builder().cpf(cpf).build();
        return new ResponseEntity<Integer>(pessoaService.getImc(pessoa.getAltura(), pessoa.getPeso()),HttpStatus.OK);
    }

    
   


}
