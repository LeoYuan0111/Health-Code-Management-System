package com.example.healthcodebe.utils;
import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Objects;

public class QRCodeUtil {

    private static final String CHARSET = "utf-8";

    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;

    public static BufferedImage createImage(String content, String color) {
//        color : 0 - Red / 1 - Green / 2 - Yellow
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
                    hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if(Objects.equals(color, "Red")) { // Red
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFFFF0000 : 0xFFFFFFFF);
                } else if (Objects.equals(color, "Green")) {  // Green
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF00FF00 : 0xFFFFFFFF);
                } else if (Objects.equals(color, "Yellow")) {  // Yellow
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFFFFFF00 : 0xFFFFFFFF);
                } else {
                    // Black
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }

            }
        }
        return image;
    }
}