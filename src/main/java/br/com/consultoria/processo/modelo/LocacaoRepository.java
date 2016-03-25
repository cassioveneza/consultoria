package br.com.consultoria.processo.modelo;

import br.com.consultoria.util.AbstractRepository;

public class LocacaoRepository extends AbstractRepository<Locacao, QLocacao> {

    public LocacaoRepository() {
        super(QLocacao.locacao);
    }

}
