package no.task.registrationform.model.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BringsResponse {

    private List<PostalCode> postal_codes;
}
