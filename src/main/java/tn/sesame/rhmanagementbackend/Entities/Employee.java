package tn.sesame.rhmanagementbackend.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import tn.sesame.rhmanagementbackend.Enumerations.ContractType;
import tn.sesame.rhmanagementbackend.Enumerations.EmployeeDepartment;
import tn.sesame.rhmanagementbackend.Enumerations.EmployeeJobTitle;

import java.math.BigDecimal;
import java.rmi.server.UID;
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
@Table(name="employee", uniqueConstraints = @UniqueConstraint(columnNames = "employee_number"))
@Getter @Setter
@EqualsAndHashCode(of="email")
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @NonNull
    @JoinColumn(name="user_id") // <-- corrigé
    private User user;

    @Column(name="employee_number", length=8, unique=true)
    private String employeeNumber;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    EmployeeDepartment department;

    @Enumerated(EnumType.STRING)
    EmployeeJobTitle position;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime hireDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", length = 20, nullable = false)
    private ContractType contractType;

    private BigDecimal salary;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manager_id")
    Employee manager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    Set<Employee> subordinates = new HashSet<>();


   /* @OneToMany(mappedBy="employee", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    Set<HRDocument> documents = new HashSet<>();*/
   @OneToMany(mappedBy="employee", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
   Set<HRDocument> documents = new HashSet<>();


}
