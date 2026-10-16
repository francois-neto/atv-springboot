package biblioteca.biblioteca.Repository;

import java.util.*;

import biblioteca.biblioteca.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloLivroContainingIgnoreCase(String tituloLivro);
}