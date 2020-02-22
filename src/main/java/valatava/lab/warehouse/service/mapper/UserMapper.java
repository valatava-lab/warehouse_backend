package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.User;
import valatava.lab.warehouse.service.dto.UserDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface UserMapper {

    List<UserDTO> toUserDTOs(List<User> users);

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDto);
    }
