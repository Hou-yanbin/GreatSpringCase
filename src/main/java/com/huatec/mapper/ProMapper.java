package com.huatec.mapper;

import com.huatec.domain.Pro;

import java.util.List;

public interface ProMapper {
    List<Pro> proList();

    void delPro(String productNum);

    List<Pro> findOne(String productNum);

    void addPro(Pro pro);

    void updatePro(Pro pro);
}
