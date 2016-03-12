package br.com.consultoria.cadastral.model;

import java.time.LocalDate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class ClienteTest {

    @Test
    public void testBuilder() {
        final String nome = "JOSE DA SILVA";
        final String nomeInss = "JOSE";
        final Sexo sexo = Sexo.MASCULINO;
        final LocalDate dataNascimento = LocalDate.of(1950, 01, 01);
        final String cpf = "12345678911";
        final String rg = "41112-3";
        final String endereco = "RUA GERAL, NOVA VENEZA";
        final String observacoes = "REGULARIZADO";

        final Cliente cliente = Cliente.Builder.create()
                .nome(nome)
                .nomeInss(nomeInss)
                .sexo(sexo)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .rg(rg)
                .endereco(endereco)
                .observacoes(observacoes)
                .build();
        assertNotNull(cliente);
        assertEquals(cliente.getNome(), nome);
        assertEquals(cliente.getNomeInss(), nomeInss);
        assertEquals(cliente.getSexo(), sexo);
        assertEquals(cliente.getDataNascimento(), dataNascimento);
        assertEquals(cliente.getCpf(), cpf);
        assertEquals(cliente.getRg(), rg);
        assertEquals(cliente.getEndereco(), endereco);
        assertEquals(cliente.getObservacoes(), observacoes);
    }
}
