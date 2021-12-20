package com.huatec.service;

import com.huatec.domain.Pro;

import java.util.List;

public interface ProService {
    List<Pro> proList();

    void delPro(String productNum);

    List<Pro> findOne(String productNum);

    void editorPro(String productNum);

    void addPro(Pro pro);

    void updatePro(Pro pro);
}
