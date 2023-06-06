package com.credibanco.CrudApp.Repository;

import com.credibanco.CrudApp.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<Usuario, Long> {
        Usuario getUserById(Long id);
}
