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
    private Long id;
    private String nameAndSurname;
    private String username;
    private String password;
    private Roles role;
    @Nullable
    private String description = null;
    @Nullable
    private String companyId = null;
    @Nullable
    private String companyProfileImage = null;
    private List<Ticket> tickets;

    public User() {}

    
}
