package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.InviteInfo;
import com.example.tagtool.tagService.InviteInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InviteInfoController {
    @Resource
    private InviteInfoService inviteInfoService;

    //    插入邀请人员信息
    @RequestMapping("/insertInviteInfo")
    @ResponseBody
    public ResponseBean insertInviteInfo(InviteInfo inviteInfo){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.insertInviteInfo(inviteInfo));
        responseBean.setMessage("插入成功");
        return responseBean;
    }
    //    根据任务id和受邀人账号更新接受状态
    @RequestMapping("/updateIsJoinByInviteeAndTaskId")
    @ResponseBody
    public ResponseBean updateIsJoinByInviteeAndTaskId(String invitee, Integer is_join, Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.updateIsJoinByInviteeAndTaskId(invitee, is_join, task_id));
        responseBean.setMessage("更新成功");
        return responseBean;
    }
    //    根据任务id删除邀请信息
    @RequestMapping("/deleteInviteByTaskId")
    @ResponseBody
    public ResponseBean deleteInviteByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.deleteInviteByTaskId(task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }
    //    根据受邀人和接受状态查询邀请信息
    @RequestMapping("/findInviteInfoByInviteeAndIsJoin")
    @ResponseBody
    public ResponseBean findInviteInfoByInviteeAndIsJoin(String invitee, Integer is_join){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.findInviteInfoByInviteeAndIsJoin(invitee, is_join));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    //    根据邀请人和任务id查询邀请信息
    @RequestMapping("/findInviteInfoByInviterAndTaskId")
    @ResponseBody
    public ResponseBean findInviteInfoByInviterAndTaskId(String inviter, Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.findInviteInfoByInviterAndTaskId(inviter, task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    //    根据受邀人和任务id查询是否有邀请信息
    @RequestMapping("/findInviteInfoByInviteeAndTaskId")
    @ResponseBody
    public ResponseBean findInviteInfoByInviteeAndTaskId(String invitee, Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.findInviteInfoByInviteeAndTaskId(invitee, task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
//    根据受邀人查询邀请信息
    @RequestMapping("/findInviteInfoByInvitee")
    @ResponseBody
    public ResponseBean findInviteInfoByInvitee(String invitee){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(inviteInfoService.findInviteInfoByInvitee(invitee));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
}
