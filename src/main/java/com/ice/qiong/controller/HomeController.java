package com.ice.qiong.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.ice.auth.UserInfo;
import com.ice.jyzq.controller.app.Response;
import com.ice.jyzq.util.JsonMapper;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	private static final String FILE_CACHE = "C:/file";

	@RequestMapping(value = { "/hello" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String home(HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}

	@RequestMapping(value = { "/ip" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getIp(HttpServletRequest request) {
		return JsonMapper.toJsonString(UserInfo.getIp());
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadWithFile(@RequestParam(value = "fileToUpload", required = false) MultipartFile file) {
		if (file != null) {
			saveFile(file);
		}

		return JSON.toJSONString(Response.successResponse("上传成功"));
	}

	private String saveFile(MultipartFile file) {
		String fileType = file.getOriginalFilename().split("\\.")[1];
		String newName = UUID.randomUUID().toString() + "." + fileType;
		if (!new File(FILE_CACHE).exists()) {
			new File(FILE_CACHE).mkdir();
		}
		File targetFile = new File(FILE_CACHE, newName);
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			logger.error("upload: ", e);
		} catch (IOException e) {
			logger.error("upload: ", e);
		}
		logger.info("上传照片类型:" + getFormatName(targetFile) + ",原名称:" + file.getOriginalFilename() + ";保存名:" + newName);
		return FILE_CACHE + newName;
	}

	private static String getFormatName(Object o) {
		try {
			// Create an image input stream on the image
			ImageInputStream iis = ImageIO.createImageInputStream(o);
			// Find all image readers that recognize the image format
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				// No readers found
				return null;
			}
			// Use the first reader
			ImageReader reader = iter.next();
			// Close stream
			iis.close();
			// Return the format name
			return reader.getFormatName();
		} catch (IOException e) {
			//
		}
		// The image could not be read
		return null;
	}

}
