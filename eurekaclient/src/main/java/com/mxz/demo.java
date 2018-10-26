package com.mxz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mxz.eurekac.user.model.User;

public class demo {
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		for (int i =0; i <5; i++) {
			User u = new User();
			u.setName("a");
			u.setPassword("11"+i);
			if (i%2 == 0) {
				u.setName("a"+1);
			}
			users.add(u);
		}
		
		Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getName));
		System.out.println(collect.size());
		for (String name : collect.keySet()) {
			System.out.println(name);
			for (User user : collect.get(name)) {
				System.out.println(user.toString());
			}
		}
		System.out.println(users);
	}
}
