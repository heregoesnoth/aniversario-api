package br.com.ada.aniversarioapi.repository;

import br.com.ada.aniversarioapi.entity.Aniversario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AniversarioRepository extends JpaRepository<Aniversario, Long> {
}
