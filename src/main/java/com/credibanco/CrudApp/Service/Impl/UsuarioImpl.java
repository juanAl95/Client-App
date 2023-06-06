package com.credibanco.CrudApp.Service.Impl;

import com.credibanco.CrudApp.DTO.UserDTORequest;
import com.credibanco.CrudApp.DTO.UserDTOResponse;
import com.credibanco.CrudApp.Entity.Usuario;
import com.credibanco.CrudApp.Repository.IUserRepository;
import com.credibanco.CrudApp.Service.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioImpl implements IUsuarioService {
    Logger logger = LoggerFactory.getLogger(UsuarioImpl.class);

    @Autowired
    IUserRepository userRepo;

    @Override
    public UserDTOResponse createUser(UserDTORequest userDTORequest) {

        logger.info("---llego al service---");

        Usuario entity = new Usuario();
        entity.setId(userDTORequest.getId());
        entity.setUserName(userDTORequest.getUserName());
        entity.setPassword(userDTORequest.getPassword());
        entity = userRepo.save(entity);

        logger.info("--Registro en base de datos--");

        UserDTOResponse response = new UserDTOResponse();
        response.setId(entity.getId());
        response.setPassword(entity.getPassword());
        response.setUserName(entity.getUserName());
        logger.info("--termino al proceso del service");
        return response;

    }

    @Override
    public List<UserDTOResponse> readUser(Long id) {
        UserDTOResponse userResponse = new UserDTOResponse();
        List<Usuario> listUsuario= userRepo.findAll();
        return listUsuario.stream().map(user -> {
            UserDTOResponse response = new UserDTOResponse();
            BeanUtils.copyProperties(user, response);
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTOResponse update(UserDTORequest usuarioDTORequest) {
        return null;
    }

    @Override
    public UserDTOResponse deleteUser(Long id) {

        UserDTOResponse response = new UserDTOResponse();
        try {
            logger.info("-------Entro a la base de datos------- ");
            Optional<Usuario> usuarioDelete = userRepo.findById(id);


            if (usuarioDelete != null) {
                userRepo.deleteById(id);
                response.setMessage("El usuario ha sido eliminado exitosamente.");

            }else {
                response.setMessage("No se encontró ningún usuario con el ID especificado.");
            }
                logger.info("-----El ususario ha sido eliminado-------- ");

        } catch (Exception e) {
            logger.info("-----Error----" + e);
            response.setMessage("Ocurrió un error al eliminar el usuario.");
        }
        return response;
    }

    @Override
    public Usuario readUsuario(Long id) {
        return null;
    }
}
