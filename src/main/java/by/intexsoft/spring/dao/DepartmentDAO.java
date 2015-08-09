package by.intexsoft.spring.dao;

import by.intexsoft.spring.model.Department;

import java.util.List;


public interface DepartmentDAO {
    public void addDepartment(Department p);

    public void updateDepartment(Department p);

    public List<Department> listDepartments();

    public Department getDepartmentById(int id);

    public void removeDepartment(int id);
}
