package com.example.demo.Controller;

import com.example.demo.services.DemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class DemoResource {

    private DemoService demoService;

    public DemoResource(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/names")
    public List<String> getNames() {
        return demoService.getNames();
    }

    @PostMapping("/names")
    public void addName(@RequestBody String name) {
        demoService.addName(name);
    }

    @PutMapping("/names/{index}")
    public void updateName(@PathVariable int index, @RequestBody String name) {
        demoService.updateName(index, name);
    }

    @DeleteMapping("/names/{index}")
    public void deleteName(@PathVariable int index) {
        demoService.deleteName(index);
    }
}
