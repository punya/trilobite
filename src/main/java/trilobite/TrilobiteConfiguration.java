package trilobite;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class TrilobiteConfiguration extends Configuration {
    @NotEmpty
    public String spark = "local[3]";
}
