package com.huatec.service;

import com.huatec.domain.SysLog;

import java.util.List;

public interface SysLogService {

    List<SysLog> sysLogList();

    void saveLog(SysLog sysLog);
}
