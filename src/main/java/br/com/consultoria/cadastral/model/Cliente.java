package br.com.consultoria.cadastral.model;

import br.com.consultoria.processo.modelo.Locacao;
import br.com.consultoria.util.AbstractBuilder;
import br.com.consultoria.util.AbstractEntityId;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "CLIENTES")
public class Cliente implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private Sexo sexo;

    @Column(name = "TELEFONE")
    private String telefone;

    @NotNull
    @Column(name = "ENDERECO")
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "I_CLIENTES")
    private List<Locacao> locacoes;

    private Cliente() {
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    private void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    private void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public static class Builder extends AbstractBuilder<Cliente, Builder> {

        private Builder(Cliente cliente) {
            super(cliente);
        }

        public static Builder create() {
            return new Builder(new Cliente());
        }

        public static Builder from(Cliente cliente) {
            return new Builder(cliente);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder sexo(Sexo sexo) {
            entity.setSexo(sexo);
            return this;
        }

        public Builder telefone(String telefone) {
            entity.setTelefone(telefone);
            return this;
        }

        public Builder endereco(String endereco) {
            entity.setEndereco(endereco);
            return this;
        }
    }
}
