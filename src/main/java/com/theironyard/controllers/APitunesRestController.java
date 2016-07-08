package com.theironyard.controllers;

import com.theironyard.services.LikeRepository;
import com.theironyard.services.SongRepository;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonathandavidblack on 7/8/16.
 */
@RestController
public class APitunesRestController {

    @Autowired
    UserRepository users;

    @Autowired
    SongRepository songs;

    @Autowired
    LikeRepository likes;

}