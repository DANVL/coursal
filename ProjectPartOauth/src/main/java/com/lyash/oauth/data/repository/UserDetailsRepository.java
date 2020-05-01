package com.lyash.oauth.data.repository;

import com.lyash.oauth.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
