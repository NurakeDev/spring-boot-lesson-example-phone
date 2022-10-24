package nurakedevgroup.com.springbootlessonexamplephone.controller;

import nurakedevgroup.com.springbootlessonexamplephone.entity.Phone;
import nurakedevgroup.com.springbootlessonexamplephone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "phones", path = "/api/phones")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @GetMapping(name = "get", path = "/list")
    public List<Phone> findAll(){
        return service.findAll();
    }

    @GetMapping(name = "getId", path = "/{id}/by_id") //read
    public Phone getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PostMapping(name = "create", path = "/save") //create
    public Phone save(@RequestBody Phone phone){
        return service.save(phone);
    }

    @PutMapping(name = "update", path = "/{id}/update") //update
    public Phone update(@PathVariable Long id, @RequestBody Phone phone){
        return service.update(id, phone);
    }

    @DeleteMapping(name = "remove", path = "/{id}/delete") //delete
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}