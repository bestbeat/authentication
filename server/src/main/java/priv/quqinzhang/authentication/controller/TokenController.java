package priv.quqinzhang.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.quqinzhang.authentication.common.throwable.TokenIncorrectException;
import priv.quqinzhang.authentication.dto.in.TokenInDTO;
import priv.quqinzhang.authentication.dto.out.TokenValidateOutDTO;
import priv.quqinzhang.authentication.model.ResponseModel;
import priv.quqinzhang.authentication.service.TokenService;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 15:12
 * @description
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    private TokenService tokenService;

    @PostMapping("/validation")
    public ResponseModel<TokenValidateOutDTO> validate(@RequestBody TokenInDTO tokenInDTO) {
        try {
            TokenValidateOutDTO validateOutDTO = tokenService.validate(tokenInDTO);
            return ResponseModel.success(validateOutDTO);
        } catch (TokenIncorrectException e) {
            return ResponseModel.error(e.getResponseCodeEnum());
        }
    }

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }
}
