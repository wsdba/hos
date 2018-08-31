package com.fym.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;
/**
 * 创建和解析二维码
 * 
 * @author Groot
 *
 */
	public class QRCodeUtils {

		/**
		 * 
		 * @param QRData 二维码保存的内容
		 * @param path 二维码保持路径
		 * @param size 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
		 * @return：带有信息的BufferedImage
		 */
		public static BufferedImage Creat(String QRData, String path, int size) {
			BufferedImage bufImg = null;
			try {
				Qrcode qrcodeHandler = new Qrcode();
				qrcodeHandler.setQrcodeErrorCorrect('M');
				qrcodeHandler.setQrcodeEncodeMode('B');
				qrcodeHandler.setQrcodeVersion(size);
				// 获得内容的字节数组，设置编码格式
				byte[] contentBytes = QRData.getBytes("utf-8");
				// 图片尺寸
				int imgSize = 67 + 12 * (size - 1);
				bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
				Graphics2D gs = bufImg.createGraphics();
				// 设置背景颜色
				gs.setBackground(Color.WHITE);
				gs.clearRect(0, 0, imgSize, imgSize);
				// 设定图像颜色> BLACK
				gs.setColor(Color.BLACK);
				// 设置偏移量，不设置可能导致解析出错
				int pixoff = 2;
				// 输入内容> 二维码
				if (contentBytes.length > 0 && contentBytes.length < 800) {
					boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
					for (int i = 0; i < codeOut.length; i++) {
						for (int j = 0; j < codeOut.length; j++) {
							if (codeOut[j][i]) {
								gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
							}
						}
					}
				} else {
					throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
				}
				gs.dispose();
				bufImg.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bufImg;
		}

		/**
		 * 
		 * 
		 * @param path ： 二维码路径
		 * @return:二维码保存的内容
		 */
		public String readQRCode(String path) {
			BufferedImage bufferedImage;
			String result =null;
			try {
				bufferedImage = ImageIO.read(new File(path));
				QRCodeDecoder qrCodeDecoder = new QRCodeDecoder();
				result= new String(qrCodeDecoder.decode(new MyQRCodeImage(bufferedImage)), "utf-8");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		
	}
