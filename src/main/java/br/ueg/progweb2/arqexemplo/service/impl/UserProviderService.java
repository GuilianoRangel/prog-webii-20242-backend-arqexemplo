package br.ueg.progweb2.arqexemplo.service.impl;

import br.ueg.progweb2.arquitetura.model.dtos.AuthUserDTO;
import br.ueg.progweb2.arquitetura.model.dtos.CredencialDTO;
import br.ueg.progweb2.arquitetura.service.IUserProviderService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserProviderService implements IUserProviderService {



    @Override
    public CredencialDTO getCredentialByLogin(String username) {

        return getCredencialDTO();
    }

    private static CredencialDTO getCredencialDTO() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCodificada = bCryptPasswordEncoder.encode("admin");
        return CredencialDTO.builder()
                .login("admin")
                .id(1L)
                .name("Admin")
                .email("admin@admin.com.br")
                .roles(Arrays.asList(
                        "ROLE_ADMIN",
                        "ROLE_PERSON_CREATE",
                        "ROLE_PERSON_READ",
                        "ROLE_PERSON_UPDATE",
                        "ROLE_PERSON_DELETE",
                        "ROLE_PERSON_READ_ALL",

                        "ROLE_CATEGORY_CREATE",
                        "ROLE_CATEGORY_READ",
                        "ROLE_CATEGORY_UPDATE",
                        "ROLE_CATEGORY_DELETE",
                        "ROLE_CATEGORY_READ_ALL",

                        "ROLE_STUDENT_CREATE",
                        "ROLE_STUDENT_READ",
                        "ROLE_STUDENT_UPDATE",
                        "ROLE_STUDENT_DELETE",
                        "ROLE_STUDENT_READ_ALL",

                        "ROLE_TASK_CREATE",
                        "ROLE_TASK_READ",
                        "ROLE_TASK_UPDATE",
                        "ROLE_TASK_DELETE",
                        "ROLE_TASK_READ_ALL"
                ))
                .activeState(true)
                .password(senhaCodificada)
                .build();
    }

    @Override
    public CredencialDTO resetPassword(AuthUserDTO authUserDTO) {
        return null;
        //return usuarioMapper.toCredentialDTO(this.usuarioService.redefinirSenha(usuarioSenhaDTO));
    }

    @Override
    public CredencialDTO getCredentialByEmail(String email) {
        //TODO retornando fixo
        return getCredencialDTO();
    }
}
