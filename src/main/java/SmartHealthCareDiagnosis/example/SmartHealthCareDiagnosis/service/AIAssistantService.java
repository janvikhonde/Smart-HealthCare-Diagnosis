package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AIAssistantService {

    private static final Map<String, String> responses = new HashMap<>();

    static {
        // ✅ FEVER
        responses.put("fever",
                "🌡️ Fever Guidance\n\n" +
                        "Overview: Temporary rise in body temperature, usually caused by an infection.\n" +
                        "Home Care: Take rest, drink fluids, and use paracetamol if needed.\n" +
                        "Consult a Doctor: If your fever is above 103°F or lasts more than 3 days.\n" +
                        "Prevention: Wash your hands often, stay hydrated, and keep up with vaccinations.");

        // ✅ COUGH
        responses.put("cough",
                "😷 Cough Management\n\n" +
                        "Overview: Commonly caused by cold, allergy, or throat infection.\n" +
                        "Treatment: Drink warm water, honey, and inhale steam to soothe your throat.\n" +
                        "Seek Help: If your cough lasts more than 3 weeks or comes with blood.\n" +
                        "Prevention: Avoid smoking and exposure to pollution.");

        // ✅ HEADACHE
        responses.put("headache",
                "🤕 Headache Relief\n\n" +
                        "Types: Can be due to tension, migraine, or stress.\n" +
                        "Care: Rest in a quiet, dark room and stay hydrated. Light pain relief can help.\n" +
                        "Doctor Advice: Visit a doctor if the pain is severe or sudden.\n" +
                        "Prevention: Sleep regularly and manage stress.");

        // ✅ DIABETES
        responses.put("diabetes",
                "🍬 Diabetes Management\n\n" +
                        "Overview: Caused by high blood sugar due to insulin imbalance.\n" +
                        "Care: Maintain a balanced diet, exercise daily, and take prescribed medicine.\n" +
                        "Monitor: Check your blood sugar regularly.\n" +
                        "Prevention: Maintain a healthy weight and reduce sugar intake.");

        // ✅ BLOOD PRESSURE
        responses.put("blood pressure",
                "❤️ Blood Pressure Control\n\n" +
                        "Tips: Exercise daily, reduce salt intake, and manage stress.\n" +
                        "Watch For: Dizziness, headaches, or chest pain.\n" +
                        "Diet: Eat potassium-rich foods like bananas and avoid alcohol and junk food.");

        // ✅ ASTHMA
        responses.put("asthma",
                "💨 Asthma Care\n\n" +
                        "Overview: A chronic condition that makes breathing difficult.\n" +
                        "Treatment: Use prescribed inhalers and follow your doctor's advice.\n" +
                        "Avoid Triggers: Dust, smoke, strong odors, and cold air.\n" +
                        "Emergency: If breathing becomes difficult, seek medical help immediately.");

        // ✅ HEART DISEASE
        responses.put("heart disease",
                "💓 Heart Disease Care\n\n" +
                        "Overview: Affects blood flow and heart muscles.\n" +
                        "Symptoms: Chest pain, fatigue, or shortness of breath.\n" +
                        "Care: Eat low-fat food, exercise regularly, and avoid smoking.\n" +
                        "Prevention: Regular checkups and stress control are important.");

        // ✅ THYROID
        responses.put("thyroid",
                "🦋 Thyroid Health\n\n" +
                        "Overview: Caused by imbalance in thyroid hormones.\n" +
                        "Symptoms: Fatigue, mood swings, and weight changes.\n" +
                        "Treatment: Take hormone medication as prescribed by your doctor.\n" +
                        "Diet: Eat iodine-rich foods such as fish and iodized salt.");

        // ✅ ANEMIA
        responses.put("anemia",
                "🩸 Anemia Management\n\n" +
                        "Overview: Caused by a low level of red blood cells or hemoglobin.\n" +
                        "Symptoms: Fatigue, pale skin, and dizziness.\n" +
                        "Treatment: Include iron supplements and foods rich in vitamin B12.\n" +
                        "Diet: Eat green vegetables, lentils, and lean meat.");

        // ✅ MALARIA
        responses.put("malaria",
                "🦟 Malaria Guidance\n\n" +
                        "Cause: Spread by mosquito bites carrying parasites.\n" +
                        "Symptoms: High fever, chills, and sweating.\n" +
                        "Treatment: Take antimalarial medicines prescribed by a doctor.\n" +
                        "Prevention: Use mosquito nets and avoid stagnant water.");

        // ✅ DENGUE
        responses.put("dengue",
                "🦟 Dengue Fever Care\n\n" +
                        "Symptoms: High fever, joint pain, rashes, and bleeding gums.\n" +
                        "Treatment: Take rest, drink fluids, and use paracetamol only (avoid aspirin).\n" +
                        "Emergency: Go to the hospital if you notice bleeding or dehydration.\n" +
                        "Prevention: Use mosquito repellents and keep surroundings clean.");

        // ✅ JAUNDICE
        responses.put("jaundice",
                "💛 Jaundice Care\n\n" +
                        "Overview: Yellowing of skin and eyes due to liver problems.\n" +
                        "Causes: Hepatitis, alcohol, or blocked bile ducts.\n" +
                        "Treatment: Get medical tests, take rest, drink fluids, and eat light food.\n" +
                        "Prevention: Avoid alcohol and contaminated food or water.");

        // ✅ PNEUMONIA
        responses.put("pneumonia",
                "🫁 Pneumonia Assistance\n\n" +
                        "Overview: Lung infection causing cough, fever, and breathing issues.\n" +
                        "Treatment: Take antibiotics as prescribed and get plenty of rest.\n" +
                        "Warning: Visit a doctor if you have chest pain or breathing difficulty.\n" +
                        "Prevention: Get vaccinated and maintain hygiene.");

        // ✅ MIGRAINE
        responses.put("migraine",
                "💢 Migraine Relief\n\n" +
                        "Symptoms: Pulsating headache, nausea, and light sensitivity.\n" +
                        "Care: Rest in a dark, quiet room and take prescribed pain medicine.\n" +
                        "Prevention: Maintain regular sleep and avoid known triggers like caffeine.");

        // ✅ SKIN INFECTION
        responses.put("skin infection",
                "🧴 Skin Infection Care\n\n" +
                        "Overview: Caused by bacteria, fungi, or viruses.\n" +
                        "Treatment: Keep the area clean and apply recommended creams or ointments.\n" +
                        "Doctor Visit: If the infection spreads or causes pus.\n" +
                        "Prevention: Maintain hygiene and wear clean clothes.");

        // ✅ STOMACH PAIN
        responses.put("stomach pain",
                "🤢 Stomach Pain Relief\n\n" +
                        "Causes: Can be due to indigestion, gas, or infection.\n" +
                        "Care: Eat light food, drink water, and avoid spicy or oily meals.\n" +
                        "Doctor Visit: If pain is severe, or if you notice vomiting or blood in stool.");

        // ✅ COMMON COLD
        responses.put("cold",
                "🤧 Common Cold Care\n\n" +
                        "Care: Rest well, drink warm liquids, and take vitamin C.\n" +
                        "Avoid Antibiotics: Colds are usually viral, so antibiotics don’t help.\n" +
                        "Prevention: Wash your hands regularly and avoid touching your face.");

        // ✅ FLU
        responses.put("flu",
                "🩹 Flu (Influenza) Care\n\n" +
                        "Symptoms: Fever, cough, sore throat, and body pain.\n" +
                        "Treatment: Rest, drink fluids, and take antiviral medicines if prescribed.\n" +
                        "Prevention: Get your annual flu vaccine.");

        // ✅ DEPRESSION
        responses.put("depression",
                "🧠 Depression Support\n\n" +
                        "Symptoms: Feeling sad, loss of interest, fatigue, or trouble sleeping.\n" +
                        "Care: Talk to family, engage in hobbies, and seek therapy or counseling.\n" +
                        "Help: If you have suicidal thoughts, contact a mental health helpline immediately.");

        // ✅ ANXIETY
        responses.put("anxiety",
                "💭 Anxiety Relief\n\n" +
                        "Symptoms: Nervousness, sweating, restlessness, and panic.\n" +
                        "Tips: Practice deep breathing, yoga, meditation, and reduce caffeine.\n" +
                        "Treatment: Therapy or doctor-prescribed medicine if needed.");

        // ✅ ARTHRITIS
        responses.put("arthritis",
                "🦵 Arthritis Management\n\n" +
                        "Overview: Joint inflammation causing pain and stiffness.\n" +
                        "Treatment: Gentle exercise, pain relievers, and physical therapy.\n" +
                        "Diet: Eat foods rich in omega-3 and vitamin D.\n" +
                        "Prevention: Maintain healthy weight and stay active.");
    }

    public ChatMessage processMessage(String userMessage) {
        String response = generateResponse(userMessage.toLowerCase());
        return new ChatMessage(response, "ai");
    }

    private String generateResponse(String message) {

        // Match disease or keyword
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (message.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // Common greeting
        if (message.contains("hello") || message.contains("hi") || message.contains("how are you")) {
            return "Hello! I’m your Smart Health AI Assistant. Tell me what symptoms or health concerns you have, and I’ll try to guide you.";
        }

        // Thanks
        if (message.contains("thank")) {
            return "You're welcome! Stay healthy and feel free to ask about any health issue anytime.";
        }

        // Emergency
        if (message.contains("emergency") || message.contains("urgent")) {
            return "For medical emergencies, please call your local emergency number immediately (108 in India, 911 in the US).";
        }

        // Doctor / Hospital
        if (message.contains("doctor") || message.contains("hospital")) {
            return "You can use our 'Nearby Hospitals' feature to locate the closest healthcare center. Regular doctor checkups are important for early diagnosis.";
        }

        // Default
        return "I can help you with health advice, symptoms, and treatments for conditions like fever, diabetes, asthma, migraine, and more. What would you like to know about?";
    }
}
