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
import java.util.Arrays;

import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.service.RequestService;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final RequestService requestService;

    @GetMapping("/request/fileR/{id}")
    public ResponseEntity<byte[]> downloadFileRequest(@PathVariable long id) {

        Request request = requestService.getById(id);

        String[] str = request.getPathToFileRequest().split("\\\\");

        String fileName = str[str.length-1];

        String strPath = request.getPathToFileOTO();

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

    @GetMapping("/request/fileO/{id}")
    public ResponseEntity<byte[]> downloadFileOTO(@PathVariable long id) {

        Request request = requestService.getById(id);

        String[] str = request.getPathToFileOTO().split("\\\\");

        String fileName = str[str.length-1];

        String strPath = request.getPathToFileOTO();

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
