package com.example.myapi.services;

import com.example.myapi.domain.Usuario;
import com.example.myapi.repositories.UsuarioRepository;
import com.example.myapi.services.excepitions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! " + id + ", Tipo: " +
                Usuario.class.getName()));
    }
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    public Usuario update(Integer id, Usuario obj) {
        Usuario novoObj = findById(id);
        novoObj.setNome(obj.getNome());
        novoObj.setLogin(obj.getLogin());
        novoObj.setSenha(obj.getSenha());
        return repository.save(novoObj);

    }
    public Usuario create(Usuario obj) {
        obj.setId(null);
        return repository.save(obj);
    }
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
