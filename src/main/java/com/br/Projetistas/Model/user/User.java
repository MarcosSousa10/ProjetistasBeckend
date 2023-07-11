package com.br.Projetistas.Model.user;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

@Table(name = "PCEMPR")
@Entity(name = "PCEMPR")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "matricula")
    private String id;
        @Column(name = "nome_guerra")

    private String login;
    @Column(name = "senhabd")
    private String password;
    @Column(name = "codfornec")
    private UserRole role;

    public User(String login, String password, UserRole role){
        this.login = login;
        this.role = role;
         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

            public String getPassword() {
        // Conexão com o banco de dados
java.sql.Connection connection;
try {
    connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.30:1521/wint", "OTHON", "OTHON");


// Consulta SQL
String sql = "SELECT DECRYPT(SENHABD, nome_guerra) AS senha FROM PCEMPR WHERE NOME_GUERRA = '" + login + "' and voipmundoidchamada = 'S' ";

// Executa a consulta
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(sql);

// Verifica se há um resultado
if (resultSet.next()) {
    // Obtém a senha descriptografada do resultado da consulta
    String senhaDescriptografada = resultSet.getString("senha");

    // Atribui a senha descriptografada à variável password
    password = senhaDescriptografada;
}

// Fecha os recursos
resultSet.close();
statement.close();
connection.close();
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      return  this.password = passwordEncoder.encode(password);
        
    }

    public void setPassword(String password) {
        
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
}
