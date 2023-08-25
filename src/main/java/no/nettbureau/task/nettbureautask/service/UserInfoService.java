package no.nettbureau.task.nettbureautask.service;

import no.nettbureau.task.nettbureautask.dao.UserInfoEntity;
import no.nettbureau.task.nettbureautask.dao.UserInfoRepository;
import no.nettbureau.task.nettbureautask.model.NettBureauRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userRepository;

    public UserInfoEntity saveUser(NettBureauRequest request) {
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
