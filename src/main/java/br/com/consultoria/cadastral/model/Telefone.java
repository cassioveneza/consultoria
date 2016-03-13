package br.com.consultoria.cadastral.model;

import br.com.consultoria.util.AbstractBuilder;
import br.com.consultoria.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "TELEFONES")
public class Telefone implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "I_CLIENTES")
    private Cliente cliente;
    @NotNull
    @Size(max = 3)
    @Column(name = "DDD")
    private String ddd;
    @NotNull
    @Size(max = 9)
    @Column(name = "NUMERO")
    private String numero;

    private Telefone() {
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDDD() {
        return ddd;
    }

    private void setDDD(final String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(final String numero) {
        this.numero = numero;
    }

    public static class Builder extends AbstractBuilder<Telefone, Builder> {

        private Builder() {
            super(new Telefone());
        }
        
        private Builder(final Telefone telefone) {
            super(telefone);
        }

        public static Builder create() {
            return new Builder();
        }

        public static Builder from(final Telefone telefone) {
            return new Builder(telefone);
        }

        public Builder id(final Long id) {
            entity.setId(id);
            return this;
        }

        public Builder ddd(final String ddd) {
            entity.setDDD(ddd);
            return this;
        }

        public Builder numero(final String numero) {
            entity.setNumero(numero);
            return this;
        }
    }
}
