package com.travel.travel.dao;

import com.travel.travel.entity.reason;

import java.util.List;

public interface reasonDao {
    List<reason> queryReason();
    List<reason> queryReasonByUserId(Integer userid);
    int insertReason(reason reason);
}
