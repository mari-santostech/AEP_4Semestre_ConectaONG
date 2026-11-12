package com.conectaong.controller;

import com.conectaong.model.Doacao;
import com.conectaong.repository.DoacaoRepository;
import com.conectaong.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping /*cria nova doação*/
    public ResponseEntity<Doacao> criarDoacao(@RequestBody Doacao doacao){
        Doacao novaDoacao = doacaoService.salvar(doacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDoacao);
    }

    @GetMapping("/{id}") /*busca doação por id*/
    public ResponseEntity<Doacao> buscarPorId(@PathVariable Integer id){
        return doacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping /*lista todas as doações*/
    public ResponseEntity<List<Doacao>> listaDoacoes(){
       return ResponseEntity.ok(doacaoService.listarDoacoes());
    }

    @PutMapping("/{id}") /*atualizar status doação*/
    public ResponseEntity<Doacao> atualizarDoacao(@PathVariable Integer id, @RequestBody Doacao doacaoAtualizada){
        return doacaoService.atualizarDoacao(id, doacaoAtualizada)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") /*deleta doação*/
    public ResponseEntity<Void> deletarDoacao(@PathVariable Integer id){
        if (doacaoService.deletarDoacao(id)){
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Integer id, @RequestParam String status) {
        try {
            return doacaoService.alterarStatus(id, status)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/doador/{idDoador}")
    public ResponseEntity<List<Doacao>> buscarHistoricoPorDoador(@PathVariable Integer idDoador) {
        return ResponseEntity.ok(doacaoService.listarPorDoador(idDoador));
    }

    @GetMapping("/entidade/{idEntidade}")
    public ResponseEntity<List<Doacao>> buscarHistoricoPorEntidade(@PathVariable Integer idEntidade) {
        return ResponseEntity.ok(doacaoService.listarPorEntidade(idEntidade));
    }

}
