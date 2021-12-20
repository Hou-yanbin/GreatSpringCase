package com.huatec.mapper;

import com.huatec.domain.SysLog;

import java.util.List;

public interface SysLogMapper {

    List<SysLog> sysLogList();

    void saveLog(SysLog sysLog);
}
