package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.service.RequestService;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final RequestService requestService;

    @GetMapping("/request/fileR/{id}")
    public ResponseEntity<byte[]> downloadFileRequest(@PathVariable long id) {

        Request request = requestService.getById(id);
        String fileName = request.getEmail() + "Request";

        String strPath = request.getPathToFileOTO();
        if (strPath.endsWith(".pdf")) {
            fileName+=".pdf";
        } else if (strPath.endsWith(".doc")) {
            fileName+=".doc";
        } else if (strPath.endsWith(".docx")) {
            fileName+=".docx";
        }



       // System.out.println(strPath);



        Path path = Paths.get(strPath);

        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(fileName).build().toString());
        return ResponseEntity.ok().headers(httpHeaders).body(content);
    }
}
