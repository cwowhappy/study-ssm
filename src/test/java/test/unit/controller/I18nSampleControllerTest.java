package test.unit.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

/**
 * Created by cwowhappy on 2017/8/22.
 */
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
public class I18nSampleControllerTest {
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testValidation() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("locale", "zh_CN");

        RequestBuilder requestBuilder;
        requestBuilder = MockMvcRequestBuilders.post("/i18n/sample.json")
                .cookie(new Cookie("locale", "zh_CN"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON_UTF8);
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }
}
