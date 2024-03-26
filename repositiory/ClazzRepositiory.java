package com.vn.devmaster.services.repositiory;

import com.vn.devmaster.services.entites.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepositiory extends JpaRepository<Clazz, Integer> {
}
