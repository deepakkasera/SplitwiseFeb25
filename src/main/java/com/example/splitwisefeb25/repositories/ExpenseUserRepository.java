package com.example.splitwisefeb25.repositories;

import com.example.splitwisefeb25.models.ExpenseUser;
import com.example.splitwisefeb25.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findByUser(User user);
    //select * from expense_users where user_id = ?
}
