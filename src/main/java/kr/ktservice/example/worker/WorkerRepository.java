package kr.ktservice.example.worker;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface WorkerRepository extends Repository<Worker, Integer> {
    @Transactional(readOnly = true)
    @Cacheable("workers")
    Collection<Worker> findAll() throws DataAccessException;
}
