package LojaOnline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import LojaOnline.Entities.Produto;
import LojaOnline.Repositories.ProdutoRepository;

@Service
public class VendasService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public double venderProduto(Long codigo, int quantidadeDesejada){

        if(!produtoRepository.existsById(codigo)){
            return -1; // Produto não encontrado
        }

        Produto result = produtoRepository.findByCodigo(codigo);

        if(result.getQuantidadeEstoque() < quantidadeDesejada){
            return -1; // Falta de estoque
        }

        double precoBase = result.getPrecoUnitario() * quantidadeDesejada;
        int novaQuantidade = result.getQuantidadeEstoque() - quantidadeDesejada;
        double precoComDesconto;
        double precoFinal;

        if(quantidadeDesejada > 10){
             precoComDesconto = precoBase * 0.90; // 10% de desconto
             precoFinal = precoComDesconto * 1.05; // 5% de imposto

             return precoFinal;
        }
        result.setQuantidadeEstoque(novaQuantidade);
        produtoRepository.save(result);
       
        return precoBase;
    }
}
