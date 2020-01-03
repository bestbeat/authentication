package priv.quqinzhang.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.quqinzhang.authentication.entities.UserEntity;

/**
 * @author Quqin Zhang
 * @date-time 2019/12/25 0:17
 * @description 用户实体仓库
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
