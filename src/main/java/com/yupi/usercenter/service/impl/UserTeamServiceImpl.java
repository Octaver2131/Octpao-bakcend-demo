package com.yupi.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yupi.usercenter.mapper.UserTeamMapper;
import com.yupi.usercenter.model.domain.UserTeam;
import com.yupi.usercenter.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author Octaver
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2025-07-08 18:45:14
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




