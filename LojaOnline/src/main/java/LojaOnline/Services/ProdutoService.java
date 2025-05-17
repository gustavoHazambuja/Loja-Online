package LojaOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import LojaOnline.Entities.Produto;
import LojaOnline.Repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public Page<Produto> consultaTodos(Pageable pageable){
        
        Page<Produto> result = produtoRepository.findByQuantidadeEstoqueGreaterThan(0, pageable);

        return result;
    }

    @Transactional
    public Produto criarProduto(Produto produto){

        Produto result = produtoRepository.save(produto);

        return result;
    }

    @Transactional(readOnly = true)
    public Produto consultaPorCodigo(Long codigo){

        Produto result = produtoRepository.findByCodigo(codigo);

        return result;
    }

    @Transactional
    public boolean atualizarProduto(Long codigo, int quantidadeEstoque){

        if(!produtoRepository.existsById(codigo)){
            return false;
        }

        Produto result = produtoRepository.findByCodigo(codigo);

        result.setQuantidadeEstoque(quantidadeEstoque);

        produtoRepository.save(result);

        return true;
    }
}
