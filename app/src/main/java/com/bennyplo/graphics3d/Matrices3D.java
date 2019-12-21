package com.bennyplo.graphics3d;

//return the matrices for diferents
//transformations
public class Matrices3D {

    public float[][] getScale3DMAtrix(float tx, float ty, float tz) {
        float[][] scaleMatrix = {
                {1, 0, 0, tx}, {0, 1, 0, ty}, {0, 0, 1, tz}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public float[][] getRotate3DMAtrix(float tx, float ty, float tz) {
        float[][] scaleMatrix = {
                {1, 0, 0, tx}, {0, 1, 0, ty}, {0, 0, 1, tz}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }
}
