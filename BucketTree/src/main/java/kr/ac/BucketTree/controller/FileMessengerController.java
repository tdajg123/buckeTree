package kr.ac.BucketTree.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.BucketTree.service.FileMessengerService;
import kr.ac.BucketTree.vo.FileMessengerVO;

@Controller
public class FileMessengerController {
	@Autowired
	FileMessengerService fms;

	@RequestMapping("/messenger/download")
	public void download(@RequestParam("idx") int idx, HttpServletResponse response) throws IOException {
		FileMessengerVO file = fms.selectByMessenger(idx);
		if (file == null)
			return;
		String fileName = URLEncoder.encode(file.getFileName(), "UTF-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
			output.write(file.getData());
		}
	}

}
