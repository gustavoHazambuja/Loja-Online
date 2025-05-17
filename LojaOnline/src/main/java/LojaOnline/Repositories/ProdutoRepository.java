package LojaOnline.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import LojaOnline.Entities.Produto;


public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
    Produto findByCodigo(Long codigo);
}
