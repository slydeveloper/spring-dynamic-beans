package pl.sly.examples.springdynamicbeans;

import org.springframework.context.annotation.Import;

/**
 * A {@link @Configuration} class that activates {@link DynamicBeansImportSelector} that
 * activates dynamic beans.
 */
@Import(DynamicBeansRegistrar.class)
public class DynamicBeansRegistrarConfig {
}
