package com.fym.hos.service.impl;

import java.awt.image.BufferedImage;

import com.fym.hos.service.QRCodeService;
import com.fym.utils.QRCodeUtils;


public class QRCodeServiceImpl implements QRCodeService {
	QRCodeUtils qrCodeUtils;
	public BufferedImage Creat(String QRData, String path, int size) {
		return qrCodeUtils.Creat(QRData, path, size);
	}

	public String readQRCode(String path) {
		return qrCodeUtils.readQRCode(path);
	}

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("555555555555");
	}

}
