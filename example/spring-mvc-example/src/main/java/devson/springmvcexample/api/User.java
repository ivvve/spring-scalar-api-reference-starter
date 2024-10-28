package devson.springmvcexample.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User schema")
public record User(
    @Schema(description = "id") long id,
    @Schema(description = "Name of the user") String name,
    @Schema(description = "Email address of the user") String email,
    @Schema(description = "City where the user lives")  String city,
    @Schema(description = "Is the user active") boolean isActive
) {
}
