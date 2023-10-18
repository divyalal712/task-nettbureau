package no.task.registrationform.controller;

import jakarta.validation.Valid;
import no.task.registrationform.model.RegRequest;
import no.task.registrationform.service.PostalCodeService;
import no.task.registrationform.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class RegController {

    @Autowired
    private PostalCodeService service;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/form-data")
    public ResponseEntity<String> createUser(@RequestBody @Valid RegRequest request) {

        boolean isValidPostalCode = service.validatePostalCode(request.getCountry(), request.getPostalCode());
        if (isValidPostalCode) {
            userInfoService.saveUser(request);
        } else {
           return ResponseEntity.badRequest().body("Postal code provide is not valid");
        }
        return ResponseEntity.ok("User created successfully");
    }
}
