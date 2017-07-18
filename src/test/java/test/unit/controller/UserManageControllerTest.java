package test.unit.controller;

import com.cwowhappy.ssm.common.enums.Gender;
import com.cwowhappy.ssm.model.UserModel;
import com.cwowhappy.ssm.query.QueryUserFilter;
import com.cwowhappy.ssm.query.page.PageQueryParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;


/**
 * 用户管理controller测试
 * @author cwowhappy
 * 2017-06-02 Friday
 */
@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(name = "parent",
                locations = { "classpath:spring-context.xml",
                        "classpath:spring-context-dao.xml",
                        "classpath:spring-context-mail.xml",
                        "classpath:spring-context-template.xml"}),
        @ContextConfiguration(name = "child", locations = {"classpath:spring-mvc.xml"})
})
public class UserManageControllerTest {
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public void testValidation() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", "D07823");
        params.add("name", "李晓毅");
        params.add("gender", "11");
        params.add("birthday", "1988-06-11");

        RequestBuilder requestBuilder;
        requestBuilder = MockMvcRequestBuilders.post("/user/add.json").params(params)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON_UTF8);
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testAddInJson() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setCode("D07823");
        userModel.setName("李晓毅");
        userModel.setGender(Gender.MALE);
        userModel.setBirthday(LocalDate.of(1988, 6, 11));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String requestBody = objectMapper.writeValueAsString(userModel);
        RequestBuilder requestBuilder;
        requestBuilder = MockMvcRequestBuilders.post("/user/addInJsonWay.json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_UTF8);
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
    }

    public void testBatchDelete() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userCode", "D07823");
        params.add("userCode", "D07824");
        params.add("userCode", "D07825");

        RequestBuilder requestBuilder;
        requestBuilder = MockMvcRequestBuilders.post("/user/delete.json").params(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8);
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
    }

    public void testJson() throws Exception {
        QueryUserFilter queryUserFilter = new QueryUserFilter();
        queryUserFilter.setCode("D07823");
        PageQueryParam<QueryUserFilter> pageQueryParam = new PageQueryParam<>();
        pageQueryParam.setPageCurrent(1);
        pageQueryParam.setPageSize(10);
        pageQueryParam.setFilter(queryUserFilter);

        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        String json = objectMapper.writeValueAsString(pageQueryParam);

        RequestBuilder requestBuilder;
        requestBuilder = MockMvcRequestBuilders.post("/user/list/page.json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json)
                .accept(MediaType.APPLICATION_JSON_UTF8);
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());

    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }
}
