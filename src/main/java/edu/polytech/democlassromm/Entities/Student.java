package edu.polytech.democlassromm.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name="student", schema = "PUBLIC")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nsc", nullable = false, unique = true)
    private int nsc;

    private String email;


    public Student(int nsc, String email) {
        this.nsc = nsc;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(nsc, student.nsc);
    }

    @Override
    public int hashCode() {
        return 90;
    }

    @ManyToOne

    @JsonIgnoreProperties("student")
    private Classroom classroom;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Club> club;




}
