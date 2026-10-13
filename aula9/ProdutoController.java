package ifrs.teste.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ifrs.teste.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }
}