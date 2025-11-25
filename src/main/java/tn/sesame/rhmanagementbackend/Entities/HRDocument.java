package tn.sesame.rhmanagementbackend.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.rmi.server.UID;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true) // appel getter setter sans utiliser prefixe get and set
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="hr_document")

@Getter @Setter
public class HRDocument {
    @Id
    @GeneratedValue
    UID id;
    @NotNull
    String documentName;
    String contentType;
    @Lob
    @Column(name = "encrypted_content", nullable = false)
    private byte[] encryptedContent;
    @Column(name = "file_size", nullable = false)
    @NotNull
    private Long fileSize;
    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false, length = 20)
    private AccessLevel accessLevel;

   /* @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Employee owner;*/


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;




    // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name="employee_id", nullable=false)
   // private Employee employee;


    Set<String> tags=new HashSet<>();
    Instant uploadedAt;
    private String checksum;





}
