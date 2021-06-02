package com.example.demo.employ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employ")
public class EmployController {

    private final EmployService employService;

    @Autowired
    public EmployController(EmployService employService) {
        this.employService = employService;
    }

    @GetMapping
    public List<Employ> getEmploy(){
        return employService.getEmploy();
    }

    @PostMapping
    public void registerNewEmploy(@RequestBody Employ employ){
        employService.addNewEmploy(employ);
    }

    @DeleteMapping(path = "{employId}")
    public void deleteEmploy(@PathVariable("employId") Long employId){
        employService.deleteEmploy(employId);
    }

    @PutMapping(path = "{employId}")
    public void updateStudent(
            @PathVariable("employId") Long employId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer salary){
        employService.updateEmploy(employId, name, email,salary);
    }


}
