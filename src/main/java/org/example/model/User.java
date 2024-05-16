package org.example.model;


import lombok.*;
import org.example.enums.UserState;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class User extends BaseModel {
    private Long chatId;
    private String firstName;
    private String lastName;
    private String username;
    private UserState state;
}
