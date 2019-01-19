package ir.geeglo.dev.opencup.serverapp.orm.logic;

import ir.geeglo.dev.opencup.serverapp.orm.dao.PersistenceSpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceSpringConfig.class)
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class GeegloLogicSpringConfig {
}
