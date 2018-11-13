package com.javarush.task.task31.task3110.command;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 05.05.2017.
 */
public class FileManager {
    private Path rootPath;
     private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException{
        this.rootPath = rootPath;
        this.fileList=new ArrayList<>();
    }

    public List<Path> getFileList() {
        return fileList;
    }
    public void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            Path path1 = path.relativize(rootPath);
            fileList.add(path1);
        }
        if (Files.isDirectory(path)){
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for (Path p: directoryStream)
                collectFileList(p);
        }

    }
}
