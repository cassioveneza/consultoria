package br.com.consultoria.cadastral.model;

import br.com.consultoria.cadastral.dto.TelefoneDto;
import br.com.consultoria.util.AbstractBuilder;
import br.com.consultoria.util.AbstractEntityId;
import br.com.consultoria.util.CollectionsBuilder;
import com.google.common.collect.ImmutableSet;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "CLIENTES")
public class Cliente implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;
    @NotNull
    @Size(max = 100)
    @Column(name = "NOME_INSS")
    private String nomeInss;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private Sexo sexo;
    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @NotNull
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones = CollectionsBuilder.createDefaultArrayList();

    private Cliente() {
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(final String nome) {
        this.nome = nome;
    }

    public String getNomeInss() {
        return nomeInss;
    }

    private void setNomeInss(final String nomeInss) {
        this.nomeInss = nomeInss;
    }

    public Sexo getSexo() {
        return sexo;
    }

    private void setSexo(final Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    private void setDataNascimento(final LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    private void setRg(final String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    private void setObservacoes(final String observacoes) {
        this.observacoes = observacoes;
    }

    public Collection<Telefone> getTelefones() {
        return telefones;
    }

    private void addTelefone(final String ddd, final String numero) {
        addTelefone(Telefone.Builder.create().ddd(ddd).numero(numero).build());
    }

    private void addTelefone(final Telefone telefone) {
        telefone.setCliente(this);
        this.telefones.add(telefone);
    }

    private void removeTelefone(final Telefone telefone) {
        this.telefones.remove(telefone);
    }

    public static class Builder extends AbstractBuilder<Cliente, Builder> {

        @Inject
        private TelefoneRepository telefoneRepository;

        private Builder(final Cliente cliente) {
            super(cliente);
        }

        public static Builder create() {
            return new Builder(new Cliente());
        }

        public static Builder from(final Cliente cliente) {
            return new Builder(cliente);
        }

        public Builder id(final Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(final String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder nomeInss(final String nomeInss) {
            entity.setNomeInss(nomeInss);
            return this;
        }

        public Builder sexo(final Sexo sexo) {
            entity.setSexo(sexo);
            return this;
        }

        public Builder dataNascimento(final LocalDate dataNascimento) {
            entity.setDataNascimento(dataNascimento);
            return this;
        }

        public Builder cpf(final String cpf) {
            entity.setCpf(cpf);
            return this;
        }

        public Builder rg(final String rg) {
            entity.setRg(rg);
            return this;
        }

        public Builder endereco(final String endereco) {
            entity.setEndereco(endereco);
            return this;
        }

        public Builder observacoes(final String observacoes) {
            entity.setObservacoes(observacoes);
            return this;
        }

        public Builder adicionaTelefone(final String ddd, final String numero) {
            entity.addTelefone(ddd, numero);
            return this;
        }

        public Builder removeTelefone(final Telefone telefone) {
            entity.removeTelefone(telefone);
            return this;
        }

        //TODO redefinir merge para não ter dependência do DTO no modelo
        public Builder mergeTelefones(final Collection<TelefoneDto> telefonesDto) {
            final Collection<Telefone> telefonesOriginais = ImmutableSet.copyOf(entity.telefones);

            telefonesDto.stream().forEach(dto -> {
                if (telefonesOriginais.stream().noneMatch(t -> t.getDDD().equals(dto.getDDD()) && t.getNumero().equals(dto.getNumero()))) {
                    adicionaTelefone(dto.getDDD(), dto.getNumero());
//                } else {
//                    final Telefone telefone = telefoneRepository.findByClienteDddENumero(entity.getId(), dto.getDDD(), dto.getNumero());
//                    Telefone.Builder.from(telefone).
                }
            }
            );

            telefonesOriginais.forEach(this::removeTelefone);
            return this;
        }
    }
}
