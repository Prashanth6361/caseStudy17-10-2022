package com.gl.caseStudy4.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.caseStudy4.bean.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, String> {
	Optional<Users> findUserByUsername(String username);

}
