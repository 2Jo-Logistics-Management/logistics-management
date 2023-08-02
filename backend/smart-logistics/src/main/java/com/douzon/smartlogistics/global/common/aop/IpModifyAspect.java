package com.douzon.smartlogistics.global.common.aop;

import com.douzon.smartlogistics.domain.account.dto.AccountInsertDto;
import com.douzon.smartlogistics.domain.account.dto.AccountModifyDto;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import com.douzon.smartlogistics.domain.item.dto.ItemModifyDto;
import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.porder.dto.POrderInsertDto;
import com.douzon.smartlogistics.domain.porder.dto.POrderModifyDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemModifyDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveInsertDto;
import com.douzon.smartlogistics.domain.receive.dto.ReceiveModifyDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemInsertDto;
import com.douzon.smartlogistics.domain.receiveitem.dto.ReceiveItemModifyDto;
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
public class IpModifyAspect {

    private final HttpSession httpSession;
    private final MemberService memberService;
    @Autowired
    public IpModifyAspect(MemberService memberService, HttpSession httpSession ) {
        this.httpSession = httpSession;
        this.memberService = memberService;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public void PatchMapping() {
    }
    @Before("PatchMapping()")
    public void beforeControllerMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof AccountModifyDto) {
                ((AccountModifyDto) arg).setModifyId(getId());
                ((AccountModifyDto) arg).setModifyIp(getIpAddress());
                break;
            }

            if (arg instanceof ItemModifyDto) {
                ((ItemModifyDto) arg).setModifyId(getId());
                ((ItemModifyDto) arg).setModifyIp(getIpAddress());
                break;
            }
            if (arg instanceof POrderModifyDto) {
                ((POrderModifyDto) arg).setModifyId(getId());
                ((POrderModifyDto) arg).setModifyIp(getIpAddress());
                break;
            }

            if (arg instanceof POrderItemModifyDto) {
                ((POrderItemModifyDto) arg).setModifyId(getId());
                ((POrderItemModifyDto) arg).setModifyIp(getIpAddress());
                break;
            }

            if (arg instanceof ReceiveModifyDto) {
                ((ReceiveModifyDto) arg).setModifyId(getId());
                ((ReceiveModifyDto) arg).setModifyIp(getIpAddress());
                break;
            }

            if (arg instanceof ReceiveItemModifyDto) {
                ((ReceiveItemModifyDto) arg).setModifyId(getId());
                ((ReceiveItemModifyDto) arg).setModifyIp(getIpAddress());
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
