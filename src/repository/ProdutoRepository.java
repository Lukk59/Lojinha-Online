package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoRepository() {
        produtos.add(new Produto(1L, "Notebook", 3500.00, 10));
        produtos.add(new Produto(2L, "Mouse", 120.00, 30));
        produtos.add(new Produto(3L, "Teclado", 250.00, 20));
        produtos.add(new Produto(4L, "Monitor", 999.90, 15));
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}