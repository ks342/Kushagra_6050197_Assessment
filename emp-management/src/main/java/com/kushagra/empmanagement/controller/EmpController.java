package com.kushagra.empmanagement.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.kushagra.empmanagement.dto.EmpDto;
import com.kushagra.empmanagement.entity.Emp;
import com.kushagra.empmanagement.service.EmpService;

import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("emps", service.getAll());
        return "viewall";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        Emp emp = service.getById(id);

        EmpDto dto = new EmpDto();
        BeanUtils.copyProperties(emp, dto);

        model.addAttribute("empDto", dto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("empDto") EmpDto dto,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            return "edit";
        }

        Emp emp = new Emp();
        BeanUtils.copyProperties(dto, emp);

        service.save(emp);

        model.addAttribute("msg", "Employee Edited");
        model.addAttribute("emps", service.getAll());

        return "viewall";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        service.delete(id);

        model.addAttribute("msg", "Employee Deleted");
        model.addAttribute("emps", service.getAll());

        return "viewall";
    }
}