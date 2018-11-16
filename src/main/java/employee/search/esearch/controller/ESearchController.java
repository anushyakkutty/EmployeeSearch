package employee.search.esearch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import employee.search.esearch.domain.Node;
import employee.search.esearch.utils.ESearchService;

@RestController
public class ESearchController {

		@RequestMapping("/")
		public String index() {
			return "Greetings from Spring Boot!";
		}

		@GetMapping("/rootNode")
		@ResponseBody
		public Node getRootNode() {
			System.out.println("here");
			Node node =  ESearchService.getRootNode();
			System.out.println(node.getHeight());
			return node;
		}
		
		@PutMapping("/{child}")
		@ResponseBody
		public Node updateNode( @PathVariable(value = "child") String child, @RequestParam(value = "newParent") String parent) throws Exception {
			return ESearchService.updateParent(child, parent);
			
		}
		
		@GetMapping("/{child}")
		@ResponseBody
		public Node updateNode( @PathVariable(value = "child") String child) {
			return ESearchService.getNode(child);
			
		}
		
}
