package com.badou.cloud.ums.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.badou.cloud.commons.ResultUtil;
import com.badou.cloud.ums.entity.Goods;
import com.badou.cloud.ums.entity.Order;
import com.badou.cloud.ums.entity.User;
import com.badou.cloud.ums.feign.OrderFeign;
import com.badou.cloud.ums.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderFeign orderServcie;
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") Integer userId) throws Exception {
		return userService.findUserById(userId);
	}

	@PostMapping
	public Map<String, Object> post(@RequestBody User user) {
		userService.createUser(user);
		return ResultUtil.OK;
	}

	@PutMapping
	public Map<String, Object> put(@RequestBody User user) {
		userService.updateUser(user);
		return ResultUtil.OK;
	}

	@GetMapping("/order")
	public List<Order> qryOrder(Integer userId, Integer state) {
		Order order = Order.builder().userId(userId).state(state).build();
		return orderServcie.findOrderByCondition(order);
//        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//        params.add("userId", userId);
//        params.add("state", state);
//        return orderServcie.findOrderByMap(params);
	}

	@PostMapping("/goods")
	public Map<String, Object> postGoods(@RequestPart("images") MultipartFile[] files, Goods goods) {
		return orderServcie.postGoods(files, goods.getName(), goods.getPrice());
	}
}
