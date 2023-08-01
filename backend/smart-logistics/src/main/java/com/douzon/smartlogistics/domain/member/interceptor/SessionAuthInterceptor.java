package com.douzon.smartlogistics.domain.member.interceptor;

import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Component
public class SessionAuthInterceptor implements HandlerInterceptor {

    private final MemberService memberService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //어노테이션 체크 - Controller에 @Auth 어노테이션이 있는지 확인
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        if (hasAnnotation) {

            //어노테이션이 있으면서, User의 정보가 맞다면 true 반환
            //request에서 session 받아오기
            HttpSession session = request.getSession();
            Object memberNo = session.getAttribute("session");//sessionMember객체로 저장된 객체 반환
            if(memberNo == null)
                throw new AuthException("로그인 중이 아닙니다.");
            Member member = memberService.searchMember((Long)memberNo);

//          log.info("memberRole,  : {}", memberRole);

            //User의 정보는 DB에서 불러오지만, 여기서는 간단히 하기 위해 임의의 값으로 확인
            // walter와 20이 세션정보에 있을 때 권한이 있는것으로 가정

            if (member.getMemberRole().equals("ADMIN"))  {
                return true;
            }

            throw new AuthException("권한이 없습니다.");
        }

        //Auth를 실패하더라도 Controller를 실행하기 위해서는 true로 설정해야한다. ex)/session/add의 경우 walter/20 이 아닌 다른 값이 들어가도 실행되어야 한다.
        return true;
    }


    private boolean checkAnnotation(Object handler, Class<Auth> authClass) {
        //js. html 타입인 view 과련 파일들은 통과한다.(view 관련 요청 = ResourceHttpRequestHandler)
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        //Auth anntotation이 있는 경우
        if (null != handlerMethod.getMethodAnnotation(authClass) || null != handlerMethod.getBeanType().getAnnotation(authClass)) {
            return true;
        }

        //annotation이 없는 경우
        return false;
    }

}
