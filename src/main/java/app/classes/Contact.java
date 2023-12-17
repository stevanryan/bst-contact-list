package app.classes;


import lombok.Data;

@Data
public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private String birthDate;
}
