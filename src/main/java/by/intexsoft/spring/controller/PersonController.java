package by.intexsoft.spring.controller;

import by.intexsoft.spring.model.Department;
import by.intexsoft.spring.model.Person;
import by.intexsoft.spring.service.DepartmentService;
import by.intexsoft.spring.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private PersonService personService;
    private DepartmentService departmentService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "departmentService")
    public void setDepartmentService(DepartmentService ds) {
        this.departmentService = ds;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("department", new Department());

        List<Person> listPersons = this.personService.listPersons();
        List<Department> listDepartments = this.departmentService.listDepartments();

        model.addAttribute("listPersons", listPersons );
        model.addAttribute("listDepartments",listDepartments );
        logger.info("view persons /persons");
        return "person";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {
        this.personService.addPerson(p);
        logger.info("add person /person/add");
        return "redirect:/persons";

    }

    @RequestMapping(value = "/person/addDepartment", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute("department") Department d) {

        this.departmentService.addDepartment(d);
        logger.info("add department /person/addDepartment");
        return "redirect:/persons";

    }

    @RequestMapping(value = "/person/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") Person p) {

        this.personService.updatePerson(p);
        logger.info("update person /person/add");
        return "redirect:/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {

        this.personService.removePerson(id);
        logger.info("delete person /remove/id");
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id},{id1}")
    public String editPerson(@PathVariable("id") int id, @PathVariable("id1") int id1, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("department", this.departmentService.getDepartmentById(id1));
        model.addAttribute("listPersons", this.personService.listPersons());
        model.addAttribute("listDepartments",this.departmentService.listDepartments());
        logger.info("edit person /edit/id");
        return "person";
    }
}

