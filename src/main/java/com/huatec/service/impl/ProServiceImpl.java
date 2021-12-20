package com.huatec.service.impl;

import com.huatec.domain.Pro;
import com.huatec.mapper.ProMapper;
import com.huatec.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProServiceImpl implements ProService {
    @Autowired
    private ProMapper proMapper;

    @Override
    public List<Pro> proList() {
        List<Pro> proList = proMapper.proList();
        System.out.println(proList);
        return proList;
    }

    @Override
    public void delPro(String productNum) {
        proMapper.delPro(productNum);
    }

    @Override
    public List<Pro> findOne(String productNum) {
        List<Pro> onePro = proMapper.findOne(productNum);
        return onePro;
    }

    @Override
    public void editorPro(String productNum) {

    }

    @Override
    public void addPro(Pro pro) {
        proMapper.addPro(pro);
    }

    @Override
    public void updatePro(Pro pro) {
        proMapper.updatePro(pro);
    }
}
