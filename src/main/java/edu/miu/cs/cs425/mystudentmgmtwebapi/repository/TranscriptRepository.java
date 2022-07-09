package edu.miu.cs.cs425.mystudentmgmtwebapi.repository;


import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
