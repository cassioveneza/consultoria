package br.com.consultoria.cadastral.dto;

import br.com.consultoria.cadastral.model.Cliente;
import br.com.consultoria.cadastral.model.Sexo;
import br.com.consultoria.cadastral.model.Telefone;
import br.com.consultoria.util.AbstractRepresentationBuilder;
import br.com.consultoria.util.CollectionsBuilder;
import java.time.LocalDate;
import java.util.Collection;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClienteDto {

    private Long id;
    private String nome;
    private String nomeInss;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String endereco;
    private String observacoes;
    private Collection<TelefoneDto> telefones = CollectionsBuilder.createDefaultArrayList();

    public ClienteDto() {
    }

    public ClienteDto(final Long id, final String nome, final String nomeInss, final Sexo sexo, final LocalDate dataNascimento,
            final String cpf, final String rg, final String endereco, final String observacoes, final Collection<TelefoneDto> telefones) {
        this.id = id;
        this.nome = nome;
        this.nomeInss = nomeInss;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.observacoes = observacoes;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeInss() {
        return nomeInss;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Collection<TelefoneDto> getTelefones() {
        return telefones;
    }

    public static class ClienteDtoBuilder {

        private Long id;
        private String nome;
        private String nomeInss;
        private Sexo sexo;
        private LocalDate dataNascimento;
        private String cpf;
        private String rg;
        private String endereco;
        private String observacoes;
        private Collection<TelefoneDto> telefones = CollectionsBuilder.createDefaultArrayList();

        private ClienteDtoBuilder() {
        }

        public ClienteDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ClienteDtoBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteDtoBuilder nomeInss(final String nomeInss) {
            this.nomeInss = nomeInss;
            return this;
        }

        public ClienteDtoBuilder sexo(final Sexo sexo) {
            this.sexo = sexo;
            return this;
        }

        public ClienteDtoBuilder dataNascimento(final LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public ClienteDtoBuilder cpf(final String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClienteDtoBuilder rg(final String rg) {
            this.rg = rg;
            return this;
        }

        public ClienteDtoBuilder endereco(final String endereco) {
            this.endereco = endereco;
            return this;
        }

        public ClienteDtoBuilder observacoes(final String observacoes) {
            this.observacoes = observacoes;
            return this;
        }

        public ClienteDtoBuilder telefones(final Collection<TelefoneDto> telefones) {
            this.telefones = telefones;
            return this;
        }

        public ClienteDtoBuilder adicionarTelefone(final String ddd, final String numero) {
            this.telefones.add(TelefoneDto.RepresentationBuilder.builder().ddd(ddd).numero(numero).build());
            return this;
        }

        public ClienteDto build() {
            return new ClienteDto(this.id, this.nome, this.nomeInss, this.sexo, this.dataNascimento, this.cpf,
                    this.rg, this.endereco, this.observacoes, this.telefones);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Cliente, ClienteDto, Cliente.Builder> {

        public static ClienteDtoBuilder builder() {
            return new ClienteDtoBuilder();
        }

        @Override
        public Cliente fromRepresentation(final ClienteDto dto, final Cliente.Builder builder) {
            return builder
                    .nome(dto.getNome())
                    .nomeInss(dto.getNomeInss())
                    .sexo(dto.getSexo())
                    .dataNascimento(dto.getDataNascimento())
                    .cpf(dto.getCpf())
                    .rg(dto.getRg())
                    .endereco(dto.getEndereco())
                    .observacoes(dto.getObservacoes())
                    .mergeTelefones(dto.getTelefones())
                    .build();
        }

        @Override
        public ClienteDto toRepresentation(final Cliente cliente) {
            return builder()
                    .id(cliente.getId())
                    .nome(cliente.getNome())
                    .nomeInss(cliente.getNomeInss())
                    .sexo(cliente.getSexo())
                    .dataNascimento(cliente.getDataNascimento())
                    .cpf(cliente.getCpf())
                    .rg(cliente.getRg())
                    .endereco(cliente.getEndereco())
                    .observacoes(cliente.getObservacoes())
//                    .telefones(telefoneDtoBuilder.toRepresentation(cliente.getTelefones()))
                    .build();
        }
    }
}
