
package priv.quqinzhang.authentication.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.quqinzhang.authentication.common.factory.BoFactory;
import priv.quqinzhang.authentication.config.AppContext;
import priv.quqinzhang.authentication.domain.UserBO;
import priv.quqinzhang.authentication.dto.in.UserInDTO;

import java.lang.reflect.InvocationTargetException;


/**
 * @author Quqin Zhang
 * @date 2019/12/26 23:24
 * @description
 */

@SpringBootTest
public class BoFactoryTest {

    @Autowired
    private AppContext appContext;

    @Test
    void testGetBo() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BoFactory factory = new BoFactory(appContext);
//        factory.setAppContext(appContext);

        UserBO userBO = factory.getBO(UserBO.class);
        UserInDTO userInDTO = new UserInDTO();
//        userBO.login(userInDTO);
    }

}

