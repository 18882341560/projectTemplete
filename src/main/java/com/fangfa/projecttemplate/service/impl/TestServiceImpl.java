package com.fangfa.projecttemplate.service.impl;

import com.fangfa.projecttemplate.exception.MessageException;
import com.fangfa.projecttemplate.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Override
    public void test()throws Exception{
        throw new MessageException("1001","测试错误","士大夫士大夫");
    }
}
