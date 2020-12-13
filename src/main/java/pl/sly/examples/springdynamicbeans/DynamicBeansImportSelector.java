package pl.sly.examples.springdynamicbeans;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * A class that activates @{@link Configuration} of {@link DynamicBeansRegistrarConfig}
 * when "dynamic.beans.enabled" is set to "true".
 */
public class DynamicBeansImportSelector implements ImportSelector, EnvironmentAware {

    private static final String BIND_PROPERTIES_PREFIX = "dynamic.beans.enabled";

    private ConfigurableEnvironment environment;

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        var dynamicBeansEnabled = Binder
                .get(environment)
                .bind(BIND_PROPERTIES_PREFIX, Boolean.class)
                .orElseGet(() -> Boolean.TRUE);

        // activate DynamicBeansRegistrarConfig when dynamic beans enabled.
        if (dynamicBeansEnabled) {
            return new String[]{DynamicBeansRegistrarConfig.class.getName()};
        }

        return new String[0];
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }
}
