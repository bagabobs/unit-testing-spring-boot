package baga.len.unittesting.controller;

import baga.len.unittesting.bussiness.ItemBussinessService;
import baga.len.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ItemBussinessService itemBussinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"chiki ball\"}"))
                .andReturn();

    }

    @Test
    public void dummyItemUsingItemBusinessService() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-businness-service")
                .accept(MediaType.APPLICATION_JSON);

        when(itemBussinessService.retreiveHardCodedItem()).thenReturn(new Item(2, "jajang", 1, 200));
        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(MockMvcResultMatchers.content().json("{id:2, name:jajang}"))
                .andReturn();
    }
}
