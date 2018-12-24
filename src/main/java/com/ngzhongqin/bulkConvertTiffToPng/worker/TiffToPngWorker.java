package com.ngzhongqin.bulkConvertTiffToPng.worker;

import com.ngzhongqin.bulkConvertTiffToPng.Main;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TiffToPngWorker {
    public final static Logger logger = Logger.getLogger(Main.class);

    public TiffToPngWorker(){
        logger.info("Created "+this.getClass().getName()+" started");
    }

    public void convert(String fromFullPath, String toFullPath) throws IOException {
        convertTiffToPng(fromFullPath,toFullPath);
    }

    public void convertTiffToPng(String fromFullPath, String toFullPath) throws IOException {
        final BufferedImage tif = ImageIO.read(new File(fromFullPath));
        ImageIO.write(tif, "png", new File(toFullPath));
    }
}
