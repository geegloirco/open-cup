package ir.geeglo.dev.opencup.serverapp.service;

import ir.geeglo.dev.opencup.serverapp.OpenCupMainApp;
import ir.geeglo.dev.opencup.serverapp.orm.OrmLogicProvider;
import ir.geeglo.dev.opencup.serverapp.orm.entity.UserEntity;
import ir.geeglo.dev.opencup.serverapp.orm.entity.UserInfoEntity;
import ir.geeglo.dev.opencup.serverapp.orm.logic.GeegloLogicSpringConfig;
import ir.piana.dev.core.annotation.Handler;
import ir.piana.dev.core.annotation.HandlerType;
import ir.piana.dev.core.annotation.MethodHandler;
import ir.piana.dev.core.response.PianaResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mohammad Rahmati, 1/15/2019
 */
@Handler(baseUrl = "open-cup/user", handlerType = HandlerType.METHOD_HANDLER)
public class UserService {
    @MethodHandler
    public static PianaResponse saveUser(
            @QueryParam("mobile-no") String mobileNo,
            @QueryParam("password") String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setMobile(mobileNo);
        userEntity.setPassword(password);
        userEntity.setEnterDate(new Timestamp(System.currentTimeMillis()));
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUser(userEntity);
        userEntity.setUserInfos(Arrays.asList(userInfoEntity));

        OpenCupMainApp.logicProvider.getUserLogic()
                .save(userEntity, userInfoEntity);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("response-code", 0);
        return new PianaResponse(Response.Status.OK, map);
    }

    @MethodHandler
    @Path("remove-info")
    public static PianaResponse removeInfo(
            @QueryParam("mobile-no") String mobileNo) {

        OpenCupMainApp.logicProvider
                .getUserLogic()
                .removeInfo(mobileNo);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("response-code", 0);
        return new PianaResponse(Response.Status.OK, map);
    }

    @MethodHandler
    @Path("add-info")
    public static PianaResponse addInfo(
            @QueryParam("mobile-no") String mobileNo) {

        UserEntity userEntity = OpenCupMainApp.logicProvider
                .getUserLogic().selectByMobile(mobileNo);

        OpenCupMainApp.logicProvider
                .getUserLogic()
                .addInfo(userEntity, new UserInfoEntity());

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("response-code", 0);
        return new PianaResponse(Response.Status.OK, map);
    }
}
