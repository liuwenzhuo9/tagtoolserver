package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.User;
import com.example.tagtool.tagService.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {
    @Resource
    private UserService userService;

//    插入人员信息
    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public ResponseBean insertUserInfo(User user){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(userService.insertUserInfo(user));
        responseBean.setMessage("插入成功");
        return responseBean;
    }

    //根据用户账号查询任务情况
    @RequestMapping("/findInfoByUserAccount")
    @ResponseBody
    public ResponseBean findInfoByUserAccount(String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userService.findInfoByUserAccount(account));
        return responseBean;
    }

//    根据用户账号更新任务情况
    @RequestMapping("/updateTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateTasksByUserAccount(account,involved_tasks,finished_tasks,progress_tasks,issue_tasks));
        return responseBean;
    }

    @RequestMapping("/updateJoinTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateJoinTasksByUserAccount(String account,String involved_tasks,String progress_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateJoinTasksByUserAccount(account,involved_tasks,progress_tasks));
        return responseBean;
    }

    @RequestMapping("/updateFinishTasksByUserAccount")
    @ResponseBody
    public ResponseBean updateFinishTasksByUserAccount(String account,String progress_tasks,String finished_tasks){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateFinishTasksByUserAccount(account, progress_tasks, finished_tasks));
        return responseBean;
    }

    //    根据用户账号更新标签标注成绩
    @RequestMapping("/updateLabelPowerByUserAccount")
    @ResponseBody
    public ResponseBean updateLabelPowerByUserAccount(String account,String power_l){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateLabelPowerByUserAccount(account,power_l));
        return responseBean;
    }

    //    根据用户账号更新序列标注成绩
    @RequestMapping("/updateSequencePowerByUserAccount")
    @ResponseBody
    public ResponseBean updateSequencePowerByUserAccount(String account,String power_s){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateSequencePowerByUserAccount(account,power_s));
        return responseBean;
    }

    @RequestMapping("/updateLabelScoresByUserAccount")
    @ResponseBody
    public ResponseBean updateLabelScoresByUserAccount(String account,String label_scores){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateLabelScoresByUserAccount(account,label_scores));
        return responseBean;
    }

    @RequestMapping("/updateSequenceScoresByUserAccount")
    @ResponseBody
    public ResponseBean updateSequenceScoresByUserAccount(String account,String sequence_scores){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userService.updateSequenceScoresByUserAccount(account,sequence_scores));
        return responseBean;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResponseBean deleteUser(String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("删除成功");
        responseBean.setData(userService.deleteUser(account));
        return responseBean;
    }

}
 