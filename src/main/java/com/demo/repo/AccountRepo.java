package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Entity.Account;




public interface AccountRepo extends JpaRepository<Account,Long > {

}
