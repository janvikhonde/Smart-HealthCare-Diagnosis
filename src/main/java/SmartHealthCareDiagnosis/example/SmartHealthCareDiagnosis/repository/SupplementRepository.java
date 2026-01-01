package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.repository;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplementRepository extends JpaRepository<Supplement, Long> {
    List<Supplement> findBySuitableForContaining(String condition);
}