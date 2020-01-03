package priv.quqinzhang.authentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.quqinzhang.authentication.common.throwable.ParameterEmptyException;
import priv.quqinzhang.authentication.common.throwable.TokenIncorrectException;
import priv.quqinzhang.authentication.common.throwable.UserNotFoundException;
import priv.quqinzhang.authentication.dto.in.UserLoginInDTO;
import priv.quqinzhang.authentication.dto.out.LoginStatusInfoOutDTO;
import priv.quqinzhang.authentication.model.ResponseModel;
import priv.quqinzhang.authentication.service.LoginService;


/**
 * @author Quqin Zhang
 * @date 2019/12/24 23:27
 * @description 登录控制器
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private LoginService loginService;

    @PostMapping("/user")
    public ResponseModel<LoginStatusInfoOutDTO> login(@RequestBody UserLoginInDTO userLoginInDTO) {
        LoginStatusInfoOutDTO loginStatusInfoOutDTO;
        try {
            loginStatusInfoOutDTO = loginService.login(userLoginInDTO);
        } catch (UserNotFoundException e) {
            return ResponseModel.error(e.getResponseCodeEnum(),String.format("%s:%s",e.getUsername(),e.getResponseCodeEnum().getMsg()) );
        } catch (TokenIncorrectException e) {
            return ResponseModel.error(e.getResponseCodeEnum());
        } catch (ParameterEmptyException e) {
            return ResponseModel.error(e.getResponseCodeEnum(),String.format("%s:%s",e.getParamName(),e.getResponseCodeEnum().getMsg()) );
        } catch (Exception e) {
            return ResponseModel.systemError();
        }

        return ResponseModel.success(loginStatusInfoOutDTO);
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
