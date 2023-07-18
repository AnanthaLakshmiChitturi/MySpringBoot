package com.example.demo.services;

import com.example.demo.SubmissionDTO;
import com.example.demo.repository.SubmissionRepoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServicelmpl implements SubmissionService {
    @Autowired
    private SubmissionRepoClass submissionRepository;



    @Override
    public SubmissionDTO postSubmission(SubmissionDTO sf) {
        return submissionRepository.postSubmission(sf);
    }

    @Override
    public SubmissionDTO getSubmissionFormById(String Id) {
        return submissionRepository.getSubmissionFormById(Id);
    }

    @Override
    public List<SubmissionDTO> getallSubmissions() {
        return submissionRepository.getallSubmissions();
    }

    @Override
    public SubmissionDTO editSubmission(SubmissionDTO sf) {
        return submissionRepository.editSubmission(sf);
    }

    @Override
    public List<SubmissionDTO> getAll() {
        return null;
    }

    @Override
    public List<SubmissionDTO> deleteSubmission(String Id) {
        return submissionRepository.deleteSubmission(Id);
    }
}
