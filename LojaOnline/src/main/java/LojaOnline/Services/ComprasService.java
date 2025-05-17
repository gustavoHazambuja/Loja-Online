package LojaOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import LojaOnline.Entities.Produto;
import LojaOnline.Repositories.ProdutoRepository;

@Service
public class ComprasService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> gerarListaComprasNecessarias(Pageable pageable){
        
        Page<Produto> result = produtoRepository.findByQuantidadeEstoqueLessThan(10, pageable);

        return result;
    }
}
