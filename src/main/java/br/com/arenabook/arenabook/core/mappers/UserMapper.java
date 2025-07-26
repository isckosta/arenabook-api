package br.com.arenabook.arenabook.core.mappers;

import br.com.arenabook.arenabook.core.enums.Role;
import br.com.arenabook.arenabook.core.models.User;
import br.com.arenabook.arenabook.web.user.dtos.UserRequest;
import br.com.arenabook.arenabook.web.user.dtos.UserResponse;

public class UserMapper {

    public static User toEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(
                request.getRole() != null
                        ? request.getRole()
                        : Role.PLAYER);
        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
}
