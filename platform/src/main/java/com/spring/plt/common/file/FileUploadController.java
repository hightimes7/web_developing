package com.spring.plt.common.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

@Controller
public class FileUploadController {
	private static final String IMAGE_PATH = "C:/workspace/platform/src/main/webapp/resources/pltImage"; //�п�
//	private static final String IMAGE_PATH = "C:/JSP/projects/platform/src/main/webapp/resources/pltImage"; //��
	
	@RequestMapping(value="/imageUpload.do", method=RequestMethod.POST)
	public void imageUpload(@RequestParam MultipartFile upload,
							@RequestParam("id") String id,
			MultipartHttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile) throws Exception{
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter writer = null;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String path = IMAGE_PATH + "/" + id+"/";
			String ckUploadPath = path + uid + "_" + fileName;
			String name = uid + "_" + fileName;
			File folder = new File(path);
			
			if(!folder.exists()) {
				try {
					folder.mkdirs();
				}catch(Exception e) {
					e.getStackTrace();
				}
			}
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			
			writer = response.getWriter();
			String fileUrl = request.getContextPath()+"/download.do?id="+id+"&imageFileName="+name;
			
			JsonObject json = new JsonObject();
			json.addProperty("uploaded", 1);
			json.addProperty("fileName", fileName);
			json.addProperty("url", fileUrl);
			writer.println(json);
			writer.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) out.close();
				if(writer != null) writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}
}
