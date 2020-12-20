
package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.InviteInfoDao;
import com.example.tagtool.tagEntity.InviteInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InviteInfoService {
    @Resource
    private InviteInfoDao inviteInfoDao;
    //    插入邀请人员信息
    public int insertInviteInfo(InviteInfo inviteInfo){return inviteInfoDao.insertInviteInfo(inviteInfo);}
    //    根据任务id和受邀人账号更新接受状态
    public int updateIsJoinByInviteeAndTaskId(String invitee, Integer is_join, Integer task_id){return inviteInfoDao.updateIsJoinByInviteeAndTaskId(invitee, is_join, task_id);}
    //    根据任务id删除邀请信息
    public int deleteInviteByTaskId(Integer task_id){return inviteInfoDao.deleteInviteByTaskId(task_id);}
    //    根据受邀人和接受状态查询邀请信息
    public List<InviteInfo>  findInviteInfoByInviteeAndIsJoin(String invitee, Integer is_join){return inviteInfoDao.findInviteInfoByInviteeAndIsJoin(invitee, is_join);}
    //    根据邀请人和任务id查询邀请信息
    public List<InviteInfo>  findInviteInfoByInviterAndTaskId(String inviter, Integer task_id){return inviteInfoDao.findInviteInfoByInviterAndTaskId(inviter, task_id);}
    //    根据受邀人和任务id查询是否有邀请信息
    public List<InviteInfo>  findInviteInfoByInviteeAndTaskId(String invitee, Integer task_id){return inviteInfoDao.findInviteInfoByInviteeAndTaskId(invitee, task_id);}
    //      根据受邀人查询邀请信息
    public List<InviteInfo>  findInviteInfoByInvitee(String invitee){return inviteInfoDao.findInviteInfoByInvitee(invitee);}

}