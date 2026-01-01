package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.controller;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.Supplement;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SupplementController {

    @Autowired
    private SupplementService supplementService;

    @GetMapping("/supplements")
    public String showSupplements(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        List<Supplement> supplements = supplementService.getAllSupplements();
        model.addAttribute("supplements", supplements);

        return "supplements";
    }

    @GetMapping("/supplement-suggestions")
    @ResponseBody
    public List<Supplement> getSuggestions(@RequestParam String symptoms) {
        return supplementService.getSuggestionsBySymptoms(symptoms);
    }
}