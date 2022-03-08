package com.company.NearestNeighbor;

import java.io.*;
import java.util.*;

public class NearestNeighbor {

    public static void nearestNeighbor(){

        int n, i, j, d = 3;
        float r;

        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println("Enter the number "
                    + "of points to compare");
            n = in.nextInt();

            // Declare the matrix
            int[][] points = new int[n][d];

            // Read the matrix values
            System.out.println("Enter the coordinates of each point: line by line");
            for (i = 0; i < n; i++) {
                System.out.println("x y & z for row " + i);
                for (j = 0; j < d; j++) {
                    points[i][j] = in.nextInt();
                }
            }

            // Display the elements of the matrix
            System.out.println("Elements of the matrix are");
            for (i = 0; i < n; i++) {
                for (j = 0; j < d; j++)
                    System.out.print(points[i][j] + "  ");
                System.out.println();
            }

            System.out.println("Enter the floating point radius r");
            r = in.nextFloat();

            findNearestNeighbors(r, n, points);
        }
        catch (Exception e) {
        }
        finally {
            in.close();
        }
    }

    public static void findNearestNeighbors(float r, int n, int[][] points){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){ //where i is each point's ID
            ArrayList<Integer> neighborIDs = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(points[i] != points[j]){
                    float d = ptDistance(points[i], points[j]);
                    if(r > d){
                       neighborIDs.add(j);
                    }
                }
            }
            map.put(i, neighborIDs);
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            Integer ID = entry.getKey();
            Object[] arr = entry.getValue().toArray();
            String neighbors = Arrays.toString(arr);
            //neighbors.split("[").split("]");
            System.out.println(ID + ": " + neighbors);  //**log** nodeID: id_0, id_1, id_2, ... , id_n for each neighbor where distance < r.
        }
    }

    public static float ptDistance(int[] point, int[] relativePoint){
        float result;
        double  dX = point[0] - relativePoint[0],
                dY = point[1] - relativePoint[1],
                dZ = point[2] - relativePoint[2];

        result = (float) Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2) + Math.pow(dZ, 2));
        return result;
    }
}
