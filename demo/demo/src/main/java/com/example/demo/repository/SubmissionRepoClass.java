package com.example.demo.repository;

import java.util.*;

import com.example.demo.SubmissionDTO;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class SubmissionRepoClass implements ISubmissionRepository {
    public Map<String,SubmissionDTO> hashMap=new HashMap<String,SubmissionDTO>();



    @Override
    public SubmissionDTO postSubmission(SubmissionDTO sf) {
        String id= String.valueOf(UUID.randomUUID());
        sf.setId(id);
        hashMap.put(id,sf);
        return hashMap.get(id);
    }

    @Override
    public SubmissionDTO getSubmissionFormById(String Id) {
        SubmissionDTO record=new SubmissionDTO();
        record= (SubmissionDTO) hashMap.get(Id);
        return record;
    }

    @Override
    public List<SubmissionDTO> getallSubmissions() {
        List<SubmissionDTO> submissionForms=new ArrayList<SubmissionDTO>();
        hashMap.forEach((key, value) -> {
            submissionForms.add(value);
        });
        return submissionForms;
    }

    @Override
    public SubmissionDTO editSubmission(SubmissionDTO sf) {
        hashMap.put(sf.Id,sf);
        return hashMap.get(sf.Id);
    }


    @Override
    public List<SubmissionDTO> getAll() {
        return null;
    }

    @Override
    public List<SubmissionDTO> deleteSubmission(String Id) {
        hashMap.remove(Id);
        List<SubmissionDTO> submissionForms=new ArrayList<SubmissionDTO>();
        hashMap.forEach((key, value) -> {
            submissionForms.add(value);
        });
        return submissionForms;


    }

}