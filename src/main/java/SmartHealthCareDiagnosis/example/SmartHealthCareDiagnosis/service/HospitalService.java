package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.Hospital;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @PostConstruct
    public void init() {
        if (hospitalRepository.count() == 0) {
            addSampleHospitals();
        }
    }

    private void addSampleHospitals() {
        List<Hospital> hospitals = new ArrayList<>();

        // 🏙️ --- Original Hospitals from your version ---
        Hospital h1 = new Hospital("City General Hospital", "123 Main Street", "Mumbai", "+91-22-12345678", "General, Emergency");
        h1.setServices("24/7 Emergency, ICU, Surgery, Diagnostics");
        h1.setLatitude(19.0760);
        h1.setLongitude(72.8777);
        hospitals.add(h1);

        Hospital h2 = new Hospital("Heart Care Center", "456 Park Avenue", "Nanded", "+91-22-87654321", "Cardiology");
        h2.setServices("Cardiac Care, Angioplasty, Heart Surgery");
        h2.setLatitude(19.1383);
        h2.setLongitude(77.3210);
        hospitals.add(h2);

        Hospital h3 = new Hospital("Children's Hospital", "789 Kids Lane", "Nagpur", "+91-11-23456789", "Pediatrics");
        h3.setServices("Child Care, Vaccination, Neonatal ICU");
        h3.setLatitude(21.1458);
        h3.setLongitude(79.0882);
        hospitals.add(h3);

        Hospital h4 = new Hospital("Orthopedic Clinic", "321 Bone Road", "Bangalore", "+91-80-34567890", "Orthopedics");
        h4.setServices("Joint Replacement, Fracture Care, Physiotherapy");
        h4.setLatitude(12.9716);
        h4.setLongitude(77.5946);
        hospitals.add(h4);

        Hospital h5 = new Hospital("Women's Health Center", "654 Care Street", "Nanded", "+91-44-45678901", "Gynecology, Obstetrics");
        h5.setServices("Maternity, Women's Health, Fertility");
        h5.setLatitude(19.1383);
        h5.setLongitude(77.3210);
        hospitals.add(h5);

        // 🏥 --- Nanded Hospitals ---
        hospitals.add(createHospital("Dr. Hedgewar Rugnalaya", "Vazirabad", "Nanded", "+91-2462-221011",
                "Multispeciality", "General Medicine, Surgery, ICU, Diagnostics", 19.1383, 77.3210));

        hospitals.add(createHospital("MGM Medical College & Hospital", "Hingoli Road", "Nanded", "+91-2462-210456",
                "General, Medical College", "Teaching Hospital, Emergency, Surgery", 19.1383, 77.3210));

        hospitals.add(createHospital("Dr. S. R. B. Hospital", "Shivaji Nagar", "Nanded", "+91-2462-223788",
                "General", "Medicine, Surgery, ENT, Diagnostics", 19.1383, 77.3210));

        hospitals.add(createHospital("ICON Hospital", "CIDCO", "Nanded", "+91-2462-224455",
                "Cardiology, Neurology, ICU", "Cardiac Care, Neuro ICU, Diagnostics", 19.1450, 77.3200));

        hospitals.add(createHospital("Sparsh Hospital", "Shivaji Nagar", "Nanded", "+91-2462-220789",
                "Orthopedics, Surgery, General", "Bone & Joint Care, Fracture, Surgery", 19.1360, 77.3200));

        hospitals.add(createHospital("Sai Heart & Critical Care Center", "Vazirabad", "Nanded", "+91-2462-226667",
                "Cardiology, ICU", "Heart Surgery, ICU, Diagnostics", 19.1400, 77.3185));

        hospitals.add(createHospital("Government Hospital Nanded", "Vazirabad", "Nanded", "+91-2462-220111",
                "Government General Hospital", "Public Health, OPD, Surgery", 19.1375, 77.3212));

        hospitals.add(createHospital("Shree Hospital", "IT Park Road", "Nanded", "+91-2462-229456",
                "General, Surgery", "OPD, Surgery, Diagnostics", 19.1362, 77.3240));

        hospitals.add(createHospital("Wockhardt Hospital", "VIP Road", "Nanded", "+91-2462-227799",
                "Multispeciality", "24/7 Emergency, ICU, Cardiac, Surgery", 19.1390, 77.3255));

        hospitals.add(createHospital("Sanjeevani Hospital", "Shivaji Nagar", "Nanded", "+91-2462-229001",
                "Maternity, Pediatrics, ICU", "Mother & Child Care, ICU", 19.1368, 77.3220));

        hospitals.add(createHospital("Nirmal Children's Hospital", "Hyderabad Road", "Nanded", "+91-2462-230555",
                "Pediatrics, Neonatal Care", "Vaccination, Child ICU", 19.1380, 77.3205));

        hospitals.add(createHospital("Om Orthopedic & Trauma Center", "CIDCO", "Nanded", "+91-2462-232221",
                "Orthopedics, Trauma Care", "Accident, Surgery, Physiotherapy", 19.1420, 77.3225));

        hospitals.add(createHospital("Dr. Jadhav's Dental Clinic", "Shree Nagar", "Nanded", "+91-2462-236789",
                "Dental", "Root Canal, Implants, Orthodontics", 19.1395, 77.3245));

        hospitals.add(createHospital("Life Care Hospital", "Vazirabad", "Nanded", "+91-2462-240333",
                "Multispeciality", "General Surgery, ICU, Diagnostics", 19.1401, 77.3210));

        hospitals.add(createHospital("Ashwini Hospital", "Siddheshwar Nagar", "Nanded", "+91-2462-245678",
                "Maternity, Gynecology", "Obstetrics, Fertility Care", 19.1388, 77.3199));

        hospitals.add(createHospital("Sai Baba Eye Hospital", "Vazirabad", "Nanded", "+91-2462-244999",
                "Ophthalmology", "Cataract, Retina Surgery, Vision Tests", 19.1379, 77.3221));

        // 🌆 --- Nearby Cities ---

        // Hingoli
        hospitals.add(createHospital("Dr. Deshmukh Hospital", "Main Road", "Hingoli", "+91-2456-222888",
                "General", "OPD, Surgery, Diagnostics", 19.7150, 77.1480));
        hospitals.add(createHospital("Hingoli Civil Hospital", "Civil Lines", "Hingoli", "+91-2456-223300",
                "Government General", "Emergency, General Care", 19.7100, 77.1500));

        // Parbhani
        hospitals.add(createHospital("Global Hospital", "Station Road", "Parbhani", "+91-2452-222444",
                "Multispeciality", "ICU, Diagnostics, Emergency", 19.2700, 76.7700));
        hospitals.add(createHospital("Civil Hospital Parbhani", "Jintur Road", "Parbhani", "+91-2452-220123",
                "Government General", "Public Health Services", 19.2685, 76.7750));
        hospitals.add(createHospital("Dr. Patil Orthopedic Clinic", "Shivaji Nagar", "Parbhani", "+91-2452-229900",
                "Orthopedics", "Bone Surgery, Physiotherapy", 19.2720, 76.7705));

        // Latur
        hospitals.add(createHospital("SPM Hospital", "Ausa Road", "Latur", "+91-2382-220555",
                "Multispeciality", "Emergency, ICU, Surgery", 18.4000, 76.5700));
        hospitals.add(createHospital("Govt Medical College & Hospital", "Ambajogai Road", "Latur", "+91-2382-229111",
                "Teaching, General", "Medical College & Hospital", 18.4050, 76.5800));
        hospitals.add(createHospital("Dr. Bhandari Eye Hospital", "Market Yard", "Latur", "+91-2382-230888",
                "Ophthalmology", "Eye Surgery, Cataract", 18.3950, 76.5650));

        // Nizamabad
        hospitals.add(createHospital("Pragathi Hospital", "Subhash Nagar", "Nizamabad", "+91-8462-221111",
                "Multispeciality", "Cardiac, ICU, Emergency", 18.6700, 78.1000));
        hospitals.add(createHospital("Govt General Hospital", "Vinayak Nagar", "Nizamabad", "+91-8462-225555",
                "General", "Government Facility, Surgery", 18.6750, 78.1050));
        hospitals.add(createHospital("Care Hospital", "Bodhan Road", "Nizamabad", "+91-8462-228888",
                "Cardiology, Orthopedics", "Heart & Joint Care, ICU", 18.6650, 78.0950));

        // Save all
        hospitalRepository.saveAll(hospitals);
    }

    private Hospital createHospital(String name, String address, String city, String phone,
                                    String specialty, String services, double lat, double lon) {
        Hospital h = new Hospital(name, address, city, phone, specialty);
        h.setServices(services);
        h.setLatitude(lat);
        h.setLongitude(lon);
        return h;
    }

    // ✅ Case-insensitive get methods
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public List<Hospital> getHospitalsByCity(String city) {
        return hospitalRepository.findByCityContainingIgnoreCase(city);
    }

    public List<Hospital> searchBySpecialty(String specialty) {
        return hospitalRepository.findBySpecialtyContainingIgnoreCase(specialty);
    }

    // ✅ Nearby Hospital Logic
    public List<Hospital> findNearbyHospitals(double userLat, double userLon, double radiusKm) {
        List<Hospital> allHospitals = hospitalRepository.findAll();
        List<Hospital> nearby = new ArrayList<>();

        for (Hospital h : allHospitals) {
            if (h.getLatitude() == null || h.getLongitude() == null) continue;

            double distance = haversine(userLat, userLon, h.getLatitude(), h.getLongitude());
            if (distance <= radiusKm) {
                h.setDistanceFromUser(distance);
                nearby.add(h);
            }
        }

        nearby.sort(Comparator.comparingDouble(Hospital::getDistanceFromUser));
        return nearby;
    }

    // ✅ Haversine Formula
    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}
