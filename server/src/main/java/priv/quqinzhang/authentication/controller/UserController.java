package priv.quqinzhang.authentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.quqinzhang.authentication.dto.in.UserInDTO;
import priv.quqinzhang.authentication.dto.out.SaveOutDTO;
import priv.quqinzhang.authentication.model.ResponseModel;
import priv.quqinzhang.authentication.service.UserService;

/**
 * @author Quqin Zhang
 * @date 2019/12/29 11:38
 * @description 用户控制器
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService userService;

    @PutMapping
    public ResponseModel<SaveOutDTO> modify(@RequestBody UserInDTO userInDTO) {
        return ResponseModel.success(userService.modify(userInDTO));
    }

    @PostMapping
    public ResponseModel<SaveOutDTO> register(@RequestBody UserInDTO userInDTO) {
        try {
            return ResponseModel.success(userService.register(userInDTO));
        } catch (Exception e) {
            log.error("user register error: ",e);
            return ResponseModel.systemError();
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
