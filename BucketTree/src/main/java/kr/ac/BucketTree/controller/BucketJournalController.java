package kr.ac.BucketTree.controller;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.BucketTree.service.BucketJournalService;
import kr.ac.BucketTree.service.ImageService;
import kr.ac.BucketTree.service.Journal_ImageService;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class BucketJournalController {

	@Autowired
	BucketTreeCommon bucketTreeCommon;
	@Autowired
	BucketJournalService bjs;
	@Autowired
	Journal_ImageService jis;
	@Autowired
	ImageService is;
	@Autowired
	TimelineService ts;
	@Autowired
	UserService us;

	// 일지리스트 가져오기
	@RequestMapping(value = "/bucketList/journal")
	public void JorunalList(Model model, @RequestParam("bucket_idx") int bucket_idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		List<BucketJournalVO> bjl = new ArrayList();
		bjl = bjs.bucketJournalList(bucket_idx);
		model.addAttribute("list", bjl);

	}

	// 일지 추가 POST
	@ResponseBody
	@RequestMapping(value = "bucketList/journal/createAjax", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean JournalCreatePost(Model model, BucketJournalVO bjv) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		bjs.insertJournal(bjv);
		bjs.updateJournalImage(bjv);
		is.deleteOrphan();

		UserVO uv = us.getCurrentUser();
		ts.JournalInsert_Timeline(bjv, uv);

		return true;

	}

	// 일지 수정 GET
	@ResponseBody
	@RequestMapping(value = "bucketList/journal/modifyAjax", method = RequestMethod.GET)
	public BucketJournalVO JournalModifyGet(Model model, @RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		BucketJournalVO bjv = bjs.selectByIdx(idx);
		return bjv;
	}

	// 일지 수정 POST
	@ResponseBody
	@RequestMapping(value = "bucketList/journal/modifyAjax", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean JournalModifyPost(Model model, BucketJournalVO bjv) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		bjs.updateJournal(bjv);
		bjs.updateJournalImage(bjv);
		is.deleteOrphan();

		return true;
	}

	// 일지 삭제 GET
	@ResponseBody
	@RequestMapping(value = "bucketList/journal/deleteAjax", method = RequestMethod.GET)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean JournalDeleteGet(Model model, @RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		jis.deleteByJournal_idx(idx);
		bjs.deleteJournal(idx);
		is.deleteOrphan();

		return true;
	}

	// -- 스마트에디터 사진 저장

	@RequestMapping("/bucket/{idx}/image")
	public void image(@PathVariable("idx") int idx, HttpServletResponse response) throws Exception {

		ImageVO image = is.selectByIdx(idx);
		if (image == null)
			return;
		String fileName = URLEncoder.encode(image.getFileName(), "UTF-8");
		response.setContentType(image.getMimeType());
		response.setHeader("Content-Disposition", "filename=" + fileName + ";");
		try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
			output.write(image.getData());
		}
	}

	@RequestMapping(value = "/bucket/smartEditorUpload", method = RequestMethod.POST)
	public String photoUpload(@RequestParam("callback") String callback,
			@RequestParam("callback_func") String callback_func, @RequestParam("Filedata") MultipartFile uploadedFile)
			throws Exception {
		String r;
		String fname = Paths.get(uploadedFile.getOriginalFilename()).getFileName().toString();
		if (uploadedFile.getSize() > 0) {
			ImageVO image = new ImageVO();
			image.setFileName(fname);
			image.setFileSize((int) uploadedFile.getSize());
			image.setData(uploadedFile.getBytes());
			is.insertImage(image);
			r = "&bNewLine=true&sFileName=" + fname + "&sFileURL=/BucketTree/bucket/" + image.getIdx() + "/image";
		} else
			r = "&errstr=" + fname;
		String url = callback + "?callback_func=" + callback_func + r;
		return "redirect:" + url;
	}

	@RequestMapping(value = "/bucket/smartEditorUpload5", method = RequestMethod.POST)
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName = request.getHeader("file-name");

			int fileSize = Integer.parseInt(request.getHeader("file-size"));
			InputStream input = request.getInputStream();
			int count = 0;
			byte[] data = new byte[fileSize];
			while (count < fileSize)
				count += input.read(data, count, data.length - count);
			ImageVO image = new ImageVO();
			image.setFileName(fileName);
			image.setFileSize(fileSize);
			image.setData(data);
			is.insertImage(image);
			String s = "&bNewLine=true&sFileName=" + fileName;
			s += "&sFileURL=/BucketTree/bucket/" + image.getIdx() + "/image";
			PrintWriter out = response.getWriter();
			out.print(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// -- 스마트에디터 사진 저장

}
