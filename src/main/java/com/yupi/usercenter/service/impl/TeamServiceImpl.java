package com.yupi.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.yupi.usercenter.mapper.TeamMapper;
import com.yupi.usercenter.model.domain.Team;
import com.yupi.usercenter.service.TeamService;
import org.springframework.stereotype.Service;

/**
* @author Octaver
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2025-07-08 18:45:14
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService {

}




