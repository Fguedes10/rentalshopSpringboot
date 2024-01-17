package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mindera.bootcamp.rentalshop.utilMessages.Message;

public record ClientPatchDto(


        @NotBlank(message = Message.BLANK_FIRSTNAME)
        @Pattern(regexp = "[a-zA-Z]", message = Message.INVALID_FIRSTNAME)
        String firstName,
        @NotBlank(message = Message.BLANK_LASTNAME)
        @Pattern(regexp = "^[a-zA-Z_]+$", message = Message.INVALID_LASTNAME)
        String lastName,

        @NotBlank(message = Message.BLANK_EMAIL)
        String email

) {
}
