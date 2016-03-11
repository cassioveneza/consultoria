package br.com.consultoria.util;

import java.net.URI;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.testng.annotations.BeforeClass;

public abstract class AbstractResourceIT {

    protected WebTarget target;

    @BeforeClass
    protected void createClient() {
        target = ClientBuilder.newClient().target(URI.create(getURI()));
    }

    public abstract String getURI();

}