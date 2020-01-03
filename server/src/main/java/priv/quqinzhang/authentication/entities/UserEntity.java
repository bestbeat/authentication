package priv.quqinzhang.authentication.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Quqin Zhang
 * @date-time 2019/12/24 23:44
 * @description 用户实体类
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user", schema = "authentication")
@Data
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "create_man_name")
    private String createManName;

    @Column(name = "create_man")
    private String createMan;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "update_man_name")
    private String updateManName;

    @Column(name = "update_man")
    private String updateMan;


}
