package com.credibanco.CrudApp.Service;

import java.util.List;

import com.credibanco.CrudApp.Entity.Usuario;
import com.credibanco.dependency.Library.Dto.UserDTORequest;
import com.credibanco.dependency.Library.Dto.UserDTOResponse;



public interface IUsuarioService {
    
	UserDTOResponse createUser (UserDTORequest usuarioDTORequest);
    List<UserDTOResponse> readUser (Long id);
    UserDTOResponse update(UserDTORequest userDTORequest);
    UserDTOResponse deleteUser (Long id );
    Usuario readUsuario(Long id);

}
