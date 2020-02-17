package valatava.lab.warehouse.model.dto;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * A DTO representing a user, with his authorities.
 *
 * @author Yuriy Govorushkin
 */
@Data
public class UserDTO {

    private Long id;

    @NotBlank
    private String login;

    @Email
    private String email;

    private String firstName;
    private String lastName;
    private boolean activated = false;
    private Set<String> authorities;
}
