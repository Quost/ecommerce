package sc.senai.ecommerce.service;

import sc.senai.ecommerce.model.Produto;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Optional;

public class ProdutoService {
    private static final List<Produto> produtos = new ArrayList<>();
    private static long idCounter = 1;

    public List<Produto> listarTodos() {
        return Collections.unmodifiableList(produtos);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Produto salvar(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(idCounter++);
            produtos.add(produto);
        } else {
            buscarPorId(produto.getId()).ifPresent(p -> {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                p.setDescricao(produto.getDescricao());
            });
        }
        return produto;
    }

    public void deletar(Long id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }
}
