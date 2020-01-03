package priv.quqinzhang.authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.quqinzhang.authentication.common.enums.SystemCodeEnum;
import priv.quqinzhang.authentication.common.utils.IdUtils;
import priv.quqinzhang.authentication.dto.in.UserInDTO;
import priv.quqinzhang.authentication.dto.out.SaveOutDTO;
import priv.quqinzhang.authentication.entities.UserEntity;
import priv.quqinzhang.authentication.repositories.UserRepository;
import priv.quqinzhang.authentication.service.UserService;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author Quqin Zhang
 * @date 2019/12/29 12:57
 * @description
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public SaveOutDTO modify(UserInDTO userInDTO) {
        LocalDateTime now = LocalDateTime.now();
        UserEntity entity = new UserEntity();

        entity.setEmail(userInDTO.getEmail());
        entity.setMobilePhone(userInDTO.getMobilePhone());
        entity.setPwd(userInDTO.getPwd());
        entity.setUpdateMan(userInDTO.getUpdateMan());
        entity.setUpdateManName(userInDTO.getUpdateManName());
        entity.setUpdateTime(now);
        entity.setUserId(userInDTO.getUserId());
        entity.setUsername(userInDTO.getUsername());

        userRepository.save(entity);
        SaveOutDTO outDTO = new SaveOutDTO();
        outDTO.setSaveSuccess(true);
        return outDTO;
    }

    @Override
    public SaveOutDTO register(UserInDTO userInDTO) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        UserEntity entity = new UserEntity();

        entity.setCreateMan(userInDTO.getCreateMan());
        entity.setCreateManName(userInDTO.getCreateManName());
        entity.setCreateTime(now);
        entity.setEmail(userInDTO.getEmail());
        entity.setMobilePhone(userInDTO.getMobilePhone());
        entity.setPwd(userInDTO.getPwd());
        entity.setUpdateMan(userInDTO.getUpdateMan());
        entity.setUpdateManName(userInDTO.getUpdateManName());
        entity.setUpdateTime(now);
        entity.setUserId(IdUtils.createUserId(SystemCodeEnum.TEST));
        entity.setUsername(userInDTO.getUsername());

        userRepository.save(entity);
        SaveOutDTO outDTO = new SaveOutDTO();
        outDTO.setSaveSuccess(true);
        return outDTO;
    }

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(3000,1,1,1,1,1,1);
//        dateTime.getLong(TemporalField)
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
