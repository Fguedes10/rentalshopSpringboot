package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.constraints.NotBlank;
import mindera.bootcamp.rentalshop.utilMessages.Message;

public record ClientGetDto(

        String firstName,
        String lastName,
        String email

) {
}
