package trilobite;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.junit.DropwizardAppRule;

public class TrilobiteTest {
    @Rule
    public DropwizardAppRule<TrilobiteConfiguration> app = new DropwizardAppRule<>(TrilobiteApplication.class, null);

    @Test
    public void testFoo() throws JsonParseException, JsonMappingException, IOException {
        URL url = new URL("http", "localhost", app.getLocalPort(), "");
        try (InputStream in = url.openStream()) {
            @SuppressWarnings("unchecked")
            Map<String, String> result = Jackson.newObjectMapper().readValue(in, Map.class);
            Assert.assertEquals(2, result.get("stuff"));
        }
    }
}
