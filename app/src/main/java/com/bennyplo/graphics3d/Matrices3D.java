package com.bennyplo.graphics3d;

//return the matrices for diferents
//transformations
public class Matrices3D {

    public double[][] getTranslation3D_MAtrix(float tx, float ty, float tz) {
        double[][] scaleMatrix = {
                {1, 0, 0, tx}, {0, 1, 0, ty}, {0, 0, 1, tz}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public double[][] getRotate3D_X_Axis_Matrix(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double msin = sin * -1;

        double[][] scaleMatrix = {
                {1, 0, 0, 0}, {0, cos, msin, 0}, {0, sin, cos, 0}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public double[][] getRotate3D_Y_Axis_Matrix(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double msin = sin * -1;

        double[][] scaleMatrix = {
                {cos, 0, sin, 0}, {0, 1, 0, 0}, {msin, 0, cos, 0}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public double[][] getRotate3D_Z_Axis_Matrix(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double msin = sin * -1;

        double[][] scaleMatrix = {
                {cos, msin, 0, 0}, {sin, cos, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public double[][] getScale3D_Matrix(float sx, float sy, float sz) {
        double[][] scaleMatrix = {
                {sx, 0, 0, 0}, {0, sy, 0, 0}, {0, 0, sz, 0}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public double[][] getShare3D_Matrix(float hx, float hy, float hz) {
        double[][] scaleMatrix = {
                {1, 0, hx, 0}, {0, 1, hy, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}
        };
        return scaleMatrix;
    }

    public Coordinate Transformation(Coordinate vertex, double[] matrix) {
        //affine transformation with homogeneous coordinates
        //i.e. a vector (vertex) multiply with the transformation matrix
        // vertex - vector in 3D
        // matrix - transformation matrix
        Coordinate result = new Coordinate();
        result.x = matrix[0] * vertex.x + matrix[1] * vertex.y + matrix[2] * vertex.z + matrix[3];
        result.y = matrix[4] * vertex.x + matrix[5] * vertex.y + matrix[6] * vertex.z + matrix[7];
        result.z = matrix[8] * vertex.x + matrix[9] * vertex.y + matrix[10] * vertex.z + matrix[11];
        result.w = matrix[12] * vertex.x + matrix[13] * vertex.y + matrix[14] * vertex.z + matrix[15];
        return result;
    }

    public Coordinate[] Transformation(Coordinate[] vertices, double[] matrix) {   //Affine transform a 3D object with vertices
        // vertices - vertices of the 3D object.
        // matrix - transformation matrix
        Coordinate[] result = new Coordinate[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            result[i] = Transformation(vertices[i], matrix);
            result[i].Normalise();
        }
        return result;
    }

}
