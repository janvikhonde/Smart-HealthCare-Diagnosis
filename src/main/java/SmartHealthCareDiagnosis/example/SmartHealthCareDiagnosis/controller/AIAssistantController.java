package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.controller;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.ChatMessage;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service.AIAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

        import jakarta.servlet.http.HttpSession;

@Controller
public class AIAssistantController {

    @Autowired
    private AIAssistantService aiAssistantService;

    @GetMapping("/ai-assistant")
    public String showAIAssistant(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        return "ai-assistant";
    }

    @PostMapping("/chat")
    @ResponseBody
    public ChatMessage chat(@RequestBody ChatMessage message, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return new ChatMessage("Please login to continue.", "ai");
        }

        return aiAssistantService.processMessage(message.getMessage());
    }
}