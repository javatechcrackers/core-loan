package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RedisDataService {
    public List<UserModel> getCacheList();

}
