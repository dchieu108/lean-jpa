package com.vn.devmaster.services.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;

@ManyToMany
    @JoinTable(name = "student_subject",
    joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_subject", referencedColumnName = "id"))
    private List<Subject> subjects =new ArrayList<>();

//    @Column(name = "point")
//    private float point;




}
