package com.credibanco.CrudApp.Service;

import com.credibanco.CrudApp.DTO.UserDTORequest;
import com.credibanco.CrudApp.DTO.UserDTOResponse;
import com.credibanco.CrudApp.Entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    UserDTOResponse createUser (UserDTORequest usuarioDTORequest) ;
    List<UserDTOResponse> readUser (Long id);
    UserDTOResponse update (UserDTORequest usuarioDTORequest);
    UserDTOResponse deleteUser (Long id );
    Usuario readUsuario(Long id);

}
