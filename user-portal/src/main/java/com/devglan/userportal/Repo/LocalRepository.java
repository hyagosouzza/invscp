package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Local;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocalRepository extends Repository<Local, Integer> {
    void delete(Local local);

    List<Local> findAll();

    Local findOne(int id);

    Local save(Local local);
}
