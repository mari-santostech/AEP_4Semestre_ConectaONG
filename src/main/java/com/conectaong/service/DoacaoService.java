package com.conectaong.service;

import com.conectaong.model.Doacao;
import com.conectaong.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public Doacao salvar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    public List<Doacao> listarDoacoes() {
        return doacaoRepository.findAll();
    }

    public Optional<Doacao> buscarPorId(Integer id) {
        return doacaoRepository.findById(id);
    }

    public Optional<Doacao> atualizarDoacao(Integer id, Doacao doacaoAtualizada) {
        return doacaoRepository.findById(id)
                .map(doacao -> {
                    doacao.setDataDoacao(doacaoAtualizada.getDataDoacao());
                    doacao.setStatus(doacaoAtualizada.getStatus());
                    doacao.setEntidadeBeneficente(doacaoAtualizada.getEntidadeBeneficente());
                    return doacaoRepository.save(doacao);
                });
    }

    public boolean deletarDoacao(Integer id) {
        if (doacaoRepository.existsById(id)) {
            doacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private static final List<String> STATUS_PERMITIDOS = List.of(
            "Aguardando Aceite",
            "Preparando Doação",
            "Aguardando Retirada",
            "Em Transporte",
            "Concluída",
            "Cancelada"
    );

    public Optional<Doacao> alterarStatus(Integer id, String novoStatus) {
        if (!STATUS_PERMITIDOS.contains(novoStatus)) {
            throw new IllegalArgumentException("Status inválido! Use: " + STATUS_PERMITIDOS);
        }

        return doacaoRepository.findById(id)
                .map(doacao -> {
                    doacao.setStatus(novoStatus);
                    return doacaoRepository.save(doacao);
                });
    }

    public List<Doacao> listarPorDoador(Integer idDoador) {
        return doacaoRepository.findByDoadorId(idDoador);
    }

    public List<Doacao> listarPorEntidade(Integer idEntidade) {
        return doacaoRepository.findByEntidadeBeneficenteId(idEntidade);
    }

}
