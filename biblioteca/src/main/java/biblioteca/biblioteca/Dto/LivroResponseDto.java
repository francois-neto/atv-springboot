package biblioteca.biblioteca.Dto;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {
    @JsonProperty("isbn")
    private Long isbn;

    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @JsonProperty("anoLivro")
    private Year anoLivro;

    @JsonProperty("edicaoLivro")
    private Integer edicaoLivro;

    @JsonProperty("autor")
    private AutorResponseDto autor;
}