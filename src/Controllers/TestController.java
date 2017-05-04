package Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import services.TestService;

@RestController
public class TestController {
	TestService ts = new TestService();

	@RequestMapping(value = "/")

	public String welcom() {


		return "hello";

	}
	
	@RequestMapping(value = "/create")

	public String createWorkfow() {

		ts.startWorkflow();
		return "home";

	}

	@RequestMapping(value = "/workflows" ,method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String,Object> getWorkflows() {
		Map<String, Object>data = new HashMap<String, Object>();
		List<Task>l=(List<Task>) ts.getWorkflows();
		data.put("workflows", l.toString());
		return data;

	}
}
