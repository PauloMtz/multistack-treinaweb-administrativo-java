package com.application.ediaristas.core.repositories;

//import java.util.List;
import java.util.Optional;

import com.application.ediaristas.core.models.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByCpf(String cpf);
    
    Optional<Usuario> findByChavePix(String chavePix);

    //List<Usuario> findByCidadesAtendidasCodigoIbge(String codigoIbge);

    Boolean existsByCidadesAtendidasCodigoIbge(String codigoIbge);

    Page<Usuario> findByCidadesAtendidasCodigoIbge(String codigoIbge, Pageable pageable); // ...domain.Pageable

    /*@Query("SELECT COUNT(*) > 0 FROM Usuario u WHERE u.email = :email AND (:id IS NULL OR u.id != :id)")
    Boolean isEmailJaCadastrado(String email, Long id);*/

    /* ---------------------------
    // isso só funciona a partir do java-15 --> aqui é java-11
    @Query(
       """
        SELECT AVG(u.reputacao) FROM Usuario u WHERE u.tipoUsuario = 'Diarista'
        """;
    )
    Double getMediaReputacaoDiarista();
    // ou: WHERE u.tipoUsuario = com.application.ediaristas.core.models.TipoUsuario.Diarista

    ----------------------------------- */

    @Query("SELECT AVG(u.reputacao) From Usuario u WHERE u.tipoUsuario = 'Diarista'")
    Double getMediaReputacaoDiarista();

    default Boolean isEmailJaCadastrado(Usuario usuario) {
        if (usuario.getEmail() == null) {
            return false;
        }

        return findByEmail(usuario.getEmail())
            .map(usuarioEncontrado -> !usuarioEncontrado.getId().equals(usuario.getId()))
            .orElse(false);
    }

    default Boolean isCpfJaCadastrado(Usuario usuario) {
        if (usuario.getCpf() == null) {
            return false;
        }

        return findByCpf(usuario.getCpf())
            .map(usuarioEncontrado -> !usuarioEncontrado.getId().equals(usuario.getId()))
            .orElse(false);
    }

    default Boolean isChavePixJaCadastrada(Usuario usuario) {
        if (usuario.getChavePix() == null) {
            return false;
        }

        return findByChavePix(usuario.getChavePix())
            .map(usuarioEncontrado -> !usuarioEncontrado.getId().equals(usuario.getId()))
            .orElse(false);
    }
}
