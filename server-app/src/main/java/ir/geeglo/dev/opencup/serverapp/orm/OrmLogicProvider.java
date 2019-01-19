package ir.geeglo.dev.opencup.serverapp.orm;

import ir.geeglo.dev.opencup.serverapp.orm.logic.GeegloLogicSpringConfig;
import ir.geeglo.dev.opencup.serverapp.orm.logic.UserLogic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mohammad Rahmati, 10/14/2018
 */
public class OrmLogicProvider {
    protected ApplicationContext applicationContext;
    protected static OrmLogicProvider ormServiceProvider;

    private OrmLogicProvider() {
    }

    public static synchronized OrmLogicProvider register(
            AnnotationConfigApplicationContext applicationContext) {
        if(ormServiceProvider == null) {
            ormServiceProvider = new OrmLogicProvider();
            applicationContext.register(GeegloLogicSpringConfig.class);
            ormServiceProvider.applicationContext = applicationContext;
        }
        return ormServiceProvider;
    }

    public UserLogic getUserLogic() {
        return applicationContext.getBean(UserLogic.class);
    }
}
