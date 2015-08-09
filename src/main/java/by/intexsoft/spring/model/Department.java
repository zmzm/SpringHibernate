package by.intexsoft.spring.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dId;

    private String departmentName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Person> listPersons;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return dId;
    }

    public void setId(Integer id) {
        this.dId = id;
    }


    @Override
    public String toString() {
        return "id=" + dId + ", department=" + departmentName;
    }
}
