package com.eric.drink.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Entity
@Getter
@Setter
public class Revenda {
    @Id
    @CNPJ
    private String cnpj;

    @NotBlank
    private String razaoSocial;

    @NotBlank
    private String nomeFantasia;

    @NotBlank
    @Email
    private String email;

    @ElementCollection
    private List<@Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$") String> telefones;

    @Valid
    @Size(min = 1)
    @ElementCollection
    private List<Contato> contatos;

    @Valid
    @Size(min = 1)
    @ElementCollection
    private List<Endereco> enderecos;
}

@Embeddable
@Getter
@Setter
class Contato {
    @NotBlank
    private String nome;
    private boolean principal;
}

@Embeddable
@Getter
@Setter
class Endereco {
    @NotBlank
    private String logradouro;

}