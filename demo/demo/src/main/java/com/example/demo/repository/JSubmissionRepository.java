package com.example.demo.repository;

import com.example.demo.SubmissionDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ISubmissionRepository {
    SubmissionDTO postSubmission(@RequestBody SubmissionDTO sf);
    SubmissionDTO getSubmissionFormById(@RequestBody String Id);
    List<SubmissionDTO> getallSubmissions();
    SubmissionDTO editSubmission(@RequestBody SubmissionDTO sf);

    List<SubmissionDTO> getAll();

    List<SubmissionDTO> deleteSubmission(@RequestBody String Id);



}
