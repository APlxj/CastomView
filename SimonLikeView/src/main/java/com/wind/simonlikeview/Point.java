package com.wind.simonlikeview;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class Point {

    private Point(Bulder bulder) {
        this.x = bulder.x;
        this.y = bulder.y;
    }

    private float x;
    private float y;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    static class Bulder {
        private float x;
        private float y;

        Bulder X(float x) {
            this.x = x;
            return this;
        }

        Bulder Y(float y) {
            this.y = y;
            return this;
        }

        public Point bulder() {
            return new Point(this);
        }
    }
}
