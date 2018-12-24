package com.ngzhongqin.bulkConvertTiffToPng;

import com.ngzhongqin.bulkConvertTiffToPng.worker.TiffToPngWorker;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        logger.info("Started Main.main");
        new TiffToPngWorker().convert();
    }
}