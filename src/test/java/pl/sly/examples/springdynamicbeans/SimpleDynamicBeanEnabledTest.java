package pl.sly.examples.springdynamicbeans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        properties = {"dynamic.beans.enabled=true"})
class SimpleDynamicBeanEnabledTest {

    @Autowired
    private List<SimpleDynamicBean> simpleDynamicBeans;

    /**
     * Verify if dynamic beans are turned on.
     */
    @Test
    public void simpleDynamicBeans_whenDynamicBeansDisabled_thenSuccess() {
        assertNotNull(simpleDynamicBeans);
        assertEquals(2, simpleDynamicBeans.size());

        for (var bean : simpleDynamicBeans) {
            assertTrue(bean.getValue().startsWith("myBeanValue"));
        }
    }
}
