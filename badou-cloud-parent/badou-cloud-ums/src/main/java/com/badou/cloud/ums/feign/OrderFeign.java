package com.badou.cloud.ums.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.badou.cloud.ums.entity.Order;

@FeignClient(name = "badou-cloud-order")
public interface OrderFeign {

	// 接口方必须要使用@RequestBody注解来接收数据
	@RequestMapping(value = "/order/qry", method = RequestMethod.POST)
	public List<Order> findOrderByCondition(Order order);

//    @RequestMapping(value = "/order/qry", method = RequestMethod.POST)
//    public List<Order> findOrderByMap(MultiValueMap<String, Object> params);

	@PostMapping(value = "/goods", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> postGoods(@RequestPart("images") MultipartFile[] images, @RequestParam String name,
			@RequestParam Integer price);
}
