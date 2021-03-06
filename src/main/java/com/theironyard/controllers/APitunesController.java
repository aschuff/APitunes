package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.services.LikeRepository;
import com.theironyard.services.SongRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by jonathandavidblack on 7/8/16.
 */
@Controller
public class APitunesController {

    @Autowired
    UserRepository users;

    @Autowired
    SongRepository songs;

    @Autowired
    LikeRepository likes;


    @PostConstruct
    public void init() throws SQLException, FileNotFoundException, PasswordStorage.CannotPerformOperationException {
        Server.createWebServer().start();
        parseUsers("users.csv");

    }
    public void parseUsers(String fileName) throws FileNotFoundException, PasswordStorage.CannotPerformOperationException {
        if (users.count() == 0) {
            File usersFile = new File(fileName);
            Scanner fileScanner = new Scanner(usersFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] columns = fileScanner.nextLine().split(",");
                User user = new User(columns[0], PasswordStorage.createHash(columns[1]), Boolean.valueOf(columns[2]), Boolean.valueOf(columns[3]), Boolean.valueOf(columns[4]));
                users.save(user);
            }
        }
    }
}
