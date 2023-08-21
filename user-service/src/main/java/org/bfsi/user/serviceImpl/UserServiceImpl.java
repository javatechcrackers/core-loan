package org.bfsi.user.serviceImpl;

import org.bfsi.user.entity.LoanRequest;
import org.bfsi.user.entity.User;
import org.bfsi.user.respository.LoanRepository;
import org.bfsi.user.respository.UserRepository;
import org.bfsi.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    //@Cacheable(value = "user", key = "#id")
    public User getUser(long id) {
        logger.info("Calling getUser for id:" + id);
        return userRepository.findById(id).get();
    }

    @Override
    //@CachePut(value = "user", key = "#user.userId")
    public User saveUser(User user) {
        logger.info("Calling save for user:" + user.toString());
        return userRepository.save(user);

    }

    //@CachePut(value = "user", key = "#user.userId")
    public LoanRequest saveLoanData(LoanRequest loanRequest) {
        logger.info("Calling save for user:" + loanRequest.toString());
        return loanRepository.save(loanRequest);

    }

    @Override
    //@CachePut(value = "user", key = "#user.userId")
//    @Caching(evict = {
//            @CacheEvict(value = "user", key = "#id")
//    })
    @CacheEvict("user")
    public User updateUser(User user) {
        logger.info("Calling update for user:" + user.toString());
        return userRepository.saveAndFlush(user);

    }

    @Override
//    @Caching(evict = {
//            @CacheEvict(value = "user", key = "#id")
//    })
    public void deleteUser(Long id) {
        logger.info("Calling Delete for userid:" + id);

        userRepository.deleteById(id);
    }

}
