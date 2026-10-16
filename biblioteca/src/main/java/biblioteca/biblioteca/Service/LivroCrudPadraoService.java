package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Livro livro = modelMapper.map(livroPostPutDto, Livro.class);
        livro.setAutor(obterAutorExistente(livroPostPutDto.getAutor()));
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto buscarLivroPorISBN(Long isbn) {
        return modelMapper.map(obterLivroExistente(isbn), LivroResponseDto.class);
    }

    @Override
    public List<LivroResponseDto> buscarLivroPorTitulo(String titulo) {
        return livroRepository.findByTituloLivroContainingIgnoreCase(titulo)
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto) {
        Livro livro = obterLivroExistente(isbn);
        livro.setTituloLivro(livroPostPutDto.getTituloLivro());
        livro.setAnoLivro(livroPostPutDto.getAnoLivro());
        livro.setEdicaoLivro(livroPostPutDto.getEdicaoLivro());
        livro.setAutor(obterAutorExistente(livroPostPutDto.getAutor()));

        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public void removerLivro(Long isbn) {
        livroRepository.delete(obterLivroExistente(isbn));
    }
    
    private Livro obterLivroExistente(Long isbn) {
        return livroRepository.findById(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    private Autor obterAutorExistente(Long id) {
        return autorRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
    }
}