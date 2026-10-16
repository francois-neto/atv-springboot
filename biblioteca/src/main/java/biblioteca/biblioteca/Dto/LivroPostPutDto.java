package biblioteca.biblioteca.Dto;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {
    @JsonProperty("isbn")
    @NotNull(message = "ISBN é o identificador do livro, não pode ser vazio")
    private Long isbn;

    @JsonProperty("tituloLivro")
    @NotBlank(message = "Título do livro não pode ser vazio")
    private String tituloLivro;

    @JsonProperty("anoLivro")
    @NotNull(message = "Ano do livro não pode ser vazio")
    private Year anoLivro;

    @JsonProperty("edicaoLivro")
    @NotNull(message = "Edição do livro não pode ser vazia")
    private Integer edicaoLivro;

    @JsonProperty("autor")
    @NotNull(message = "Autor do livro não pode ser vazio")
    private Long autor;
}