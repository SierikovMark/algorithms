package org.algorithms.coursera.part1.week1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// time [id_1] [id_2]
public class SocialNetworkFriends {

    public static void main(String[] args) {
        if (args == null || args.length == 0) return;

        String pathToFile = args[0];
        int amountOfPeopleInSocialNetwork = Integer.parseInt(args[1]);

        SocialNetworkFriends socialNetworkFriends = new SocialNetworkFriends(amountOfPeopleInSocialNetwork);

        int amountOfUnion = 0;
        try (FileInputStream inputStream = new FileInputStream(pathToFile);
             Scanner sc = new Scanner(inputStream, "UTF-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split("\\s");
                boolean union = socialNetworkFriends.union(Integer.valueOf(split[1]), Integer.valueOf(split[2]));
                amountOfUnion++;
                if (union) {
                    System.out.println("It took " + amountOfUnion + " operation to connect all friends in social network");
                    break;
                }

            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

    private int[] ids;
    private int[] sz;
    private int numberOfConnectedComponent;

    public SocialNetworkFriends (int N) {
        ids = new int[N];
        sz = new int[N];
        numberOfConnectedComponent = N;
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int i) {
        while (ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public boolean union(int p, int q) {
        int i = findRoot(p);
        int j = findRoot(q);
        if (i == j) return false;
        numberOfConnectedComponent--;
        if (sz[i] < sz[j]) {
            ids[i] = j;
            sz[j] += sz[i];
        } else {
            ids[j] = i;
            sz[i] += sz[j];
        }
        return numberOfConnectedComponent < 2;

    }
}
