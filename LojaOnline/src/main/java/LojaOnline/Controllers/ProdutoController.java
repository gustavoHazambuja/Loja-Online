package LojaOnline.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LojaOnline.Entities.Produto;
import LojaOnline.Services.ComprasService;
import LojaOnline.Services.ProdutoService;
import LojaOnline.Services.VendasService;

@RestController
@RequestMapping(value = "/lojaOnline")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    private ComprasService comprasService;
    private VendasService vendasService;

    @GetMapping(value = "/produtos")
    public ResponseEntity<Page<Produto>> getProdutos(Pageable pageable){
        
        Page<Produto> result = produtoService.consultaTodos(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/listaNecessaria")
    public ResponseEntity<Page<Produto>> listaComprasNecessarias(Pageable pageable){

        Page<Produto> result = comprasService.gerarListaComprasNecessarias(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping(value = "/criarProduto")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){

        Produto result = produtoService.criarProduto(produto);

        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping(value = "/produto/{codigo}")
    public ResponseEntity<Produto> consultarPorCodigo(@PathVariable Long codigo){

        Produto result = produtoService.consultaPorCodigo(codigo);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @PutMapping(value = "/atualizarProduto/{codigo}/{quantidadeEstoque}")
    public boolean atualizarProduto(@PathVariable Long codigo, @PathVariable int quantidadeEstoque){

        return produtoService.atualizarProduto(codigo, quantidadeEstoque);
    }

    @PostMapping(value = "/venderProduto/{codigo}/{quantidadeDesejada}")
    public double venderProduto(@PathVariable Long codigo, @PathVariable int quantidadeDesejada){

        return vendasService.venderProduto(codigo, quantidadeDesejada);
    }

}
