package br.com.consultoria.cadastral.dto;

import br.com.consultoria.cadastral.model.Cliente;
import br.com.consultoria.cadastral.model.Sexo;
import br.com.consultoria.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClienteDto {

    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Sexo sexo;
    private String telefone;
    @NotNull
    private String endereco;

    public ClienteDto() {
    }

    public ClienteDto(final Long id, final String nome, final Sexo sexo, final String telefone, final String endereco) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public static class ClienteDtoBuilder {

        private Long id;
        private String nome;
        private Sexo sexo;
        private String telefone;
        private String endereco;
        
        private ClienteDtoBuilder(){
        }

        public ClienteDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClienteDtoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteDtoBuilder sexo(Sexo sexo) {
            this.sexo = sexo;
            return this;
        }

        public ClienteDtoBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ClienteDtoBuilder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public ClienteDto build() {
            return new ClienteDto(this.id, this.nome, this.sexo, this.telefone, this.endereco);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Cliente, ClienteDto, Cliente.Builder> {

        public static ClienteDtoBuilder builder() {
            return new ClienteDtoBuilder();
        }

        @Override
        public Cliente fromRepresentation(ClienteDto dto, Cliente.Builder builder) {
            return builder
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .sexo(dto.getSexo())
                    .telefone(dto.getTelefone())
                    .endereco(dto.getEndereco())
                    .build();
        }

        @Override
        public ClienteDto toRepresentation(Cliente cliente) {
            return builder()
                    .id(cliente.getId())
                    .nome(cliente.getNome())
                    .sexo(cliente.getSexo())
                    .telefone(cliente.getTelefone())
                    .endereco(cliente.getEndereco())
                    .build();
        }
    }
}
