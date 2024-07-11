package com.example.MF.Repository;

import com.example.MF.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String emaill);

    public User findByVerificationCode(String code);

    @Query("update User u set u.failedAttempt=?1 where u.email=?2")
    @Modifying
    public void updateFailedAttempt(int failedAttempt,String email);

}
