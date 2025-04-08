package com.asharykin.kafka.repository;

import com.asharykin.kafka.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
