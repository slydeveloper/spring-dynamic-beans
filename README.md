Spring Dynamic Beans Example
============================
Here is very simple example how to dynamically create Beans in the Spring Framework.

HOWTO
-----
- The project based on `ImportBeanDefinitionRegistrar` class.
- An optional feature is `ImportSelector` for disable/enable create of dynamic Beans, 
based on property `dynamic.beans.enabled`.
- Check Unit Test files to see how it's working.

Config
-----
```
# [OPTIONAL] dynamic beans enable/disable
dynamic.beans.enabled=true

# dynamic beans definition
dynamic.beans.instance[0]=myBeanValue1
dynamic.beans.instance[1]=myBeanValue2
```