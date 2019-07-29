package com.sheng.Action;

import com.sheng.Service.back.ITravelCostServiceBack;
import com.sheng.vo.TravelCost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/*")
public class TravelCostAction {
    @Resource(name = "ITravelCostServiceBackImpl")
    private ITravelCostServiceBack TravelCostService;
    @RequestMapping("/addTotal")
    @ResponseBody
    public boolean addTotal(@RequestBody TravelCost travelCost){
       return  TravelCostService.UpdateTotalAndCost(travelCost);

    }

    //显示对应Tid的费用详细情况
    @RequestMapping("TravelCostList")
    public ModelAndView TravelCostList(TravelCost travelCost){
        ModelAndView md=new ModelAndView();
        List<TravelCost> list=TravelCostService.findListById(travelCost);
        md.addObject("list",list);
        md.setViewName("/total-list.jsp");
        return md;
    }


    //根据tcid删除单独费用支出项
    @RequestMapping("deleteByTcid")
    @ResponseBody
    public boolean deleteBytcid(@RequestBody TravelCost travelCost){
         return TravelCostService.deleteById(travelCost);
    }

}
