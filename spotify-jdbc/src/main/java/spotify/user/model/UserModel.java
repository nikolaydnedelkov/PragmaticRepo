package spotify.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserModel {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private boolean hasPaidApp;

}
