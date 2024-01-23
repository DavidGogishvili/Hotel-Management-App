package David.Hotel.Entities;

import David.Hotel.Security.UserManager;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
@Data
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column (name = "changed_by")
    private Integer changedBy;

    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "changed_at")
    private LocalDateTime changedAt;



    @PrePersist
    public void preInsert () {
        createdBy = UserManager.getCurrentUser().getId();
        createdAt = LocalDateTime.now();
    }



    @PreUpdate
    public void preChange () {
        changedBy = UserManager.getCurrentUser().getId();
        changedAt = LocalDateTime.now();
    }







}

