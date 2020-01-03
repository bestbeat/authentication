package priv.quqinzhang.authentication.service;

import priv.quqinzhang.authentication.dto.in.UserInDTO;
import priv.quqinzhang.authentication.dto.out.SaveOutDTO;


/**
 * @author Quqin Zhang
 * @date 2019/12/29 12:44
 * @description 用户服务
 */
public interface UserService {

    /**
     * 修改用户信息
     * @param userInDTO 用户信息
     * @return 返回注册情况
     */
    SaveOutDTO modify(UserInDTO userInDTO);

    /**
     * 用户注册
     * @param userInDTO 用户信息
     * @return 返回注册情况
     * @throws Exception 异常
     */
    SaveOutDTO register(UserInDTO userInDTO) throws Exception;

}
