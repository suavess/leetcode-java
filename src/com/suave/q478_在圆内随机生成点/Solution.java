package com.suave.q478_在圆内随机生成点;

import java.util.Arrays;
import java.util.Random;

/**
 * @author shunxin.jin
 * @date 2022/6/5 12:37
 */
public class Solution {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random = new Random();

    public Solution(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public double[] randPoint() {
        double x;
        double y;
        while (true) {
            // x轴范围为[xCenter-radius, xCenter+radius]
            // xCenter 4 radius 2 x范围为[2, 6] 只需要查找-radius~radius的随机数再加上xCenter即可
            // y轴范围为[yCenter-radius, yCenter+radius]
            // yCenter 6 radius 2 x范围为[4, 8] 只需要查找-radius~radius的随机数再加上yCenter即可
            x = random.nextDouble() * 2 * radius - radius;
            y = random.nextDouble() * 2 * radius - radius;
            // 判断是否在圆内,勾股定理
            if (x * x + y * y <= radius * radius) {
                return new double[]{x + xCenter, y + yCenter};
            }
        }
    }
}
