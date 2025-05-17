package LojaOnline.Repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import LojaOnline.Entities.Produto;


public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
    Produto findByCodigo(Long codigo);

    Page<Produto> findByQuantidadeEstoqueGreaterThan(int quantidade, Pageable pageable);

    Page<Produto> findByQuantidadeEstoqueLessThan(int quantidade, Pageable pageable);
}
