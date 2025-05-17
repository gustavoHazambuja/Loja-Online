package LojaOnline.Entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long codigo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "preco_unitario")
    private Double precoUnitario;
    
    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;
}
