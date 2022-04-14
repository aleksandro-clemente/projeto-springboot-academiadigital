package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Lombok -- serve para abstrair get set equals e hashcode
@Data
//Lombok -- cria um construtor vazio(Hibernate precisa do construtor vazio)
@NoArgsConstructor
//Lombok -- Cria o construtor com todos os parametros da classe
@AllArgsConstructor
//Marca a classe como uma entidade do hibernate
@Entity
//Cria a tabela seta a tabela com este nome para crialo no banco de dados(não é obrigatório
//porem se voce não informar ele cria a tabela com o nome da classe)
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  //Informa que o campo é um id
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //nullable=false significa que não aceita valores nulos, lenght tamanho do campo
  //@Column(nullable=false, length = 50)
  private String nome;

  //Unique um campo único
  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  //Relacionamento bidirecional
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
