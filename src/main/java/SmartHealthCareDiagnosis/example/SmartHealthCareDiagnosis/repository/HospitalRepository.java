package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.repository;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    // 🔍 Find by city (case-insensitive)
    List<Hospital> findByCityContainingIgnoreCase(String city);

    // 🔍 Find by specialty (case-insensitive)
    List<Hospital> findBySpecialtyContainingIgnoreCase(String specialty);

    // 🔍 Find by both city and specialty
    List<Hospital> findByCityContainingIgnoreCaseAndSpecialtyContainingIgnoreCase(String city, String specialty);
}
