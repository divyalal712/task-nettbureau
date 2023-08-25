package no.nettbureau.task.nettbureautask.model.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostalCode {
    private String postal_code;
    private String city;
    private String municipalityId;
    private String county;
    private String po_box;
    private String latitude;
    private String longitude;
}
