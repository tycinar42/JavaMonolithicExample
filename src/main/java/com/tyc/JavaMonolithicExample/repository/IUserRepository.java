package com.tyc.JavaMonolithicExample.repository;

import com.tyc.JavaMonolithicExample.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("select COUNT(m)>0 from User m where UPPER(m.email)=UPPER(?1) and m.password=?2")
    Boolean isExistUser(String email,String password);

    @Query("select m from User m where UPPER(m.email) = UPPER(?1)")
    User findByEmail(String email);
}
