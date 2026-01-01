package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.Supplement;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.repository.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Service
public class SupplementService {

    @Autowired
    private SupplementRepository supplementRepository;

    @PostConstruct
    public void init() {
        if (supplementRepository.count() == 0) {
            addSampleSupplements();
        }
    }

    private void addSampleSupplements() {
        List<Supplement> supplements = new ArrayList<>();

        // 🌿 --- Immunity & General Health ---
        supplements.add(createSupplement("Vitamin C", "500-1000mg", "Once daily",
                "Boosts immunity, fights infections, antioxidant properties",
                "cold, flu, immunity, fatigue, fever"));

        supplements.add(createSupplement("Vitamin D3", "1000-2000 IU", "Once daily",
                "Bone health, immune support, mood enhancement",
                "bone pain, fatigue, weakness, immunity"));

        supplements.add(createSupplement("Zinc Gluconate", "20-50mg", "Once daily after meals",
                "Supports immunity, helps recover from cold and fever",
                "cold, flu, fever, sore throat"));

        supplements.add(createSupplement("Multivitamin Complex", "1 tablet", "Once daily after food",
                "Overall health, energy boost, improves recovery",
                "fatigue, fever, weakness, recovery"));

        supplements.add(createSupplement("Omega-3 Fish Oil", "1000mg", "Once or twice daily",
                "Heart health, reduces inflammation, brain function",
                "heart, inflammation, joint pain, memory"));

        supplements.add(createSupplement("Iron Supplement", "50-100mg", "Once daily with food",
                "Treats anemia, increases energy, improves concentration",
                "anemia, fatigue, weakness, dizziness"));

        supplements.add(createSupplement("Probiotics", "10 billion CFU", "Once daily",
                "Digestive health, immunity, gut flora balance",
                "digestion, bloating, diarrhea, immunity, loose motion"));

        supplements.add(createSupplement("Magnesium", "200-400mg", "Once daily at bedtime",
                "Muscle relaxation, sleep quality, stress reduction",
                "stress, insomnia, muscle cramps, headache"));

        // 🤒 --- Fever / Cold / Cough ---
        supplements.add(createSupplement("Paracetamol", "500mg", "Every 6-8 hours if fever persists",
                "Reduces fever and relieves mild pain",
                "fever, headache, body ache"));

        supplements.add(createSupplement("Vitamin B Complex", "1 tablet", "Once daily",
                "Improves energy levels and supports recovery from fever",
                "fatigue, weakness, fever recovery"));

        supplements.add(createSupplement("Tulsi Extract Capsules", "250mg", "Once or twice daily",
                "Natural immunity booster, helps with cold and cough",
                "cold, cough, flu, sore throat"));

        supplements.add(createSupplement("Ginger Extract Capsules", "500mg", "Once daily after meals",
                "Anti-inflammatory, relieves sore throat and nausea",
                "cough, cold, sore throat, nausea, flu"));

        supplements.add(createSupplement("Honey & Lemon Syrup", "10ml", "2–3 times daily",
                "Soothes throat, helps relieve cough and cold symptoms",
                "cough, cold, sore throat, flu"));

        supplements.add(createSupplement("Steam Inhalation (Menthol Oil Capsules)", "As needed", "Twice daily (inhalation)",
                "Clears nasal congestion, improves breathing",
                "cold, cough, nasal blockage, flu"));

        // 🤕 --- Migraine / Headache ---
        supplements.add(createSupplement("Magnesium Citrate", "250mg", "Once daily",
                "Reduces migraine frequency, calms nerves",
                "migraine, headache, stress"));

        supplements.add(createSupplement("Riboflavin (Vitamin B2)", "400mg", "Once daily",
                "Prevents migraine attacks, improves energy metabolism",
                "migraine, fatigue, headache"));

        supplements.add(createSupplement("Coenzyme Q10", "100mg", "Once daily",
                "Improves brain and heart energy metabolism",
                "migraine, fatigue, weakness"));

        supplements.add(createSupplement("Peppermint Oil Capsules", "1 capsule", "Once daily or during headache",
                "Natural headache and nausea relief",
                "migraine, headache, nausea, stress"));

        supplements.add(createSupplement("Ashwagandha", "500mg", "Once or twice daily",
                "Adaptogen, reduces stress and improves sleep",
                "stress, migraine, anxiety, fatigue"));

        // 💧 --- Loose Motion / Digestive Issues ---
        supplements.add(createSupplement("ORS (Oral Rehydration Salts)", "1 sachet in 1L water", "As needed after each loose motion",
                "Restores lost electrolytes and hydration",
                "loose motion, dehydration, diarrhea"));

        supplements.add(createSupplement("Lactobacillus Capsules", "1 capsule", "Once daily after food",
                "Restores gut flora, helps control diarrhea",
                "loose motion, diarrhea, bloating, digestion"));

        supplements.add(createSupplement("Activated Charcoal Capsules", "250mg", "Twice daily after meals",
                "Absorbs toxins and gases, relieves stomach upset",
                "diarrhea, bloating, loose motion, food poisoning"));

        supplements.add(createSupplement("ORS + Zinc Supplement", "Zinc 20mg + ORS", "As prescribed (3-5 days)",
                "Supports rehydration and gut repair during diarrhea",
                "loose motion, dehydration, diarrhea, weakness"));

        // 🌞 --- Other Common Wellness Supplements ---
        supplements.add(createSupplement("Calcium + Vitamin D3", "500mg + 200 IU", "Once daily",
                "Bone strength, joint health",
                "bone pain, weakness, fatigue"));

        supplements.add(createSupplement("Green Tea Extract", "250mg", "Once daily in morning",
                "Antioxidant, boosts metabolism and immunity",
                "fatigue, immunity, stress"));

        supplements.add(createSupplement("Electrolyte Powder", "1 sachet in 500ml water", "As needed",
                "Restores minerals, hydration",
                "fever, dehydration, weakness"));

        supplements.add(createSupplement("Turmeric Curcumin", "500mg", "Once daily after meals",
                "Anti-inflammatory, antioxidant, immune support",
                "inflammation, joint pain, immunity, fever recovery"));

        supplements.add(createSupplement("Garlic Capsules", "250mg", "Once daily after meals",
                "Supports heart health and immunity",
                "cold, flu, cholesterol, immunity"));

        supplementRepository.saveAll(supplements);
    }

    private Supplement createSupplement(String name, String dosage, String frequency,
                                        String benefits, String suitableFor) {
        Supplement s = new Supplement();
        s.setName(name);
        s.setDosage(dosage);
        s.setFrequency(frequency);
        s.setBenefits(benefits);
        s.setSuitableFor(suitableFor);
        return s;
    }

    // 🔍 Search supplements based on symptoms
    public List<Supplement> getSuggestionsBySymptoms(String symptoms) {
        List<Supplement> suggestions = new ArrayList<>();
        String[] symptomArray = symptoms.toLowerCase().split(",");

        List<Supplement> allSupplements = supplementRepository.findAll();

        for (Supplement supplement : allSupplements) {
            for (String symptom : symptomArray) {
                String cleanSymptom = symptom.trim();
                if (supplement.getSuitableFor().toLowerCase().contains(cleanSymptom)) {
                    if (!suggestions.contains(supplement)) {
                        suggestions.add(supplement);
                    }
                }
            }
        }

        return suggestions;
    }

    public List<Supplement> getAllSupplements() {
        return supplementRepository.findAll();
    }
}
