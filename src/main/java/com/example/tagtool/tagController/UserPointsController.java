package com.example.tagtool.tagController;

import com.example.tagtool.tagController.ResponseBean;
import com.example.tagtool.tagEntity.UserPoints;
import com.example.tagtool.tagService.UserPointsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserPointsController {
    @Resource
    private UserPointsService userPointsService;

    //    插入人员积分变动信息
    @RequestMapping("/insertUserPoints")
    @ResponseBody
    public ResponseBean insertUserPoints(UserPoints userPoints){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(userPointsService.insertUserPoints(userPoints));
        responseBean.setMessage("插入成功");
        return responseBean;
    }

    //根据任务id删除积分信息
    @RequestMapping("/deleteUserPointsByTaskId")
    @ResponseBody
    public ResponseBean deleteUserPointsByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("删除成功");
        responseBean.setData(userPointsService.deleteUserPointsByTaskId(task_id));
        return responseBean;
    }

    //    根据任务id和用户account删除积分信息
    @RequestMapping("/deleteUserPointsByAccount")
    @ResponseBody
    public ResponseBean deleteUserPointsByAccount(Integer task_id,String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("删除成功");
        responseBean.setData(userPointsService.deleteUserPointsByAccount(task_id, account));
        return responseBean;
    }
    //根据任务id和积分操作类型获取积分信息
    @RequestMapping("/findPointsByTaskId")
    @ResponseBody
    public ResponseBean findPointsByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userPointsService.findPointsByTaskId(task_id));
        return responseBean;
    }
    //    根据用户account和任务类型以及积分操作类型获取积分信息
    @RequestMapping("/findPointsByAccount")
    @ResponseBody
    public ResponseBean findPointsByAccount(String account,Integer operation_type){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userPointsService.findPointsByAccount(account,operation_type));
        return responseBean;
    }

    //根据任务id和用户account更新积分和能力变动信息
    @RequestMapping("/updatePointsByTaskIdAndAccount")
    @ResponseBody
    public ResponseBean updatePointsByTaskIdAndAccount(UserPoints userPoints){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userPointsService.updatePointsByTaskIdAndAccount(userPoints));
        return responseBean;
    }

}