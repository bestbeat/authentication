package priv.quqinzhang.authentication;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import priv.quqinzhang.authentication.dto.in.TokenInDTO;
import priv.quqinzhang.authentication.dto.out.TokenValidateOutDTO;
import priv.quqinzhang.authentication.enums.ResponseCodeEnum;
import priv.quqinzhang.authentication.model.ResponseModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 23:00
 * @description 认证过滤器
 */
@Slf4j
@Setter
public class AuthenticationClientFilter implements Filter {

    private AuthenticationClient client;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("AuthenticationClientFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 客户端用Authorization 头 Bearer 模式传递 token
        String token = httpServletRequest.getHeader("Authorization");
        TokenInDTO tokenInDTO = new TokenInDTO();
        tokenInDTO.setRefresh(false);
        tokenInDTO.setToken(token);
        ResponseModel<TokenValidateOutDTO> responseModel = client.validate(tokenInDTO);
        if (ResponseCodeEnum.SUCCESS.equals(responseModel.getCode())) {
            chain.doFilter(request, response);
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("验证失败");
            writer.flush();
        }


    }

    @Override
    public void destroy() {
        log.info("AuthenticationClientFilter destroyed");
    }

}
