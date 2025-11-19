package sc.senai.ecommerce.controller;

import sc.senai.ecommerce.model.Produto;
import sc.senai.ecommerce.service.ProdutoService;
import java.util.List;

public class ProdutoController {
    private ProdutoService produtoService = new ProdutoService();

    // Exemplo de endpoints mockados
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    public Produto buscarPorId(Long id) {
        return produtoService.buscarPorId(id).orElse(null);
    }

    public Produto criar(Produto produto) {
        return produtoService.salvar(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        produto.setId(id);
        return produtoService.salvar(produto);
    }

    public boolean deletar(Long id) {
        if (produtoService.buscarPorId(id).isPresent()) {
            produtoService.deletar(id);
            return true;
        }
        return false;
    }
}
