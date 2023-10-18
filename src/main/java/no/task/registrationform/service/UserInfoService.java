package no.task.registrationform.service;

import no.task.registrationform.dao.UserInfoEntity;
import no.task.registrationform.dao.UserInfoRepository;
import no.task.registrationform.model.RegRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userRepository;

    public UserInfoEntity saveUser(RegRequest request) {
        UserInfoEntity entity = new UserInfoEntity();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setAddress(request.getAddress());
        entity.setCity(request.getCity());
        entity.setPostalCode(request.getPostalCode());
        entity.setCountry(request.getCountry());
        return userRepository.save(entity);
    }
}
