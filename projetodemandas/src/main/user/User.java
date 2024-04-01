import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")

public class User {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String telefone;
    private String endereço;
}
