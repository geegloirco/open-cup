package ir.geeglo.dev.opencup.serverapp.orm.logic;

import ir.geeglo.dev.opencup.serverapp.orm.dao.GeegloBaseDao;
import ir.geeglo.dev.opencup.serverapp.orm.entity.UserInfoEntity;
import ir.geeglo.dev.opencup.serverapp.orm.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserLogic {

    @Autowired
    @Qualifier("GeegloBaseDao")
    private GeegloBaseDao geegloBaseDao;

    public UserEntity selectByGmail(String gmail) {
        return (UserEntity) geegloBaseDao.findByCondition(
                UserEntity.class, "gmail", gmail);
    }

    public UserEntity selectByMobile(String mobile) {
        return (UserEntity) geegloBaseDao.findByCondition(
                UserEntity.class, "mobile", mobile);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void removeInfo(String mobile) {
        UserEntity userEntity = (UserEntity) geegloBaseDao.findByCondition(
                UserEntity.class, "mobile", mobile);
        userEntity.getUserInfos().remove(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(
            UserEntity userEntity,
            UserInfoEntity infoEntity) {

        geegloBaseDao.insert(userEntity);
        infoEntity.setUser(userEntity);
        geegloBaseDao.insert(infoEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(UserEntity userEntity) {
        geegloBaseDao.update(userEntity);
//        userRepo.save(userEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addInfo(UserEntity userEntity, UserInfoEntity infoEntity) {
        userEntity.addUserInfo(infoEntity);
        geegloBaseDao.update(userEntity);
    }
}
