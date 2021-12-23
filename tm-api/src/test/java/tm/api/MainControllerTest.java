package tm.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import tm.api.service.ApiResultService;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApiResultService resultService;

	@Test
	public void testGetTeamSkillSuccessful() throws Exception {
		mockMvc.perform(get("/api/search/task?taskId=TASK_29")).andExpect(
				status().is2xxSuccessful());
	}

	@Test
	public void testGetTeamSkillFail() throws Exception {
		mockMvc.perform(get("/api/search/task?taskId=TASK29")).andExpect(
				status().is4xxClientError());
	}

}
