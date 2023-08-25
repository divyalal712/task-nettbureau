package no.nettbureau.task.nettbureautask.service;

import no.nettbureau.task.nettbureautask.exception.BringsException;
import no.nettbureau.task.nettbureautask.model.external.BringsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostalCodeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.brings.url}")
    private String apiUrl;

    @Value("${api.uid}")
    private String apiUid;

    @Value("${api.key}")
    private String apiKey;


    public boolean validatePostalCode(String country, String postalCode) {
        String formattedUrl = String.format(apiUrl, country, postalCode);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Mybring-API-Uid", apiUid);
        headers.set("X-Mybring-API-Key", apiKey);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<BringsResponse> responseEntity = restTemplate.exchange(
                formattedUrl,
                HttpMethod.GET,
                httpEntity,
                BringsResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            BringsResponse response = responseEntity.getBody();
            if (!response.getPostal_codes().isEmpty()) {
                return true;
            }
            return false;
        } else {
            throw new BringsException(responseEntity.getStatusCode(), "External API returned an error");
        }
    }
}
