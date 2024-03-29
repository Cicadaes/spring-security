package com.auth.center.springsecurity.common.handler;

import com.auth.center.springsecurity.common.model.R;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @version
 * @Description
 * @Author lqq
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

  /**
   * 未登录或无权限时触发的操作
   * 返回  {"code":401,"message":"你没有携带 token 或者 token 无效！","data":""}
   * @param httpServletRequest
   * @param httpServletResponse
   * @param e
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
      //返回json形式的错误信息
      httpServletResponse.setCharacterEncoding("UTF-8");
      httpServletResponse.setContentType("application/json");

      httpServletResponse.getWriter().println(R.error("401","你没有携带 token 或者 token 无效！"));
      httpServletResponse.getWriter().flush();
  }

}
