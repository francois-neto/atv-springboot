package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

import java.util.List;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    List<LivroResponseDto> buscarTodosLivros();

    LivroResponseDto buscarLivroPorISBN(Long isbn);

    List<LivroResponseDto> buscarLivroPorTitulo(String titulo);

    LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto);

    void removerLivro(Long isbn);
}