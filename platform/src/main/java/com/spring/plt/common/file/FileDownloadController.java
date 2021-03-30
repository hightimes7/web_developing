package com.spring.plt.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	private static final String IMAGE_PATH = "C:/workspace/platform/src/main/webapp/resources/pltImage"; //�п�
//	private static final String IMAGE_PATH = "C:/JSP/projects/platform/src/main/webapp/resources/pltImage"; //��
	@RequestMapping("/download.do")
	protected void download(@RequestParam("imageFileName") String imageFileName,
							@RequestParam("id") String id,
							HttpServletResponse response) throws Exception{
		
		OutputStream out = response.getOutputStream();
		
		String downFile = IMAGE_PATH + "\\" + id + "\\" + imageFileName;
		
		File file = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*4];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}
