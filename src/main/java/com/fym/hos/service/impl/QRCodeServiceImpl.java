package com.fym.hos.service.impl;

import java.awt.image.BufferedImage;

import com.hospital.app.QRCode.QRCodeUtils.QRCodeUtils;
import com.hospital.app.QRCode.service.QRCodeService;

public class QRCodeServiceImpl implements QRCodeService {
	QRCodeUtils qrCodeUtils;
	@Override
	public BufferedImage Creat(String QRData, String path, int size) {
		return qrCodeUtils.Creat(QRData, path, size);
	}

	@Override
	public String readQRCode(String path) {
		return qrCodeUtils.readQRCode(path);
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("555555555555");
	}

}
