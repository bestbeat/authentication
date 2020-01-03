package priv.quqinzhang.authentication.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Data;
import priv.quqinzhang.authentication.repositories.UserRepository;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 22:16
 * @description 用户业务处理
 */
@Data
public class UserBO {


    private UserRepository userRepository;

    private JPAQueryFactory jpaQueryFactory;

}
