//package com.ice.jyzq.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//import java.util.UUID;
//
//import javax.imageio.ImageIO;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.alibaba.fastjson.JSON;
//import com.ice.jyzq.constant.FailResponse;
//import com.ice.jyzq.constant.QiongConst;
//import com.ice.jyzq.controller.app.Response;
//import com.ice.jyzq.service.QiongService;
//import com.ice.jyzq.util.JsonMapper;
//import com.ice.server.bean.QiongUpload;
//
//@Controller
//@RequestMapping(value = "qiong")
//public class QiongController {
//
//	private static final String FILE_CACHE = "C:/file";
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Autowired
//	private QiongService qiongService;
//
//	@RequestMapping(value = "upload", method = RequestMethod.GET)
//	public String toUpload() {
//		return "qiong/upload";
//	}
//
//	@RequestMapping(value = "list", method = RequestMethod.GET)
//	public String toList() {
//		return "qiong/list";
//	}
//
//	@RequestMapping(value = "upload", method = RequestMethod.POST)
//	@ResponseBody
//	public String upload(@RequestParam("title") String title, @RequestParam("cityId") Integer cityId,
//			@RequestParam(value = "descMe", required = false) String descMe) {
//		if (title.length() > 49 || descMe.length() > 199) {
//			return JSON.toJSONString(Response.failResponse(FailResponse.QiongTooLong));
//		}
//
//		QiongUpload qiongUpload = new QiongUpload();
//		qiongUpload.setCityId(cityId);
//		qiongUpload.setCreateTime(new Date());
//		qiongUpload.setDesc(descMe);
//		qiongUpload.setStatus(QiongConst.QIONG_NEW_UPLOAD);
//		qiongUpload.setTitle(title);
//		qiongService.save(qiongUpload);
//
//		return JSON.toJSONString(Response.successResponse(""));
//	}
//
//	@RequestMapping(value = "upload11111", method = RequestMethod.POST)
//	// TODO
//	@ResponseBody
//	public String uploadWithFile(@RequestParam("title") String title, @RequestParam("cityId") Integer cityId,
//			@RequestParam(value = "file", required = false) MultipartFile file,
//			@RequestParam(value = "descMe", required = false) String descMe) {
//		if (title.length() > 49 || descMe.length() > 199) {
//			return JSON.toJSONString(Response.failResponse(FailResponse.QiongTooLong));
//		}
//		String newName = "";
//		if (file != null) {
//			newName = saveFile(file);
//		}
//
//		QiongUpload qiongUpload = new QiongUpload();
//		qiongUpload.setCityId(cityId);
//		qiongUpload.setCreateTime(new Date());
//		qiongUpload.setDesc(descMe);
//		qiongUpload.setFilepath(newName);
//		if (file != null) {
//			qiongUpload.setImgName(file.getOriginalFilename());
//		}
//		qiongUpload.setStatus(QiongConst.QIONG_NEW_UPLOAD);
//		qiongUpload.setTitle(title);
//		qiongService.save(qiongUpload);
//
//		return JSON.toJSONString(Response.successResponse(""));
//	}
//
//	private String saveFile(MultipartFile file) {
//		String fileType = file.getOriginalFilename().split("\\.")[1];
//		String newName = UUID.randomUUID().toString() + "." + fileType;
//		if (!new File(FILE_CACHE).exists()) {
//			new File(FILE_CACHE).mkdir();
//		}
//		File targetFile = new File(FILE_CACHE, newName);
//		try {
//			file.transferTo(targetFile);
//		} catch (IllegalStateException e) {
//			logger.error("upload: ", e);
//		} catch (IOException e) {
//			logger.error("upload: ", e);
//		}
//		logger.info("上传照片类型:" + getFormatName(targetFile) + ",原名称:" + file.getOriginalFilename() + ";保存名:" + newName);
//		return FILE_CACHE + newName;
//	}
//
//	private static String getFormatName(Object o) {
//		try {
//			// Create an image input stream on the image
//			ImageInputStream iis = ImageIO.createImageInputStream(o);
//			// Find all image readers that recognize the image format
//			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
//			if (!iter.hasNext()) {
//				// No readers found
//				return null;
//			}
//			// Use the first reader
//			ImageReader reader = iter.next();
//			// Close stream
//			iis.close();
//			// Return the format name
//			return reader.getFormatName();
//		} catch (IOException e) {
//			//
//		}
//		// The image could not be read
//		return null;
//	}
//
//	@RequestMapping(value = "qiongren/get", method = { RequestMethod.GET, RequestMethod.POST })
//	@ResponseBody
//	public String getSome(@RequestParam(value = "pageNo", required = true) int pageNo) {
//		List<QiongUpload> choises = qiongService.findLatestQiongRen(pageNo);
//		return JsonMapper.toJsonString(choises);
//	}
//}
