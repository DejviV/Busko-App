package com.busko.Models;

import com.busko.Models.Enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.lang.Nullable;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String NameAndSurname;
    private String Username;
    private String Password;
    private Roles Role;
    @Nullable
    private String Description = null;
    @Nullable
    private String CompanyID = null;
    @Nullable
    private String CompanyProfileImage = null;
    private List<Ticket> tickets;

    public User() {}

    //Inspector & driver
    public User(String nameAndSurname, String username, String password, Roles role, String CompanyID) {
        this.NameAndSurname = nameAndSurname;
        this.Username = username;
        this.Password = password;
        this.Role = role;
        this.CompanyID = CompanyID;
    }

    //Company
    public User(String nameAndSurname, String username, String password, Roles role, String Description, String ProfileImage) {
        this.NameAndSurname = nameAndSurname;
        this.Username = username;
        this.Password = password;
        this.Role = role;
        this.Description = Description;
        this.CompanyProfileImage = ProfileImage;
    }
    //Traveler
    public User(String nameAndSurname, String username, String password, Roles role) {
        this.NameAndSurname = nameAndSurname;
        this.Username = username;
        this.Password = password;
        this.Role = role;
    }
}
