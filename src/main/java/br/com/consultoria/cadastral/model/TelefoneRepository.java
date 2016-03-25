package br.com.consultoria.cadastral.model;

import br.com.consultoria.util.AbstractRepository;

public class TelefoneRepository extends AbstractRepository<Telefone, QTelefone> {

    public TelefoneRepository() {
        super(QTelefone.telefone);
    }

    public Telefone findByClienteDddENumero(final Long clienteId, final String ddd, final String numero) {
        return from(entityPath)
                .where(entityPath.cliente.id.eq(clienteId)
                        .and(entityPath.ddd.eq(ddd)
                                .and(entityPath.numero.eq(numero))))
                .uniqueResult(entityPath);
    }

}
