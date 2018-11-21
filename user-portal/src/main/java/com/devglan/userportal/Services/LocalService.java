package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Local;

import java.util.List;

public interface LocalService {
    Local create(Local local);

    Local delete(int id);

    List<Local> findAll();

    Local findById(int id);

    Local update(Local local);
}
