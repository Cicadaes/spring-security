package com.auth.center.springsecurity.controller;


import com.auth.center.springsecurity.common.model.R;
import com.auth.center.springsecurity.common.model.Ticket;
import com.auth.center.springsecurity.dao.SysStatisticsMapper;
import com.auth.center.springsecurity.dao.TicketMapper;
import com.baiwang.mybatisx.sqlconverter.plugins.utils.SessionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 流水单信息表 前端控制器
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private SysStatisticsMapper sysStatisticsMapper;
    @Autowired
    private TicketMapper ticketMapper;

    @GetMapping("/setdb/{sess}")
    @ResponseBody
    public Object setSession(@PathVariable("sess") String sess){
        HttpSession httpSession= SessionUtil.getSession();
        httpSession.setAttribute("tenant_id",sess);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/list")
    public R list(){
        Map map = new HashMap<>();
        map.put("cdate", "2017-01-01 03:04:16");
        map.put("ctime", "2029-01-02 03:04:16");
        List<Ticket> rst = ticketMapper.searchByParam(map);
        return new R(rst);
    }

    @GetMapping("/count")
    public R count(){
        Map<String, Object> query = new HashMap<>(16);
        QueryWrapper ew = new QueryWrapper<>();
        return new R(ticketMapper.selectCount(ew));
    }
    @GetMapping("/insert")
    public R insert(){
        return new R(ticketMapper.insertData());
    }
}

