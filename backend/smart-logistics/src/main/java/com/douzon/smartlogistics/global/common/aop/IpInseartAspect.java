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
            handleInsertDto(arg);
        }
    }

    private void handleInsertDto(Object arg) {
        if (arg instanceof AccountInsertDto) {
            AccountInsertDto accountInsertDto = (AccountInsertDto) arg;
            accountInsertDto.setCreateId(getId());
            accountInsertDto.setCreateIp(getIpAddress());
        } else if (arg instanceof ItemInsertDto) {
            ItemInsertDto itemInsertDto = (ItemInsertDto) arg;
            itemInsertDto.setCreateId(getId());
            itemInsertDto.setCreateIp(getIpAddress());
        } else if (arg instanceof POrderInsertDto) {
            POrderInsertDto pOrderInsertDto = (POrderInsertDto) arg;
            pOrderInsertDto.setCreateId(getId());
            pOrderInsertDto.setCreateIp(getIpAddress());
        } else if (arg instanceof POrderItemInsertDto) {
            POrderItemInsertDto pOrderItemInsertDto = (POrderItemInsertDto) arg;
            pOrderItemInsertDto.setCreateId(getId());
            pOrderItemInsertDto.setCreateIp(getIpAddress());
        } else if (arg instanceof ReceiveInsertDto) {
            ReceiveInsertDto receiveInsertDto = (ReceiveInsertDto) arg;
            receiveInsertDto.setCreateId(getId());
            receiveInsertDto.setCreateIp(getIpAddress());
        } else if (arg instanceof ReceiveItemInsertDto) {
            ReceiveItemInsertDto receiveItemInsertDto = (ReceiveItemInsertDto) arg;
            receiveItemInsertDto.setCreateId(getId());
            receiveItemInsertDto.setCreateIp(getIpAddress());
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
