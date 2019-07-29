package com.sheng.Action;

import com.sheng.Service.back.ITravelCostServiceBack;
import com.sheng.Service.back.ITypeServiceBack;
import com.sheng.vo.TravelCost;
import com.sheng.vo.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/*")
@Controller
public class TypeAction {
    @Resource(name = "ITypeServiceBackImpl")
    private ITypeServiceBack typeService;
    @Resource(name = "ITravelCostServiceBackImpl")
    private ITravelCostServiceBack TravelCostService;
    @RequestMapping("TypeList")
    public ModelAndView TypeList(TravelCost travelCost){
        ModelAndView md=new ModelAndView();
        //因为当申请初始创建的时候travel_cost中没有新建对应的tid,造成页面容易产生空指针错误
        //首先先检查是否存在此travel_cost表中是否存在此指针,没有则需要创建
        if (TravelCostService.hasTid(travelCost)) {
            //获得选项所有类型
            List<Type> types = typeService.findAllType();
            //获得TravelCost详细费用
            List<TravelCost> list = TravelCostService.findListById(travelCost);
            //获得当前申请的总费用
            Double total = TravelCostService.getCount(travelCost);
            md.addObject("list", list);
            md.addObject("types", types);
            md.addObject("total", total);
            md.setViewName("/total-list.jsp");
            return md;
        }else {
            return null;
        }
    }
}
