package valatava.lab.warehouse.model.vm;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * View Model object for storing a user's credentials.
 *
 * @author Yuriy Govorushkin
 */
@Data
public class LoginVM {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
