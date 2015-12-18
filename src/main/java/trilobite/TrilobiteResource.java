package trilobite;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.spark.sql.SQLContext;

@Path("/")
public class TrilobiteResource {
    private SQLContext sql;

    public TrilobiteResource(SQLContext sql) {
        this.sql = sql;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String stuff() {
        return sql.sql("SELECT 1 + 1 AS stuff").toJSON().first();
    }
}
