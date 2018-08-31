package com.fym.hos.service;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    public BufferedImage Creat(String QRData, String path, int size);
    public String readQRCode(String path);
    public void test();
}
