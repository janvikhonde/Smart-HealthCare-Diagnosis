package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.controller;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.SymptomAnalysis;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service.SymptomAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private SymptomAnalyzerService symptomAnalyzerService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");

        if (userId == null) {
            return "redirect:/login";
        }

        // Get user's recent analyses
        List<SymptomAnalysis> recentAnalyses = symptomAnalyzerService.getUserHistory(userId);

        model.addAttribute("userName", userName);
        model.addAttribute("recentAnalyses", recentAnalyses.isEmpty() ? null : recentAnalyses.subList(0, Math.min(3, recentAnalyses.size())));
        model.addAttribute("totalAnalyses", recentAnalyses.size());

        return "dashboard";
    }
}