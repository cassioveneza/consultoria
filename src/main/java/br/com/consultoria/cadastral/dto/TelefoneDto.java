package br.com.consultoria.cadastral.dto;

import br.com.consultoria.cadastral.dto.TelefoneDto.TelefoneDtoBuilder;
import br.com.consultoria.cadastral.model.Telefone;
import br.com.consultoria.util.AbstractRepresentationBuilder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TelefoneDto {

    private String ddd;
    private String numero;

    public TelefoneDto() {
    }

    public TelefoneDto(final String ddd, final String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDDD() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public static class TelefoneDtoBuilder {

        private String ddd;
        private String numero;

        private TelefoneDtoBuilder() {
        }

        public TelefoneDtoBuilder ddd(final String ddd) {
            this.ddd = ddd;
            return this;
        }

        public TelefoneDtoBuilder numero(final String numero) {
            this.numero = numero;
            return this;
        }

        public TelefoneDto build() {
            return new TelefoneDto(this.ddd, this.numero);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Telefone, TelefoneDto, Telefone.Builder> {

        public static TelefoneDtoBuilder builder() {
            return new TelefoneDtoBuilder();
        }

        @Override
        public Telefone fromRepresentation(final TelefoneDto dto, final Telefone.Builder builder) {
            return builder
                    .ddd(dto.getDDD())
                    .numero(dto.getNumero())
                    .build();
        }

        @Override
        public TelefoneDto toRepresentation(final Telefone telefone) {
            return builder()
                    .ddd(telefone.getDDD())
                    .numero(telefone.getNumero())
                    .build();
        }
    }
}
