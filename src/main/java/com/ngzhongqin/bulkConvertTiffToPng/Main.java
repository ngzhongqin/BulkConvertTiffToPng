package com.ngzhongqin.bulkConvertTiffToPng;

import com.ngzhongqin.bulkConvertTiffToPng.worker.DirectoryTreeWalker;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class);
    public static String fromFolder="/Users/zhongqin/Downloads/FamilyPhotos1_of_2";
    public static String toFolder="/Users/zhongqin/target/FamilyPhotos1_of_2/";

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        logger.info("Started Main.main");
        DirectoryTreeWalker directoryTreeWalker = new DirectoryTreeWalker();
        directoryTreeWalker.walkAndConvert();

    }
}
