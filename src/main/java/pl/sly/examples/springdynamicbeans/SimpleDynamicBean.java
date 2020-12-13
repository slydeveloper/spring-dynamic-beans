package pl.sly.examples.springdynamicbeans;

/**
 * A class of bean which will be instantiated by {@link DynamicBeansRegistrar}.
 */
public class SimpleDynamicBean {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SimpleDynamicBean{" +
                "value='" + value + '\'' +
                '}';
    }
}
