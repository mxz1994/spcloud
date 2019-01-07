package com.mxz.elsearch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxz.base.Message;
import com.mxz.elsearch.dao.PhoneDao;
import com.mxz.elsearch.model.PhoneVO;

/**
* <p>Title: PhoneController.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月21日  
*/
@RestController
public class PhoneController {

	@Value("${elUrl}")
	private String elUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PhoneDao dao;
	
	@PostMapping("/phone")
	public String savePhone(@RequestBody PhoneVO phone, HttpServletRequest request, String phones) {
		String re = request.getParameter("phones");
		String header = request.getHeader("phone");
		String url = elUrl + "/mxz/phone/"+phone.getId();
		String postForObject = restTemplate.postForObject(url, phone, String.class);
		ObjectMapper mapper = new ObjectMapper();
		return postForObject;
	}
	
	@GetMapping("/phone")
	public List<PhoneVO> findAll() throws Exception {
		String url = elUrl + "/mxz/phone/{id}";
		url = elUrl + "/mxz/phone/_search";
		//url = "http://www.baidu.com";
		Map<String, Object> paras = new HashMap<>();
		String str = restTemplate.getForObject(url, String.class, paras);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		JsonParser parser = factory.createParser(str);
		JsonNode root = mapper.readTree(parser);
		List<JsonNode> findValues = root.findValues("_source");
//		for (JsonNode jsonNode : findValues) {
//			String asText = jsonNode.asText();
//			PhoneVO convertValue = mapper.convertValue(jsonNode, PhoneVO.class);
//		}
		List<PhoneVO> phones = new ArrayList<PhoneVO>();
		findValues.parallelStream().forEach(node -> phones.add(mapper.convertValue(node, PhoneVO.class)));
		return phones;
	}
	
	@GetMapping("/phone/{id}")
	public PhoneVO get(@PathVariable String id) throws Exception {
		Optional<PhoneVO> phones = dao.findById(id);
		return phones.get();
	}
	
	@GetMapping("/phone/search")
	public List<PhoneVO> searchByName(String name) throws Exception {
		List<PhoneVO> phones = dao.getByName(name);
		return phones;
	}
	
	@DeleteMapping("/phone/{id}")
	public Message delete(@PathVariable String id) throws Exception {
		Optional<PhoneVO> od = dao.findById(id);
		dao.deleteById(id);
		//dao.deleteAll();
		return Message.OK(od);
	}
}
