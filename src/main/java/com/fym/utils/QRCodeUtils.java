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
 * �����ͽ�����ά��
 * 
 * @author Groot
 *
 */
	public class QRCodeUtils {

 
		/**
		 * 
		 * @param QRData ��ά�뱣�������
		 * @param path ��ά�뱣��·��
		 * @param size �������ö�ά��ߴ磬ȡֵ��Χ1-40��ֵԽ��ߴ�Խ�󣬿ɴ洢����ϢԽ��
		 * @return��������Ϣ��BufferedImage
		 */
		public static BufferedImage Creat(String QRData, String path, int size) {
			BufferedImage bufImg = null;
			try {
				Qrcode qrcodeHandler = new Qrcode();
				qrcodeHandler.setQrcodeErrorCorrect('M');
				qrcodeHandler.setQrcodeEncodeMode('B');
				qrcodeHandler.setQrcodeVersion(size);
				// ������ݵ��ֽ����飬���ñ����ʽ
				byte[] contentBytes = QRData.getBytes("utf-8");
				// ͼƬ�ߴ�
				int imgSize = 67 + 12 * (size - 1);
				bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
				Graphics2D gs = bufImg.createGraphics();
				// ���ñ�����ɫ
				gs.setBackground(Color.WHITE);
				gs.clearRect(0, 0, imgSize, imgSize);
				// �趨ͼ����ɫ> BLACK
				gs.setColor(Color.BLACK);
				// ����ƫ�����������ÿ��ܵ��½�������
				int pixoff = 2;
				// ��������> ��ά��
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
		 * @param path �� ��ά��·��
		 * @return:��ά�뱣�������
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
