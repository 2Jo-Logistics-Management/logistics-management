package com.douzon.smartlogistics.global.common.aop;

import com.douzon.smartlogistics.domain.account.dto.AccountInsertDto;
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
    @Autowired
    public IpInseartAspect(HttpSession httpSession) {
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
        return (String)httpSession.getAttribute("session");
    }
}
