package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.InviteInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InviteInfoDao {
    //    插入邀请人员信息
    int insertInviteInfo(InviteInfo inviteInfo);
    //    根据任务id和受邀人账号更新接受状态
    int updateIsJoinByInviteeAndTaskId(String invitee, Integer is_join, Integer task_id);
    //    根据任务id删除邀请信息
    int deleteInviteByTaskId(Integer task_id);
    //    根据受邀人和接受状态查询邀请信息
    List<InviteInfo>  findInviteInfoByInviteeAndIsJoin(String invitee, Integer is_join);
    //    根据邀请人和任务id查询邀请信息
    List<InviteInfo>  findInviteInfoByInviterAndTaskId(String inviter, Integer task_id);
//    根据受邀人和任务id查询是否有邀请信息
    List<InviteInfo>  findInviteInfoByInviteeAndTaskId(String invitee, Integer task_id);
//    根据受邀人查询邀请信息
    List<InviteInfo>  findInviteInfoByInvitee(String invitee);
}
