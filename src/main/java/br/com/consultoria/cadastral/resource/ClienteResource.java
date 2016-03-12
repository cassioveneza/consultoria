package br.com.consultoria.cadastral.resource;

import br.com.consultoria.cadastral.dto.ClienteDto;
import br.com.consultoria.cadastral.model.Cliente;
import br.com.consultoria.cadastral.model.ClienteRepository;
import br.com.consultoria.cadastral.model.ClienteService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("clientes")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class ClienteResource {

    @Inject
    private ClienteRepository clienteRepository;
    @Inject
    private ClienteService clienteService;
    @Inject
    private ClienteDto.RepresentationBuilder clienteDtoBuilder;

    private Cliente getCliente(final Long id) {
        return clienteRepository.findByOrElseThrow(id);
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id) {
        return Response.ok(clienteDtoBuilder.toRepresentation(getCliente(id))).build();
    }

    @GET
    public Response findAll() {
        final List<Cliente> clientes = clienteRepository.findAll();
        return Response.ok(clienteDtoBuilder.toRepresentation(clientes)).build();
    }

    @POST
    public Response create(final ClienteDto dto) {
        final Cliente cliente = clienteService.persist(clienteDtoBuilder.fromRepresentation(dto, Cliente.Builder.create()));
        final ClienteDto clienteDto = clienteDtoBuilder.toRepresentation(cliente);
        return Response.created(null).entity(clienteDto).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final ClienteDto dto) {
        final Cliente cliente = clienteDtoBuilder.fromRepresentation(dto, Cliente.Builder.from(getCliente(id)));
        return Response.created(null).entity(clienteDtoBuilder.toRepresentation(clienteService.merge(cliente))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        clienteService.remove(getCliente(id));
        return Response.noContent().build();
    }
}
