package senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
