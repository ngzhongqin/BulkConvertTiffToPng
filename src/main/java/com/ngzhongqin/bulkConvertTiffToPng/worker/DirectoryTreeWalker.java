package com.ngzhongqin.bulkConvertTiffToPng.worker;

import com.ngzhongqin.bulkConvertTiffToPng.Main;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class DirectoryTreeWalker {
    public final static Logger logger = Logger.getLogger(DirectoryTreeWalker.class);

    public DirectoryTreeWalker(){

    }
    public void walkAndConvert(){
        try (Stream<Path> paths = Files.walk(Paths.get(Main.fromFolder))) {
            paths.forEach(
                    new Consumer<Path>() {
                          @Override
                          public void accept(Path path) {
//                              logger.info("path:"+path);
//                              logger.info("path.getRoot():"+path.getRoot());
//                              logger.info("getRelativePath:"+getRelativePath(Main.fromFolder,path));
//                              logger.info("path.getFileName():"+path.getFileName());
                            convertAndStoreTif(path);


                          }
                      }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRelativePath(String folderPath, Path path){
        if(path==null){
            return "";
        }
        String rPath = path.toString();
        return rPath.replace(folderPath,"");
    }

    public static String getRelativePathWithoutFileName(Path path){
        if(path==null){
            return "";
        }
        String rPath=getRelativePath(Main.fromFolder,path);
        return rPath.replace(path.getFileName().toString(),"");
    }

    public void convertAndStoreTif(Path path){
        if(path.getFileName().toString().endsWith(".tif")){
            logger.info("path:"+path);
            logger.info("path.getRoot():"+path.getRoot());
            logger.info("getRelativePath:"+getRelativePath(Main.fromFolder,path));
            logger.info("path.getFileName():"+path.getFileName());
            String newFilePath = Main.toFolder+getRelativePathWithoutFileName(path)+path.getFileName().toString().replace(".tif",".png");
            logger.info("newFilePath:"+newFilePath);
            try {
                    new TiffToPngWorker().convert(path.toString(),newFilePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
