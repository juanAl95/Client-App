package com.credibanco.CrudApp.Controller;

import com.credibanco.CrudApp.DTO.UserDTORequest;
import com.credibanco.CrudApp.DTO.UserDTOResponse;
import com.credibanco.CrudApp.Service.IUsuarioService;
import com.credibanco.CrudApp.Service.Impl.UsuarioImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioImpl usuarioImpl;
    @Autowired
    IUsuarioService iUsuarioService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody UserDTORequest userDTORequest) {

        logger.info("----HttpRequest Create User ----");
        UserDTOResponse response = usuarioImpl.createUser(userDTORequest);
        logger.info("----Peticion Fializada ----");

        return ResponseEntity.ok(response);

    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> readUser(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        List<UserDTOResponse> listUser = this.iUsuarioService.readUser(id);
        response.put("data", listUser);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTORequest usuarioDTORequest) {
        return null;

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Object> deleteUser(@PathVariable Long id) {
        try {
                UserDTOResponse res = iUsuarioService.deleteUser(id);


                return new ResponseEntity<>(res, HttpStatus.OK);

        }catch(Exception e) {
            logger.info("-----Se detecto un error-----");

        }
        return null;
    }


}
