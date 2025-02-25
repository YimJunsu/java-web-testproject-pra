package testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testproject.model.dto.DoctorDto;
import testproject.service.DoctorService;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor/upload")
    public boolean upload(@RequestBody DoctorDto doctorDto){
        return doctorService.upload(doctorDto);
    }

    @GetMapping("/doctor/viewall")
    public List<DoctorDto> viewAll(){
        return doctorService.viewAll();
    }

    @GetMapping("/doctor/view")
    public DoctorDto view(@RequestParam int doctorid){
        return doctorService.view(doctorid);
    }

    @PutMapping("/doctor/change")
    public boolean change(@RequestBody DoctorDto doctorDto){
        return doctorService.change(doctorDto);
    }

    @DeleteMapping("/doctor/remove")
    public boolean remove(@RequestParam int doctorid){
        return doctorService.remove(doctorid);
    }
}
