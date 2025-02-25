package testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testproject.model.dto.PatientDto;
import testproject.model.entity.PatientEntity;
import testproject.service.PatientService;

import java.util.List;

@RestController
public class PatientController {
    @Autowired private PatientService patientService;

    @PostMapping("/patient/upload")
    public boolean upload(@RequestBody PatientDto patientDto){
        return patientService.upload(patientDto);
    }

    @GetMapping("/patient/viewall")
    public List<PatientDto> viewAll(){
        return patientService.viewAll();
    }

    @GetMapping("/patient/view")
    public PatientDto view(@RequestParam int patientid){
        return patientService.view(patientid);
    }

    @PutMapping("/patient/change")
    public boolean change(@RequestBody PatientDto patientDto){
        return patientService.change(patientDto);
    }

    @DeleteMapping("/patient/remove")
    public boolean remove(@RequestParam int patientid){
        return patientService.remove(patientid);
    }
}
