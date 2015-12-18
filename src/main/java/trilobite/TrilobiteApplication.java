package trilobite;

import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TrilobiteApplication extends Application<TrilobiteConfiguration> {
    public static void main(String[] args) throws Exception {
        new TrilobiteApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TrilobiteConfiguration> bootstrap) {
        // nothing
    }

    @Override
    public void run(TrilobiteConfiguration configuration, Environment environment) throws Exception {
        SparkContext spark = new SparkContext(configuration.spark, "Trilobite");
        SQLContext sql = new SQLContext(spark);
        environment.jersey().register(new TrilobiteResource(sql));
    }

}
