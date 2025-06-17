package com.pdfmerger;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Service
public class MergeService {

    public File mergeFiles(MultipartFile[] files) throws Exception {
        PDFMergerUtility merger = new PDFMergerUtility();
        File merged = File.createTempFile("merged-", ".pdf");

        for (MultipartFile file : files) {
            InputStream stream = file.getInputStream();
            merger.addSource(stream);
        }

        FileOutputStream out = new FileOutputStream(merged);
        merger.setDestinationStream(out);
        merger.mergeDocuments(null);

        return merged;
    }
}
