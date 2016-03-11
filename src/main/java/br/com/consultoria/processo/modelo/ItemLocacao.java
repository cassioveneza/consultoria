package br.com.consultoria.processo.modelo;

import br.com.consultoria.cadastral.model.Filme;
import br.com.consultoria.util.AbstractBuilder;
import br.com.consultoria.util.AbstractEntityId;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "ITENS_LOCACAO")
public class ItemLocacao implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "I_LOCACOES", nullable = false)
    private Locacao locacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "I_FILMES", nullable = false)
    private Filme filme;

    @NotNull
    @Column(name = "DATA_DEVOLUCAO")
    private LocalDate dataDevolucao;

    private ItemLocacao() {
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    private void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Filme getFilme() {
        return filme;
    }

    private void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    private void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public static class Builder extends AbstractBuilder<ItemLocacao, Builder> {

        private Builder(ItemLocacao itemLocacao) {
            super(itemLocacao);
        }

        public static Builder create() {
            return new Builder(new ItemLocacao());
        }

        public static Builder from(ItemLocacao itemLocacao) {
            return new Builder(itemLocacao);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder locacao(Locacao locacao) {
            entity.setLocacao(locacao);
            return this;
        }

        public Builder filme(Filme filme) {
            entity.setFilme(filme);
            return this;
        }

        public Builder dataDevolucao(LocalDate dataDevolucao) {
            entity.setDataDevolucao(dataDevolucao);
            return this;
        }

    }
}
