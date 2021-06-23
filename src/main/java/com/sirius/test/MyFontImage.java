package com.sirius.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * className:MyFontImage
 * Description:图片弱化
 *
 * @author:yanminghao
 */

public class MyFontImage {
    /**
     * 取想要转换的图片
     *
     * @param write
     * @param pathFile
     * @return void
     */
    //再读取想要转换的图片
    public static void createFongImg(String write,String pathFile){

        String base = write;
        try{
            //使用 ImageIO 中提供的静态方法 read()，传入一个文件，read() 方法回返回一个 BufferedImage 类型的图片缓存流。我们通过new File(path)，来创建一个文件流。
            /**
             *   注意 图片不能使用的ps过的图片存在异常
             *   javax.imageio.IIOException: Unsupported Image Type
             *   at com.sun.imageio.plugins.jpeg.JPEGImageReader.readInternal(JPEGImageReader.java:1068)
             *   at com.sun.imageio.plugins.jpeg.JPEGImageReader.read(JPEGImageReader.java:1039)
             *   at javax.imageio.ImageIO.read(ImageIO.java:1448)
             *   at javax.imageio.ImageIO.read(ImageIO.java:1308)
             */
            BufferedImage image = ImageIO.read(new File(pathFile));
            //1.再创建一个 BufferedImage 用于放置我们输出文字的图片。参数呢就是图片的宽度，图片的高度，和图片的类型。
            BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
            //2.创建一个2D坐标转换及绘图相关的类 Graphics2D，用来设置每个像素点的颜色、字体大小和字体样式。
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            //3.设置字体风格、样式和大小
            graphics2D.setFont(new Font("宋体",Font.BOLD,12));
            int index = 0;
            //4.下面就是写一个for循环，循环遍历每一个像素点，将每隔12个像素点就替换为文字。
            for(int y = 0; y < image.getHeight(); y += 12){
                for (int x = 0; x < image.getWidth(); x += 12){
                    //5.循环每一个像素点

                    //6.获取图片当前位置像素的颜色
                    int pxcolor = image.getRGB(x,y);
                    //7.分离出rgb三种颜色，分别进行灰度和二值化处理
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    //8.通过graphics2d设置字体颜色
                    graphics2D.setColor(new Color(r, g, b));
                    //9.在当前位置上绘上一个文字
                    graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), x, y);
                    //10.当前文字被绘上以后绘制下一个文字
                    index++;
                }
            }
            //11.通过 ImageIO 方法，把图片重新绘制，并输出
            ImageIO.write(newImage, "PNG", new FileOutputStream(pathFile));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        MyFontImage.createFongImg("平安夜快乐","\\Users\\ymh_sirius\\Desktop\\apple.png");
        System.out.println("OK");
    }

}
