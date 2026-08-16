package com.kiran.UserManagementSystem.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Schema(
        name = "User Request",
        description = "it is the object user to communicate with user"
)
public class UserDTO {
    @Schema(
            name = "user full name",
            description = "we should enter user full name as text",
            example = "kiran sri sai"
    )
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
}
