package br.com.consultoria.cadastral.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class ClienteTest {

    @Test
    public void testBuilder() {
        final String nome = "JOSE DA SILVA";
        final String telefone = "9944-5588";
        final Sexo sexo = Sexo.MASCULINO;
        final String endereco = "RUA GERAL";

        final Cliente cliente = Cliente.Builder.create()
                .nome(nome)
                .sexo(sexo)
                .telefone(telefone)
                .endereco(endereco)
                .build();
        assertNotNull(cliente);
        assertEquals(cliente.getNome(), nome);
        assertEquals(cliente.getSexo(), sexo);
        assertEquals(cliente.getTelefone(), telefone);
        assertEquals(cliente.getEndereco(), endereco);
    }
}
