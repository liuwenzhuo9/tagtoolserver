package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.UserInfo;
import com.example.tagtool.tagService.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

//    插入人员信息
    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public ResponseBean insertUserInfo(UserInfo userInfo){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(userInfoService.insertUserInfo(userInfo));
        responseBean.setMessage("插入成功");
        return responseBean;
    }

    //根据用户账号查询任务情况
    @RequestMapping("/findInfoByUserAccount")
    @ResponseBody
    public ResponseBean findInfoByUserAccount(String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userInfoService.findInfoByUserAccount(account));
        return responseBean;
    }

//    根据用户账号更新任务情况
    @RequestMapping("/updateTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userInfoService.updateTasksByUserAccount(account,involved_tasks,finished_tasks,progress_tasks,issue_tasks));
        return responseBean;
    }
//当用户发布任务时，根据用户账号更新参与任务和进行的任务情况
    @RequestMapping("/updateJoinTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateJoinTasksByUserAccount(String account,String involved_tasks,String progress_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userInfoService.updateJoinTasksByUserAccount(account,involved_tasks,progress_tasks));
        return responseBean;
    }
//    当用户完成任务时，根据用户账号更新已完成的任务情况
    @RequestMapping("/updateFinishTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateFinishTasksByUserAccount(String account,String progress_tasks,String finished_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userInfoService.updateFinishTasksByUserAccount(account, progress_tasks, finished_tasks));
        return responseBean;
    }

//根据用户账号删除user信息
    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResponseBean deleteUser(String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("删除成功");
        responseBean.setData(userInfoService.deleteUser(account));
        return responseBean;
    }
//根据用户账号更新用户积分情况
    @RequestMapping("/updatePointsByAccount")
    @ResponseBody
    public ResponseBean updatePointsByAccount(Double points, String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userInfoService.updatePointsByAccount(points, account));
        return responseBean;
    }
//    根据用户账号更新用户标注能力
    @RequestMapping("/updatePowerByAccount")
    @ResponseBody
    public ResponseBean updatePowerByAccount(Double power_l1, Double power_l2, Double power_l3, Double power_s, String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userInfoService.updatePowerByAccount(power_l1, power_l2, power_l3, power_s, account));
        return responseBean;
    }
//    根据任务类型查询能力排序前20的用户信息
    @RequestMapping("/findTopUserOnLabelType")
    @ResponseBody
    public ResponseBean findTopUserOnLabelType(String type){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userInfoService.findTopUserOnLabelType(type));
        return responseBean;
    }
}
 