package com.badou.cloud.order.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.badou.cloud.commons.ResultUtil;
import com.badou.cloud.order.entity.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/{id}")
	public Goods get(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
		response.setHeader("B-C-H", request.getHeader("B-C-H"));
		return Goods.builder().id(id).name("Apple").price(port).build();
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> post(@RequestParam("images") MultipartFile[] images, String name, Integer price) {
		if (images != null && images.length > 0) {
			for (MultipartFile file : images) {
				if (!file.isEmpty()) {
					// 获取文件存储路径（绝对路径）
					String path = "D:\\test";
					// 获取原文件名
					String fileName = file.getOriginalFilename();
					// 创建文件实例
					File filePath = new File(path, fileName);
					// 如果文件目录不存在，创建目录
					if (!filePath.getParentFile().exists()) {
						filePath.getParentFile().mkdirs();
						System.out.println("创建目录" + filePath);
					}
					// 写入文件
					try {
						file.transferTo(filePath);
					} catch (Exception e) {
						return ResultUtil.NOT_OK;
					}
				}
			}
		}
		return ResultUtil.OK;
	}

}
