package com.huatec.service.impl;

import com.huatec.domain.SysLog;
import com.huatec.domain.User;
import com.huatec.mapper.SysLogMapper;
import com.huatec.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;



//
//    public void saveUser(User user, Long[] roleIds) {
//        userMapper.saveUser(user);
//        Long userId = user.getId();
//        System.out.println(userId);
//        Map<String,Long> params = new HashMap<String,Long>();
//        params.put("userId",userId);
//        for (Long roleId:roleIds) {
//            params.put("roleId",roleId);
//            userMapper.saveUserRoleRel(params);
//        }
//
//    }


    @Override
    public List<SysLog> sysLogList() {
        List<SysLog> sysLogList = sysLogMapper.sysLogList();
        System.out.println(sysLogList);
        return sysLogList;
    }

    @Override
    public void saveLog(SysLog sysLog) {
        sysLogMapper.saveLog(sysLog);
    }
}
