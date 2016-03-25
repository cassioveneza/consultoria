package br.com.consultoria.cadastral.model;

import br.com.consultoria.util.AbstractRepository;

public class ClienteRepository extends AbstractRepository<Cliente, QCliente> {

    public ClienteRepository() {
        super(QCliente.cliente);
    }

}
