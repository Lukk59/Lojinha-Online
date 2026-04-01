package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        clientes.add(new Cliente(1L, "Lucas", "lucas@email.com"));
        clientes.add(new Cliente(2L, "Ana", "ana@email.com"));
        clientes.add(new Cliente(3L, "Carlos", "carlos@email.com"));
    }

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Cliente buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}