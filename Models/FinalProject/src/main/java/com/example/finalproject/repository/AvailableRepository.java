package com.example.finalproject.repository;

import com.example.finalproject.entity.Available;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableRepository extends CrudRepository<Available, Long> {

        List<Available> findByModelId(long id);
        void deleteByModelId(long id);

}
