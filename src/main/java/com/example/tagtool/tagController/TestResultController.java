package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.TestResult;
import com.example.tagtool.tagService.TestContentService;
import com.example.tagtool.tagService.TestResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestResultController {
    @Resource
    private TestResultService testResultService;
    @Resource
    private TestContentService testContentService;

    @RequestMapping("/insertTestRes")
    @ResponseBody
    public ResponseBean insertTestRes(TestResult testResult){
        int data = testResultService.insertTestRes(testResult);
        if(data == 1){
            return new ResponseBean("插入成功",data);
        }else{
            return new ResponseBean("插入失败",data);
        }
    }

    @RequestMapping("/updateTestResById")
    @ResponseBody
    public ResponseBean updateTestResById(Integer id,String res_label){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(testResultService.updateTestResById(id,res_label));
        return responseBean;
    }

        @RequestMapping("/deleteTestLabelByAccount")
    @ResponseBody
    public ResponseBean deleteTestLabelByAccount(String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testResultService.deleteTestLabelByAccount(user_account));
        responseBean.setMessage("删除成功");
        return responseBean;
    }

    @RequestMapping("/deleteTestLabelByTaskId")
    @ResponseBody
    public ResponseBean deleteTestLabelByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testResultService.deleteTestLabelByTaskId(task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }

    @RequestMapping("/findTestLabelByTaskAndParagraph")
    @ResponseBody
    public ResponseBean findTestLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(testResultService.findTestLabelByTaskAndParagraph(task_id, paragraph_id));
        return responseBean;
    }

    @RequestMapping("/findFinishTestParagraphNumByTaskId")
    @ResponseBody
    public ResponseBean findFinishTestParagraphNumByTaskId(Integer task_id,String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(testResultService.findFinishTestParagraphNumByTaskId(task_id, user_account));
        return responseBean;
    }

    @RequestMapping("/findFirstUnfinishedTestParagraph")
    @ResponseBody
    public ResponseBean findFirstUnfinishedTestParagraph(Integer task_id,String user_account){
        List<TestResult> data = testResultService.findFirstUnfinishedTestParagraph(task_id, user_account);
        TestResult dataLabel = data.get(0);
        int resultId = dataLabel.getId();
        String[] arr =new String[2];
        arr[0] = Integer.toString(resultId);
        arr[1] = dataLabel.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(testContentService.findTestContentByParagraphId(dataLabel.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }
    @RequestMapping("/findNextUnfinishedTestParagraph")
    @ResponseBody
    public ResponseBean findNextUnfinishedTestParagraph(Integer task_id,String user_account,String paragraph_position){
        List<TestResult> dataN = testResultService.findNextUnfinishedTestParagraph(task_id, user_account,paragraph_position);
        TestResult dataNext = dataN.get(0);
        int resultId = dataNext.getId();
        String[] arr =new String[2];
        arr[0] = Integer.toString(resultId);
        arr[1] = dataNext.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(testContentService.findTestContentByParagraphId(dataNext.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findLastUnfinishedTestParagraph")
    @ResponseBody
    public ResponseBean findLastUnfinishedTestParagraph(Integer task_id,String user_account,String paragraph_position){
        List<TestResult> dataL = testResultService.findLastUnfinishedTestParagraph(task_id, user_account,paragraph_position);
        TestResult dataLast = dataL.get(0);
        int resultId = dataLast.getId();
        String[] arr =new String[2];
        arr[0] = Integer.toString(resultId);
        arr[1] = dataLast.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(testContentService.findTestContentByParagraphId(dataLast.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findTestLabelResultById")
    @ResponseBody
    public ResponseBean findTestLabelResultById(Integer id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testResultService.findTestLabelResultById(id));
        responseBean.setMessage("查找成功");
        return responseBean;
    }
}
