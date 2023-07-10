package com.br.Projetistas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.Projetistas.Model.Projetos;
import com.br.Projetistas.Model.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);


}
