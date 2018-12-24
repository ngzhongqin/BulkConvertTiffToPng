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
    public void walkAndConvert(String folderPath){
        try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
            paths.forEach(
                    new Consumer<Path>() {
                          @Override
                          public void accept(Path path) {
                            logger.info(path);
                              try {
                                  new TiffToPngWorker().convert("sample.tif","sample.png");
                              } catch (IOException e) {
                                  e.printStackTrace();
                              }
                          }
                      }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
