package testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testproject.model.dto.ReservationDto;
import testproject.service.ReservationService;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired private ReservationService reservationService;

    @PostMapping("/reservation/upload")
    public boolean upload(@RequestBody ReservationDto reservationDto){
        return reservationService.uplaod(reservationDto);
    }

    @GetMapping("/reservation/viewall")
    public List<ReservationDto> viewAll(){
        return reservationService.viewAll();
    }

    @GetMapping("/reservation/view")
    public ReservationDto view(@RequestParam int reservationid){
        return reservationService.view(reservationid);
    }

    @PutMapping("/reservation/change")
    public boolean change(@RequestBody ReservationDto reservationDto){
        return reservationService.change(reservationDto);
    }

    @DeleteMapping("/reservation/remove")
    public boolean remove(@RequestParam int reservationid){
        return reservationService.remove(reservationid);
    }

    @GetMapping("/reservation/viewalldoctor")
    public List<ReservationDto> viewAllDoctor(@RequestParam int doctorid){
        return reservationService.viewAllDoctor(doctorid);
    }

    @GetMapping("/reservation/viewallpatient")
    public List<ReservationDto> viewAllPatient(@RequestParam int patientid){
        return reservationService.viewAllPatient(patientid);
    }
}
