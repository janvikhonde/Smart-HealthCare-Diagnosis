package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.SymptomAnalysis;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.repository.SymptomAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SymptomAnalyzerService {

    @Autowired
    private SymptomAnalysisRepository analysisRepository;

    private static final Map<String, List<String>> diseaseSymptoms = new HashMap<>();

    static {
        diseaseSymptoms.put("Common Cold", Arrays.asList("runny nose", "sneezing", "cough", "sore throat", "mild fever", "nasal congestion"));
        diseaseSymptoms.put("Flu", Arrays.asList("high fever", "body ache", "fatigue", "cough", "headache", "chills", "sore throat"));
        diseaseSymptoms.put("COVID-19", Arrays.asList("fever", "dry cough", "fatigue", "loss of taste", "loss of smell", "breathing difficulty", "sore throat"));
        diseaseSymptoms.put("Pneumonia", Arrays.asList("fever", "cough", "chills", "breathing difficulty", "chest pain", "fatigue"));
        diseaseSymptoms.put("Asthma", Arrays.asList("breathing difficulty", "wheezing", "chest tightness", "cough", "shortness of breath"));
        diseaseSymptoms.put("Bronchitis", Arrays.asList("persistent cough", "mucus", "fatigue", "chest discomfort", "shortness of breath"));
        diseaseSymptoms.put("Malaria", Arrays.asList("fever", "chills", "sweating", "headache", "nausea", "vomiting", "muscle pain"));
        diseaseSymptoms.put("Dengue", Arrays.asList("high fever", "joint pain", "rash", "headache", "pain behind eyes", "nausea"));
        diseaseSymptoms.put("Typhoid", Arrays.asList("high fever", "abdominal pain", "constipation", "fatigue", "loss of appetite", "headache"));
        diseaseSymptoms.put("Gastritis", Arrays.asList("stomach pain", "nausea", "vomiting", "bloating", "loss of appetite", "acid reflux"));
        diseaseSymptoms.put("Heart Attack", Arrays.asList("chest pain", "pressure in chest", "shortness of breath", "nausea", "dizziness", "jaw pain", "left arm pain"));
        diseaseSymptoms.put("Stroke", Arrays.asList("sudden numbness", "weakness", "trouble speaking", "confusion", "blurred vision", "loss of balance"));
        diseaseSymptoms.put("Diabetes", Arrays.asList("frequent urination", "increased thirst", "fatigue", "blurred vision", "slow healing", "weight loss"));
        diseaseSymptoms.put("Hypertension", Arrays.asList("headache", "dizziness", "chest pain", "shortness of breath", "nosebleed", "blurred vision"));
        diseaseSymptoms.put("Anemia", Arrays.asList("fatigue", "weakness", "pale skin", "dizziness", "cold hands", "shortness of breath"));
        diseaseSymptoms.put("Depression", Arrays.asList("sadness", "fatigue", "loss of interest", "sleep problems", "hopelessness", "concentration problems"));
        diseaseSymptoms.put("Anxiety Disorder", Arrays.asList("nervousness", "restlessness", "rapid heartbeat", "sweating", "trouble sleeping", "fatigue"));
        diseaseSymptoms.put("UTI", Arrays.asList("burning urination", "frequent urination", "pelvic pain", "cloudy urine", "fever"));
        diseaseSymptoms.put("Kidney Stones", Arrays.asList("severe back pain", "abdominal pain", "pain during urination", "blood in urine", "nausea", "vomiting"));
        diseaseSymptoms.put("Arthritis", Arrays.asList("joint pain", "stiffness", "swelling", "reduced movement", "fatigue"));
        diseaseSymptoms.put("Sinusitis", Arrays.asList("facial pain", "headache", "nasal congestion", "thick mucus", "fever"));
        diseaseSymptoms.put("Dehydration", Arrays.asList("dry mouth", "fatigue", "dizziness", "less urination", "headache", "thirst"));
    }

    public SymptomAnalysis analyzeSymptoms(Long userId, String symptomsInput) {
        SymptomAnalysis analysis = new SymptomAnalysis();
        analysis.setUserId(userId);
        analysis.setSymptoms(symptomsInput);

        String[] userSymptoms = symptomsInput.toLowerCase().split(",");
        List<String> cleanSymptoms = new ArrayList<>();
        for (String s : userSymptoms) cleanSymptoms.add(s.trim());

        // Score all diseases
        Map<String, Integer> matchScores = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : diseaseSymptoms.entrySet()) {
            int matches = 0;
            for (String symptom : cleanSymptoms) {
                for (String diseaseSymptom : entry.getValue()) {
                    if (diseaseSymptom.contains(symptom) || symptom.contains(diseaseSymptom)) {
                        matches++;
                        break;
                    }
                }
            }
            matchScores.put(entry.getKey(), matches);
        }

        // Sort and get top 3 probable diseases
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(matchScores.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        StringBuilder result = new StringBuilder();
        int totalSymptoms = cleanSymptoms.size();

        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            String disease = sortedList.get(i).getKey();
            int matches = sortedList.get(i).getValue();
            int confidence = (int) ((matches * 100.0) / Math.max(totalSymptoms, 1));
            String severity = determineSeverity(cleanSymptoms, disease);
            String advice = generateRecommendations(disease, severity);

            if (confidence > 0) {
                result.append((i + 1) + ". Possible Disease: " + disease + "\n");
                result.append("   Confidence: " + confidence + "%\n");
                result.append("   Severity: " + severity + "\n");
                result.append("   Advice: " + advice + "\n\n");
            }
        }

        if (result.isEmpty()) {
            result.append("No strong match found. Please consult a healthcare professional for accurate diagnosis.");
        }

        analysis.setPredictedDisease("Multiple Possible Conditions");
        analysis.setConfidenceScore(85);
        analysis.setSeverity("Varies");
        analysis.setRecommendations(result.toString());

        return analysisRepository.save(analysis);
    }

    private String determineSeverity(List<String> symptoms, String disease) {
        if (disease.equals("Heart Attack") || disease.equals("Stroke") || disease.equals("COVID-19") || symptoms.size() >= 6)
            return "High";
        else if (symptoms.size() >= 3)
            return "Moderate";
        else
            return "Low";
    }

    private String generateRecommendations(String disease, String severity) {
        StringBuilder rec = new StringBuilder();

        if (severity.equals("High")) rec.append("Consult a doctor immediately. ");

        switch (disease) {
            case "Common Cold": rec.append("Rest, drink warm fluids, and avoid cold drinks."); break;
            case "Flu": rec.append("Rest, stay hydrated, take fever reducers, and seek care if prolonged."); break;
            case "COVID-19": rec.append("Isolate, monitor oxygen, consult doctor, stay hydrated."); break;
            case "Pneumonia": rec.append("Take antibiotics as prescribed, rest, and monitor breathing."); break;
            case "Asthma": rec.append("Use inhaler, avoid dust and smoke, track breathing."); break;
            case "Bronchitis": rec.append("Stay hydrated, use humidifier, rest, and avoid smoke."); break;
            case "Malaria": rec.append("Take prescribed antimalarial drugs, rest, and stay hydrated."); break;
            case "Dengue": rec.append("Rest, drink fluids, monitor platelets, avoid aspirin."); break;
            case "Typhoid": rec.append("Eat light meals, stay hydrated, take antibiotics as prescribed."); break;
            case "Gastritis": rec.append("Avoid spicy foods, eat small meals, and manage stress."); break;
            case "Heart Attack": rec.append("Call emergency services, chew aspirin, stay still."); break;
            case "Stroke": rec.append("Seek immediate emergency help, stay calm and avoid movement."); break;
            case "Diabetes": rec.append("Monitor blood sugar, eat balanced diet, take medicines regularly."); break;
            case "Hypertension": rec.append("Reduce salt, exercise regularly, manage stress, monitor BP."); break;
            case "Anemia": rec.append("Eat iron-rich foods and consider supplements."); break;
            case "Depression": rec.append("Talk to therapist, exercise, stay socially active."); break;
            case "Anxiety Disorder": rec.append("Practice breathing exercises, avoid caffeine, stay calm."); break;
            case "UTI": rec.append("Drink water, avoid caffeine, complete antibiotic course."); break;
            case "Kidney Stones": rec.append("Drink plenty of water, take pain relief, consult urologist."); break;
            case "Arthritis": rec.append("Do gentle exercise, take anti-inflammatory medication."); break;
            case "Sinusitis": rec.append("Steam inhalation, nasal sprays, stay hydrated."); break;
            case "Dehydration": rec.append("Drink ORS, water, and rest in a cool environment."); break;
            default: rec.append("Consult healthcare provider for detailed evaluation.");
        }

        return rec.toString();
    }

    public List<SymptomAnalysis> getUserHistory(Long userId) {
        return analysisRepository.findByUserIdOrderByAnalyzedAtDesc(userId);
    }
}
