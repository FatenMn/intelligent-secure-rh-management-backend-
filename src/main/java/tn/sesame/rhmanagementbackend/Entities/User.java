package tn.sesame.rhmanagementbackend.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import tn.sesame.rhmanagementbackend.Enumerations.UserRole;

import java.rmi.server.UID;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true) // appel getter setter sans utiliser prefixe get and set
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of") //
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UID id ; //uid plus strong
    @NonNull
    @Email
    String email;
    @NonNull
    @Size(min = 8 )
    String password;
     Set<UserRole> roles=new HashSet<>();
     Boolean mfaEnabled;
     Boolean mfaSecret ;
    //private List webauthn-Credentials<WebAuthentication>
      Boolean emailVerified;
    Boolean accountLocked;
     Integer failedLoginAttempts;
     Instant LastLoginAt;
     Instant createdAt;
      Instant updatedAt;



}
