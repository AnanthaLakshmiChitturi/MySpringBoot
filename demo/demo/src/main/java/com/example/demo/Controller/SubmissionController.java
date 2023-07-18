package com.example.demo.Controller;

import com.example.demo.SubmissionDTO;
import com.example.demo.services.SubmissionServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController  {
    @Autowired
    private SubmissionServicelmpl submissionService;


    @PostMapping("/add")
    public SubmissionDTO postSubmission(@RequestBody SubmissionDTO sf) {
        return submissionService.postSubmission(sf);
    }


    @GetMapping("/getSubmission/{Id}")
    public SubmissionDTO getSubmissionFormById(@PathVariable String Id) {
        SubmissionDTO record=new SubmissionDTO();
        record=submissionService.getSubmissionFormById(Id);
        return record;
    }

    @GetMapping("/getAllSubmissions")
    public List<SubmissionDTO> getallSubmissions() {
        return submissionService.getallSubmissions();
    }

    @PutMapping("/update")
    public SubmissionDTO editSubmission(@RequestBody SubmissionDTO sf) {
        return submissionService.editSubmission(sf);
    }

    @DeleteMapping("/delete/{Id}")
    public List<SubmissionDTO> deleteSubmission(@PathVariable String Id) {
        return submissionService.deleteSubmission(Id);
    }
}