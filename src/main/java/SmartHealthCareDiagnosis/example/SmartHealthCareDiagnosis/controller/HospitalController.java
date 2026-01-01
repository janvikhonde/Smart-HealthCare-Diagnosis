package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.controller;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.Hospital;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    // ✅ Display all hospitals page (Thymeleaf)
    @GetMapping("/hospitals")
    public String showHospitals(HttpSession session, Model model) {
        // Ensure user is logged in
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        List<Hospital> hospitals = hospitalService.getAllHospitals();
        model.addAttribute("hospitals", hospitals);

        return "hospitals"; // Thymeleaf page name
    }

    // ✅ Search hospitals by city or specialty
    @GetMapping("/search-hospitals")
    @ResponseBody
    public List<Hospital> searchHospitals(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String specialty) {

        boolean hasCity = city != null && !city.trim().isEmpty();
        boolean hasSpecialty = specialty != null && !specialty.trim().isEmpty();

        // Both city and specialty provided
        if (hasCity && hasSpecialty) {
            List<Hospital> byCity = hospitalService.getHospitalsByCity(city.trim());
            return byCity.stream()
                    .filter(h -> h.getSpecialty() != null &&
                            h.getSpecialty().toLowerCase().contains(specialty.trim().toLowerCase()))
                    .toList();
        }
        // Only city provided
        else if (hasCity) {
            return hospitalService.getHospitalsByCity(city.trim());
        }
        // Only specialty provided
        else if (hasSpecialty) {
            return hospitalService.searchBySpecialty(specialty.trim());
        }
        // No filters — return all
        else {
            return hospitalService.getAllHospitals();
        }
    }

    // ✅ Find nearby hospitals using GPS coordinates
    @GetMapping("/nearby-hospitals")
    @ResponseBody
    public List<Hospital> getNearbyHospitals(
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam(defaultValue = "50") double radiusKm) {

        return hospitalService.findNearbyHospitals(lat, lon, radiusKm);
    }
}
