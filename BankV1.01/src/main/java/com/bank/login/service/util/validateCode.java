package com.bank.login.service.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码生成器
 *
 * @author 
 */
public class validateCode {
	// 图片的宽度。
	private int width = 160;
	// 图片的高度。
	private int height = 40;
	// 验证码字符个数
	private int codeCount = 5;
	// 验证码干扰线数
	private int lineCount1 = 250;
	// 验证码
	private String code = null;
	// 验证码图片Buffer
	private BufferedImage buffImg = null;
	// 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)
	private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	/**
	 * 默认构造函数,设置默认参数
	 */

	public validateCode() {
		this.createCode();
	}

	/**
	 * @param width 图片宽
	 * @param height 图片高
	 * @param codeCount 字符个数
	 * @param lineCount 干扰线条数
	 */

	public validateCode(int width, int height, int codeCount, int lineCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount1 = lineCount;
		this.createCode();
	}

	public void createCode() {
		// 生成随机数
		Random random = new Random();
		int x = 0, fontHeight = 0, codeY = 0;
		x = 20+random.nextInt(10);//每个字符的宽度(左右各空出一个字符)
		fontHeight = 31+random.nextInt(5);//字号
		codeY = height - 4;//

		// 图像buffer
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//
		Graphics2D g = buffImg.createGraphics();//

		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体,可以修改为其它的
		Font font = new Font("宋体", Font.BOLD, fontHeight);//字体,风格(加粗),字号
		g.setFont(font);//在图像里的字体的格式设置
		lineCount1 = 200;
		System.out.println(lineCount1);
		for (int i = 0; i < lineCount1; i++) {
			// 设置随机开始和结束坐标
			int xs = random.nextInt(width);//x坐标开始
			int ys = random.nextInt(height);//y坐标开始
			int xe = xs + random.nextInt(width / 8);//x坐标结束
			int ye = ys + random.nextInt(height / 8);//y坐标结束
			g.setColor(new Color(0, 0, 0));
			g.drawLine(xs, ys, xe, ye);
			//System.out.println("--");
		}
		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码。
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			g.setColor(new Color(0, 0, 0));
			g.drawString(strRand, (i + 1) * x, codeY);//在图像里写字drawString(要写的字,字的基线x坐标,字的基线y坐标)
			randomCode.append(strRand);// 将产生的四个随机数组合在一起。
		}
		code = randomCode.toString();// 将四位数字的验证码保存到Session中。
	}
	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}
	public void write(OutputStream sos) throws IOException {
		ImageIO.write(buffImg, "png", sos);
		sos.close();
	}
	public BufferedImage getBuffImg() {
		return buffImg;
	}
	public String getCode() {
		return code;
	}
	/**
	 * 测试函数,默认生成到d盘
	 * @param args
	 */

	public static void main(String[] args) {
		validateCode vCode = new validateCode(160,40,5,250);//提供数据
		try {
			String path="images/captcha.jpg";//新建一个png图片
			System.out.println(vCode.getCode()+" >"+path);
			vCode.write(path);//输出图像到png图片
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



