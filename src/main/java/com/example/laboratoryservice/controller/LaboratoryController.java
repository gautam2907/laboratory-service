package com.example.laboratoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.example.laboratoryservice.model.GenericResponse;
import com.example.laboratoryservice.model.LabRecord;
import com.example.laboratoryservice.model.LabRecordPast;
import com.example.laboratoryservice.repository.LabRecordPastRepository;
import com.example.laboratoryservice.repository.LabRecordRepository;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
	
	@Autowired()
	private LabRecordRepository labRecordRepository;
	
	@Autowired()
	private LabRecordPastRepository	labRecordPastRepository;
	
	
	@RequestMapping(value="/get-labrecords-all")
	public GenericResponse getAllLabTestRecord(){
        List<LabRecord> allRecords =  labRecordRepository.findAll();
        return new GenericResponse(1, "success", allRecords);
    }

    @RequestMapping(value = "/add-lab-record", method = RequestMethod.POST)
    public GenericResponse addLabRecord(@RequestBody LabRecord labRecord){
	    labRecordRepository.save(labRecord);
	    return new GenericResponse(1, "success", null);
    }
	
	
	
	@RequestMapping(value="/get-labrecords-all-past")
	public GenericResponse getAllLabTestRecordPast(){
        List<LabRecordPast> allPastRecords =  labRecordPastRepository.findAll();
        return new GenericResponse(1, "success", allPastRecords);
    }
	
	
	@RequestMapping(value="add-past-testrecord/{testId}", method=RequestMethod.POST)
	public GenericResponse addPastTestRecord(@RequestBody LabRecordPast pastLabRecord, @PathVariable String testId){
        labRecordPastRepository.save(pastLabRecord);
        labRecordRepository.deleteById(testId);
        return new GenericResponse(1, "success", pastLabRecord);
    }
	
	
}
