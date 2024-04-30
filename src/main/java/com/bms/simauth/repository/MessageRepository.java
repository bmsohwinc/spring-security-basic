package com.bms.simauth.repository;

import com.bms.simauth.domain.ApplicationUser;
import com.bms.simauth.domain.Message;
import com.bms.simauth.domain.MessageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByUser(ApplicationUser user);
}
