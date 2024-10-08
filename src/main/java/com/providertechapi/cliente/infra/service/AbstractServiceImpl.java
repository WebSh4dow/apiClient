package com.providertechapi.cliente.infra.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class AbstractServiceImpl<T, ID> implements AbstractService<T, ID> {

    protected JpaRepository<T, ID> repository;

    public AbstractServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id solicitado nao encontrado."));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }
}