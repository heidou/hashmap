package com.lm.service;

/**
 * Created by Administrator on 2016/5/6.
 */
 import java.util.List;
 import com.lm.entity.UserEntity;

public interface UserService {
    UserEntity getUserEntityById(String userId);
    List<UserEntity> getUserEntities();
    UserEntity inserUserEntity(UserEntity userEntity);

}
