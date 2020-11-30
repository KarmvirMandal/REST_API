package com.api.boot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.boot.rest.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());

		try {
			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty");
			}

//			if (!file.getContentType().equals("/image.png")) {
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Allow png-file");
//
//			}

			// file upload code

			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {

				// return ResponseEntity.ok("File Upload sucess...!!");

				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image")
						.path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went worng.. Try Again");
	}

}
