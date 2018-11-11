package com.travel.travel.service;

import com.travel.travel.entity.reason;

import java.util.List;

public interface reasonService {
    List<reason> queryReason();
    List<reason> queryReasonByUserId(Integer userid);
    boolean insertReason(reason reason);
}
