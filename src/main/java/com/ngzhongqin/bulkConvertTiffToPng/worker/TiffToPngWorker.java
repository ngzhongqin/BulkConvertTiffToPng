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

    public void convert() throws IOException {
        convertTiffToPng();
    }

    public void convertTiffToPng() throws IOException {
        final BufferedImage tif = ImageIO.read(new File("sample.tif"));
        ImageIO.write(tif, "png", new File("sample.png"));
    }
}
