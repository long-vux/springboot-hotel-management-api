    package com.tdtu.hotel_management.entity;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.Email;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "employee")
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Email
        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "date_of_birth")
        private LocalDateTime dateOfBirth;

        @Column(name = "role")
        private String role;

        @Column(name = "status")
        private String status;

        @Column(name = "salary")
        private String salary;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "is_women")
        private String isWomen;

        @Column(name = "image_path")
        private String imagePath;

        @Column(name = "department")
        private String department;

        @Column(name = "address")
        private String address;
    }