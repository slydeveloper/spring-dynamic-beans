package pl.sly.examples.springdynamicbeans;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Collections;
import java.util.List;

/**
 * A class of {@link ImportBeanDefinitionRegistrar} type for instantiate dynamic beans
 * based on property "dynamic.beans.instance".
 */
public class DynamicBeansRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private static final String REGISTRAR_BEAN_NAME = "simpleDynamicBean";
    private static final String BIND_PROPERTIES_PREFIX = "dynamic.beans.instance";
    private static final String REGISTRAR_BEAN_PROPERTY_VALUE = "value";

    private ConfigurableEnvironment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        var valueList = Binder
                .get(environment)
                .bind(BIND_PROPERTIES_PREFIX, List.class)
                .orElseGet(Collections::emptyList);

        var index = 0;
        for (var value : valueList) {
            var genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setBeanClass(SimpleDynamicBean.class);
            genericBeanDefinition
                    .getPropertyValues()
                    .addPropertyValue(REGISTRAR_BEAN_PROPERTY_VALUE, value);
            registry.registerBeanDefinition(REGISTRAR_BEAN_NAME + index, genericBeanDefinition);
            index += 1;
        }
    }
}
