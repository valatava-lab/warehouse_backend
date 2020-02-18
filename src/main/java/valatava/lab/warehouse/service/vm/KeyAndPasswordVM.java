package valatava.lab.warehouse.service.vm;

import lombok.Data;

/**
 * View Model object for storing the user's key and password.
 *
 * @author Yuriy Govorushkin
 */
@Data
public class KeyAndPasswordVM {

    private String key;
    private String newPassword;
}
