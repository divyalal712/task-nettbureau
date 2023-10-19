package no.task.registrationform.service;

import no.task.registrationform.dao.UserInfoEntity;
import no.task.registrationform.dao.UserInfoRepository;
import no.task.registrationform.model.RegRequest;
import no.task.registrationform.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userRepository;

    public Long saveUser(RegRequest request) {
        UserInfoEntity entity = new UserInfoEntity();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setAddress(request.getAddress());
        entity.setCity(request.getCity());
        entity.setPostalCode(request.getPostalCode());
        entity.setCountry(request.getCountry());
        UserInfoEntity userInfoEntity = userRepository.save(entity);
        return userInfoEntity.getId();
    }


    public UserInfo getUserInfo(Long userId) {

        Optional<UserInfoEntity> userById = userRepository.findById(userId);
        UserInfo user = null;
        if(userById.isPresent()) {
            UserInfoEntity userInfoEntity = userById.get();
            user = new UserInfo();
            user.setFirstName(userInfoEntity.getFirstName());
            user.setLastName(userInfoEntity.getLastName());
            user.setPhoneNumber(userInfoEntity.getPhoneNumber());
            user.setEmail(userInfoEntity.getEmail());
            user.setUserId(userInfoEntity.getId());
            user.setAddress(userInfoEntity.getAddress());
            user.setCity(userInfoEntity.getCity());
            user.setPostalCode(userInfoEntity.getPostalCode());
            user.setCountry(userInfoEntity.getCountry());
        }
        return user;
    }
}
