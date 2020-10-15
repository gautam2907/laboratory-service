package com.example.laboratoryservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.laboratoryservice.model.ImageModel;
import com.example.laboratoryservice.repository.ImageRepository;
import com.example.laboratoryservice.util.ImageUtils;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import com.example.laboratoryservice.model.GenericResponse;
import com.example.laboratoryservice.model.LabRecord;
import com.example.laboratoryservice.model.LabRecordPast;
import com.example.laboratoryservice.model.TreatmentHistory;
import com.example.laboratoryservice.repository.LabRecordPastRepository;
import com.example.laboratoryservice.repository.LabRecordRepository;

import org.springframework.web.multipart.MultipartFile;

import com.example.laboratoryservice.repository.TreatmentHistoryRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
	
	@Autowired()
	private TreatmentHistoryRepository treatmentHistoryRepository;
	@Autowired()
	private LabRecordRepository labRecordRepository;
	
	@Autowired()
	private LabRecordPastRepository	labRecordPastRepository;

	@Autowired
    private ImageRepository imageRepository;
	
	@RequestMapping(value="/add-treatment-history", method=RequestMethod.POST)
	public GenericResponse addTreatmentHistory(@RequestBody TreatmentHistory treatmentHistory) {
		treatmentHistoryRepository.save(treatmentHistory);
		return new GenericResponse(1, "success", treatmentHistory);
	}
	
	@RequestMapping(value="/get-labtests-past/{treatmentId}")
	public GenericResponse getLabTests(@PathVariable String treatmentId) {
		List<LabRecordPast> testsDonePast = labRecordPastRepository.findByTreatmentId(treatmentId);
		return new GenericResponse(1, "success", testsDonePast);
	}
	
	@RequestMapping(value="/get-labrecord/{testId}")
	public GenericResponse getLabTest(@PathVariable String testId) {
		LabRecord labRecord = labRecordRepository.findByTestId(testId);
		return new GenericResponse(1, "success", labRecord);
	}
	
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
	
	@RequestMapping(value="/add-labtest-record", method=RequestMethod.POST)
	public GenericResponse addLabTestRecord(@RequestBody LabRecord labTestRecord){
        labRecordRepository.save(labTestRecord);
        return new GenericResponse(1, "success", labTestRecord);
    }
	
	
	@RequestMapping(value="add-past-testrecord/{testId}", method=RequestMethod.POST)
	public GenericResponse addPastTestRecord(@RequestBody LabRecordPast pastLabRecord, @PathVariable String testId){
		pastLabRecord.setTestId(testId);
        labRecordPastRepository.save(pastLabRecord);
        labRecordRepository.deleteById(testId);
        System.out.println(pastLabRecord.getDate() + " " + pastLabRecord.getTestName());
        return new GenericResponse(1, "success", pastLabRecord);
    }

    //image upload
    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public GenericResponse uploadImage(@RequestParam("file") MultipartFile file) {
        try{
            ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
                    ImageUtils.compressBytes(file.getBytes()));

            return new GenericResponse(1, "success", imageRepository.save(img));
        }catch (Exception e){
            e.printStackTrace();
            return new GenericResponse(0, "exception occurred", null);
        }

    }

    //image retrieve
    @RequestMapping("/image/get/{labTestId}")
    public GenericResponse getImage(@PathVariable("labTestId") String id) {
        final Optional<ImageModel> retrievedImage = imageRepository.findById(id);
        try{
            ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
                    ImageUtils.decompressBytes(retrievedImage.get().getPicByte()));
            return new GenericResponse(1, "success", img);
        }catch (Exception e){
            e.printStackTrace();
            return new GenericResponse(0, "exception: " + e.getMessage(), null);
        }


    }
	
}
