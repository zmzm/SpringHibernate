package by.intexsoft.spring.service.impl;

import by.intexsoft.spring.dao.DepartmentDAO;
import by.intexsoft.spring.model.Department;
import by.intexsoft.spring.service.DepartmentService;

import javax.transaction.Transactional;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO;

    public void setDepartmentDAO(DepartmentDAO personDAO) {
        this.departmentDAO = personDAO;
    }

    @Override
    @Transactional
    public void addDepartment(Department p) {
        this.departmentDAO.addDepartment(p);
    }

    @Override
    @Transactional
    public void updateDepartment(Department p) {
        this.departmentDAO.updateDepartment(p);
    }

    @Override
    @Transactional
    public List<Department> listDepartments() {
        return this.departmentDAO.listDepartments();
    }

    @Override
    @Transactional
    public Department getDepartmentById(int id) {
        return this.departmentDAO.getDepartmentById(id);
    }

    @Override
    @Transactional
    public void removeDepartment(int id) {
        this.departmentDAO.removeDepartment(id);
    }
}
