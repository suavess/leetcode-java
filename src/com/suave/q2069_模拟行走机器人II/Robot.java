package com.suave.q2069_模拟行走机器人II;
//给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1,
//height - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方
//向为 "East" 。
//
// 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。
//
//
// 沿着当前方向尝试 往前一步 。
// 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。
//
//
// 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。
//
// 请你实现 Robot 类：
//
//
// Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝
//"East" 。
// void move(int num) 给机器人下达前进 num 步的指令。
// int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
// String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。
//
//
//
//
// 示例 1：
//
//
//
// 输入：
//["Robot", "move", "move", "getPos", "getDir", "move", "move", "move",
//"getPos", "getDir"]
//[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
//输出：
//[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
//
//解释：
//Robot robot = new Robot(6, 3); // 初始化网格图，机器人在 (0, 0) ，朝东。
//robot.move(2);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
//robot.move(2);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
//robot.getPos(); // 返回 [4, 0]
//robot.getDir(); // 返回 "East"
//robot.move(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
//                // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
//                // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
//robot.move(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
//robot.move(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
//                // 然后，移动 4 步到 (1, 2) ，并朝西。
//robot.getPos(); // 返回 [1, 2]
//robot.getDir(); // 返回 "West"
//
//
//
//
//
// 提示：
//
//
// 2 <= width, height <= 100
// 1 <= num <= 10⁵
// move ，getPos 和 getDir 总共 调用次数不超过 10⁴ 次。
//
//
// Related Topics 设计 模拟 👍 18 👎 0

/**
 * @author suave
 * @date 2022-07-24 19:10
 */
public class Robot {
    /**
     * 网格宽度
     */
    private final int width;
    /**
     * 网格高度
     */
    private final int height;
    /**
     * 所处x轴位置
     */
    private int x;
    /**
     * 所处y轴位置
     */
    private int y;
    /**
     *
     */
    private String dir = "East";

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
    }

    public void step(int num) {
        int step = num % (2 * this.width + 2 * this.height - 4);
        if (step == 0 && x == 0 && y == 0) {
            // 刚好回到起点,此时应面朝南面
            dir = "South";
        }
        for (int i = 0; i < step; i++) {
            switch (getDir()) {
                case "East":
                    // 面朝东面,增加x值
                    if (x + 1 == this.width) {
                        // 已经达到网格的最东边,则需要变换方向,且y增加1
                        y++;
                        dir = "North";
                    } else {
                        // 否则就x++
                        x++;
                    }
                    break;
                case "North":
                    // 面朝北面,增加y值
                    if (y + 1 == this.height) {
                        // 已经达到网格的最北边,则需要变换方向,且x减少1
                        x--;
                        dir = "West";
                    } else {
                        // 否则就y++
                        y++;
                    }
                    break;
                case "West":
                    // 面朝西面,减少x值
                    if (x == 0) {
                        // 已经达到网格的最西边,则需要变换方向,且y减少1
                        y--;
                        dir = "South";
                    } else {
                        // 否则就x--
                        x--;
                    }
                    break;
                case "South":
                    // 面朝南面,减少y值
                    if (y == 0) {
                        // 已经达到网格的最南边,则需要变换方向,且x增加1
                        x++;
                        dir = "East";
                    } else {
                        // 否则就y--
                        y--;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dir;
    }

    public static void main(String[] args) {
        Robot robot = new Robot(2, 2);
        robot.step(4);
        System.out.println(robot.getDir());
    }
}
