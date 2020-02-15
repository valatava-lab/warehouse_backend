package valatava.lab.warehouse.model.vm;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginVM {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
