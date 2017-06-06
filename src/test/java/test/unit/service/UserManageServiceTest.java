package test.unit.service;

import com.cwowhappy.ssm.common.enums.Gender;
import com.cwowhappy.ssm.model.UserModel;
import com.cwowhappy.ssm.service.UserManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by cwowhappy on 2017/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:spring-context.xml",
                "classpath:spring-context-dao.xml",
                "classpath:spring-context-mail.xml",
                "classpath:spring-context-template.xml"})
public class UserManageServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManageServiceTest.class);
    private UserManageService userManageService;

    @Test
    public void test() {
        UserModel userModel;
        userModel= new UserModel();
        userModel.setCode("D07823");
        userModel.setName("李晓毅");
        userModel.setGender(Gender.MALE);
        userModel.setBirthday(LocalDate.of(1988, 6, 11));
        userManageService.save(userModel);
        userManageService.delete("D07823");

        userModel= new UserModel();
        userModel.setCode("D07824");
        userModel.setName("李晓毅");
        userModel.setGender(Gender.FEMALE);
        userModel.setBirthday(LocalDate.of(1988, 6, 11));
        userManageService.save(userModel);

        List<UserModel> userModels = userManageService.findAllUsers();
        if(null != userModels) {
            userModels.forEach(user -> LOGGER.info("<{}, {}, {}, {}, {}>",
                    user.getCode(), user.getName(), user.getGender(),
                    user.getBirthday(), user.getDeleteTime()));
        }

    }

    @Autowired
    public void setUserManageService(UserManageService userManageService) {
        this.userManageService = userManageService;
    }
}
