package com.douzon.smartlogistics.global.common.aop;

import com.douzon.smartlogistics.domain.account.dto.AccountInsertDto;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.porder.dto.POrderInsertDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Aspect
@Component
@Order(1)
@SessionAttributes("session")
public class IpInseartAspect {

    private final HttpSession httpSession;
    private final MemberService memberService;
    @Autowired
    public IpInseartAspect(MemberService memberService, HttpSession httpSession) {
        this.memberService = memberService;
        this.httpSession = httpSession;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void PostMapping() {
    }
    @Before("PostMapping()")
    public void beforeControllerMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            
            if (arg instanceof AccountInsertDto) {
                ((AccountInsertDto) arg).setCreateId(getId());
                ((AccountInsertDto) arg).setCreateIp(getIpAddress());
                break;
            }

            if (arg instanceof ItemInsertDto) {
                ((ItemInsertDto) arg).setCreateId(getId());
                ((ItemInsertDto) arg).setCreateIp(getIpAddress());
                break;
            }


            if (arg instanceof POrderInsertDto) {
                ((POrderInsertDto) arg).setCreateId(getId());
                ((POrderInsertDto) arg).setCreateIp(getIpAddress());
                break;
            }

            if (arg instanceof POrderItemInsertDto) {
                ((POrderItemInsertDto) arg).setCreateId(getId());
                ((POrderItemInsertDto) arg).setCreateIp(getIpAddress());
                break;
            }

            if (arg instanceof ReceiveInsertDto) {
                ((ReceiveInsertDto) arg).setCreateId(getId());
                ((ReceiveInsertDto) arg).setCreateIp(getIpAddress());
                break;
            }

            if (arg instanceof ReceiveItemInsertDto) {
                ((ReceiveItemInsertDto) arg).setCreateId(getId());
                ((ReceiveItemInsertDto) arg).setCreateIp(getIpAddress());
                break;
            }


        }
    }
    private String getIpAddress() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            return localhost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Failed to retrieve IP address";
    }
    private String getId() {
        return memberService.searchMember(
                (Long)httpSession.getAttribute("session")).getMemberId();
    }
}
