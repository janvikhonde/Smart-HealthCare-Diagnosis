package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.controller;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.SymptomAnalysis;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service.SymptomAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import jakarta.servlet.http.HttpSession;

@Controller
public class SymptomController {

    @Autowired
    private SymptomAnalyzerService symptomAnalyzerService;

    @GetMapping("/symptom-analyzer")
    public String showSymptomAnalyzer(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        return "symptom-analyzer";
    }

    @PostMapping("/analyze-symptoms")
    @ResponseBody
    public SymptomAnalysis analyzeSymptoms(@RequestParam String symptoms,
                                           HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return null;
        }

        return symptomAnalyzerService.analyzeSymptoms(userId, symptoms);
    }
}