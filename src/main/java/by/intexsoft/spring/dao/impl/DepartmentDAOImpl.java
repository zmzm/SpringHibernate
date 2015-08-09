package by.intexsoft.spring.dao.impl;

import by.intexsoft.spring.dao.DepartmentDAO;
import by.intexsoft.spring.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addDepartment(Department p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Department saved successfully, Person Details="+p);

    }

    @Override
    public void updateDepartment(Department p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Department updated successfully, Person Details="+p);

    }

    @Override
    public List<Department> listDepartments() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> departmentsList = session.createCriteria(Department.class).list();
        for(Department p : departmentsList){
            logger.info("Department List::" + p);
        }
        return departmentsList;
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department p = (Department) session.load(Department.class, new Integer(id));
        logger.info("Department loaded successfully, Department details="+p);
        return p;
    }

    @Override
    public void removeDepartment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department p = (Department) session.load(Department.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Department deleted successfully, department details="+p);

    }
}
