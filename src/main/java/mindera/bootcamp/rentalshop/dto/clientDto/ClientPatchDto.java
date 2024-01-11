package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import mindera.bootcamp.rentalshop.utilMessages.Message;

public record ClientPatchDto(

        //@Pattern(regexp = "[0-9]", message = Message.INVALID_FIRSTNAME)
        @NotBlank(message = Message.BLANK_FIRSTNAME)
        String firstName,
        //@Pattern(regexp = "[0-9]", message = Message.INVALID_LASTNAME)
        @NotBlank(message = Message.BLANK_LASTNAME)
        String lastName,

        @NotBlank(message = Message.BLANK_EMAIL)
        String email

) {
}
