package no.task.registrationform.controller;

import jakarta.validation.Valid;
import no.task.registrationform.model.RegRequest;
import no.task.registrationform.model.UserInfo;
import no.task.registrationform.service.PostalCodeService;
import no.task.registrationform.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class RegistrationController {

    @Autowired
    private PostalCodeService service;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/form-data")
    public ResponseEntity<String> createUser(@RequestBody @Valid RegRequest request) {

        boolean isValidPostalCode = service.validatePostalCode(request.getCountry(), request.getPostalCode());
        if (isValidPostalCode) {
            Long userId = userInfoService.saveUser(request);
            return ResponseEntity.ok(userId.toString());
        } else {
           return ResponseEntity.badRequest().body("Postal code provide is not valid");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable("userId") Long userId) {
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        return ResponseEntity.ok(userInfo);
    }
}
