package com.nuri.s4.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class fileSaver {

	public String save(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		// UUID method
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		file = new File(realPath, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}
}
