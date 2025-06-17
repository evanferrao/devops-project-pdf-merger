package com.pdfmerger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MergeController {

    @Autowired
    private MergeService mergeService;

    @PostMapping("/merge")
    public ResponseEntity<FileSystemResource> merge(@RequestParam("files") MultipartFile[] files) {
        try {
            var merged = mergeService.mergeFiles(files);
            FileSystemResource resource = new FileSystemResource(merged);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.attachment().filename("merged.pdf").build());
            headers.setContentType(MediaType.APPLICATION_PDF);

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
