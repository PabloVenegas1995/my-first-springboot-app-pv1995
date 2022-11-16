package com.pv1995.my_first_springboot_app_pv1995.repos;

import com.pv1995.my_first_springboot_app_pv1995.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
