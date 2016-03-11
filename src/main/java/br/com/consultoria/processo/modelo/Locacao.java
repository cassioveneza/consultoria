package br.com.consultoria.processo.modelo;

import br.com.consultoria.cadastral.model.Cliente;
import br.com.consultoria.util.AbstractBuilder;
import br.com.consultoria.util.AbstractEntityId;
import br.com.consultoria.util.JsonDateDeserializer;
import br.com.consultoria.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "LOCACOES")
public class Locacao implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "DATA_LOCACAO")
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "I_CLIENTES")
    private Cliente cliente;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locacao")
    private List<ItemLocacao> itens = new ArrayList<>();

    private Locacao() {
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    private void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacao() {
        return observacao;
    }

    private void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ItemLocacao> getItensLocacao() {
        return itens;
    }

    private void adicionaItem(ItemLocacao item) {
        this.itens.add(item);
    }

    private void removeItem(ItemLocacao item) {
        this.itens.remove(item);
    }

    public static class Builder extends AbstractBuilder<Locacao, Builder> {

        private Builder(Locacao locacao) {
            super(locacao);
        }

        public static Builder create() {
            return new Builder(new Locacao());
        }

        public static Builder from(Locacao locacao) {
            return new Builder(locacao);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder data(LocalDate data) {
            entity.setData(data);
            return this;
        }

        public Builder cliente(Cliente cliente) {
            entity.setCliente(cliente);
            return this;
        }

        public Builder observacao(String observacao) {
            entity.setObservacao(observacao);
            return this;
        }

        public Builder adicionaItem(ItemLocacao item) {
            entity.adicionaItem(item);
            return this;
        }

        public Builder removeItem(ItemLocacao item) {
            entity.removeItem(item);
            return this;
        }

    }
}
