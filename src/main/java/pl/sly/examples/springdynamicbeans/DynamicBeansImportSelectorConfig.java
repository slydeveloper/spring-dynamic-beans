package pl.sly.examples.springdynamicbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * A {@link @Configuration} class that activates {@link DynamicBeansImportSelector}
 * for provide configuration of {@link DynamicBeansRegistrarConfig} depends on property value.
 */
@Import(DynamicBeansImportSelector.class)
@Configuration
public class DynamicBeansImportSelectorConfig {

}
