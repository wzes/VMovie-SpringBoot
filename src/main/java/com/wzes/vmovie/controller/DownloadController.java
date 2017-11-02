package com.wzes.vmovie.controller;

import com.wzes.vmovie.model.MovieCollection;
import com.wzes.vmovie.model.MovieLink;
import com.wzes.vmovie.service.DownloadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 11/2/17
 */
@RestController
@RequestMapping({"/vmovie"})
public class DownloadController {

    private static Logger log = LogManager.getLogger(MovieController.class); //日志输出

    @Autowired
    DownloadService downloadService;

    @GetMapping(value = "/search/{moviename}", produces = { "application/json;charset=UTF-8" })
    private List<MovieLink> getDownloadLinks(@PathVariable String moviename) throws IOException {
        return downloadService.findLink(moviename);
    }
}
