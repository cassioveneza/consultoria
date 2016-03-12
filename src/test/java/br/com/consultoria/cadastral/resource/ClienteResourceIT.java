package br.com.consultoria.cadastral.resource;

import br.com.consultoria.cadastral.dto.ClienteDto;
import br.com.consultoria.cadastral.model.Cliente;
import br.com.consultoria.cadastral.model.Sexo;
import br.com.consultoria.util.AbstractResourceIT;
import br.com.consultoria.util.Api;
import br.com.consultoria.util.ResponseStatus;
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
        final String nomeInss = "JOAO";
        final String endereco = "RUA GERAL";
        final Sexo sexo = Sexo.MASCULINO;

        //post
        final ClienteDto clienteDto = ClienteDto.RepresentationBuilder.builder()
                .nome(nome)
                .nomeInss(nomeInss)
                .sexo(sexo)
                .endereco(endereco)
                .build();
        Response response = target.request().post(Entity.entity(clienteDto, MediaType.APPLICATION_JSON), Response.class);
        assertEquals(response.getStatus(), ResponseStatus.CREATED);

        Cliente clienteCreated = response.readEntity(Cliente.class);
        assertNotNull(clienteCreated);

        //find all
        response = target.request().get();
        assertEquals(response.getStatus(), ResponseStatus.OK);

        //put
        final String nomeAlterado = "JOAO DA SILVA E SILVA";
        Cliente clienteAlterado = Cliente.Builder.from(clienteCreated)
                .nome(nomeAlterado)
                .build();

        //TODO: Ajustar para buscar pelo parametro {id}
        WebTarget targetResource = target.path(clienteCreated.getId().toString());

        response = targetResource.request().put(Entity.entity(clienteAlterado, MediaType.APPLICATION_JSON));
        assertEquals(response.getStatus(), ResponseStatus.CREATED);

        Cliente clienteResponseUpdated = response.readEntity(Cliente.class);
        assertNotNull(clienteResponseUpdated);
        assertEquals(clienteResponseUpdated.getNome(), nomeAlterado);

        //delete
        response = targetResource.request().delete();
        assertEquals(response.getStatus(), ResponseStatus.NO_CONTENT);

        //find
        //TODO Verificar tratamento do EntityNotFoundException 
//        response = targetResource.request().get();
//        assertEquals(response.getStatus(), ResponseStatus.NOT_FOUND);
    }

}
