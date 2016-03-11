package br.com.consultoria.cadastral.resource;

import br.com.consultoria.cadastral.resource.ClienteResource;
import br.com.consultoria.util.Api;
import br.com.consultoria.cadastral.dto.ClienteDto;
import br.com.consultoria.cadastral.model.Cliente;
import br.com.consultoria.cadastral.model.Sexo;
import br.com.consultoria.util.AbstractResourceIT;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

@Test
public class ClienteResourceIT extends AbstractResourceIT {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackages(true, Cliente.class.getPackage(),
                        ClienteDto.class.getPackage(),
                        ClienteResource.class.getPackage());
    }

    @Override
    public String getURI() {
        return Api.Clientes.SELF;
    }

    @Test
    @RunAsClient
    public void testMethods() throws Exception {

        final String nome = "JOAO SILVA";
        final Sexo sexo = Sexo.MASCULINO;
        final String telefone = "9944-5588";
        final String endereco = "RUA GERAL";

        //post
        final ClienteDto clienteDto = ClienteDto.RepresentationBuilder.builder()
                .nome(nome)
                .sexo(sexo)
                .telefone(telefone)
                .endereco(endereco)
                .build();
        Response response = target.request().post(Entity.entity(clienteDto, MediaType.APPLICATION_JSON), Response.class);
        assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Cliente clienteCreated = response.readEntity(Cliente.class);
        assertNotNull(clienteCreated);

        //find all
        response = target.request().get();
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

        //put
        final String nomeAlterado = "JOAO DA SILVA E SILVA";
        Cliente clienteAlterado = Cliente.Builder.from(clienteCreated)
                .nome(nomeAlterado)
                .build();

        //TODO: Ajustar para buscar pelo parametro {id}
        WebTarget targetResource = target.path(clienteCreated.getId().toString());

        response = targetResource.request().put(Entity.entity(clienteAlterado, MediaType.APPLICATION_JSON));
        assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Cliente clienteResponseUpdated = response.readEntity(Cliente.class);
        assertNotNull(clienteResponseUpdated);
        assertEquals(clienteResponseUpdated.getNome(), nomeAlterado);

        //delete
        response = targetResource.request().delete();
        assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());

        //find
        response = targetResource.request().get();
        assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

}
