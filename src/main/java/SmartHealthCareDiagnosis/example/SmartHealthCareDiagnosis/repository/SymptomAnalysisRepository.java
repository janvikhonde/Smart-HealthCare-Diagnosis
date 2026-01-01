package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.repository;


import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.SymptomAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomAnalysisRepository extends JpaRepository<SymptomAnalysis, Long> {
    List<SymptomAnalysis> findByUserIdOrderByAnalyzedAtDesc(Long userId);
}