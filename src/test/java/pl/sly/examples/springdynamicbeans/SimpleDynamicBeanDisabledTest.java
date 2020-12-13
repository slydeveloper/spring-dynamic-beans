package pl.sly.examples.springdynamicbeans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(
		properties = { "dynamic.beans.enabled=false" })
class SimpleDynamicBeanDisabledTest {

	@Autowired(required = false)
	private List<SimpleDynamicBean> simpleDynamicBeans;

	/**
	 * Verify if dynamic beans are turned off.
	 */
	@Test
	public void simpleDynamicBeans_whenDynamicBeansDisabled_thenSuccess() {
		assertNull(simpleDynamicBeans);
	}
}
