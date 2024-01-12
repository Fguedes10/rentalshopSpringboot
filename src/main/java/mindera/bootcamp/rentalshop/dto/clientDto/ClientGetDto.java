package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.constraints.NotBlank;
import mindera.bootcamp.rentalshop.utilMessages.Message;

public record ClientGetDto(

        @NotBlank(message = Message.BLANK_FIRSTNAME)
        String firstName,
        @NotBlank(message = Message.BLANK_LASTNAME)
        String lastName,
        @NotBlank(message = Message.BLANK_EMAIL)
        String email

) {
}
