package com.daniel;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Colony colony = new Colony();

        colony.printColonyGrid();

        while(true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException error) {
                System.exit(1);
            }

            for (Ant ant : colony.getAntArray()) {
                ant.makeTurnAction();
            }

            colony.printColonyGrid();
        }
    }
}
