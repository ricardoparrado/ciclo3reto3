package com.usa.ciclo3.ciclo3.web;


import com.usa.ciclo3.ciclo3.model.UAdministrator;
import com.usa.ciclo3.ciclo3.service.UAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/UAdministrator")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UAdministratorController {

    @Autowired
    private UAdministratorService uAdministratorService;

    @GetMapping("/all")
    public List<UAdministrator> getUAdministrators() {
        return uAdministratorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UAdministrator> getMessage(@PathVariable("id") int id) {
        return uAdministratorService.getUAdministrator(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UAdministrator save(@RequestBody UAdministrator uads) {
        return uAdministratorService.save(uads);
    }


}
