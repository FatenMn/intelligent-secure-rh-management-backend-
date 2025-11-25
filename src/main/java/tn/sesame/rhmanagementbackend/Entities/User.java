package tn.sesame.rhmanagementbackend.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import tn.sesame.rhmanagementbackend.Enumerations.UserRole;

import java.rmi.server.UID;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ToString(exclude = {"password", "mfaSecret"})
@Getter @Setter
@EqualsAndHashCode(of = "email")
public class User {

    @Id
    @GeneratedValue

    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NonNull
    @Email
    private String email;

    @NonNull
    @Size(min = 8)
    @JsonIgnore
    private String password;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    private Boolean mfaEnabled;
    @JsonIgnore
    private Boolean mfaSecret;

    private Boolean emailVerified;
    private Boolean accountLocked;
    private Integer failedLoginAttempts;
    private Instant lastLoginAt;
    private Instant createdAt;
    private Instant updatedAt;
    private LocalDateTime lockedUntil;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Employee employee;
}
