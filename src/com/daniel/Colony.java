package com.daniel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Colony {

    private static final int GRID_WIDTH = 150;
    private static final int GRID_HEIGHT = 25;
    private static final int FIELDS_NUMBER = GRID_WIDTH * GRID_HEIGHT;

    private static ColonyObject[][] colonyGrid = new ColonyObject[GRID_HEIGHT][GRID_WIDTH];
    private List<Ant> antArray = new ArrayList<>();


    Colony() {
        generateColonyGrid();
    }

//    public static Colony getInstance() {}

    private void generateColonyGrid() {

        placeQueenOnGrid();

        for (int y=0; y < GRID_HEIGHT; y++) {
            for (int x=0; x < GRID_WIDTH; x++) {

                boolean fieldTakenByQueen = y == GRID_HEIGHT / 2 && x == GRID_WIDTH / 2;
                if (fieldTakenByQueen) continue;

                int randomInt = getRandomNumber();
                ColonyObject field;

                if (randomInt >= 1 && randomInt <= 10) {
                    Ant worker = new Worker(x, y);
                    field = worker;
                    antArray.add(worker);
                } else if (randomInt > 10 && randomInt < 16) {
                    Ant soldier = new Soldier(x, y);
                    field = soldier;
                    antArray.add(soldier);
                } else if (randomInt >= 16 && randomInt < 19) {
                    Ant drone = new Drone(x, y);
                    field = drone;
                    antArray.add(drone);
                } else {
                    field = new EmptyField();
                }

                colonyGrid[y][x] = field;
            }
        }
    }

    private int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, FIELDS_NUMBER + 1);
    }

    void printColonyGrid() {
//        for (int i=0; i < 5; i++) {
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        }
        System.out.print("\u001B[2J");
        for (ColonyObject[] array : colonyGrid) {
            List<String> myList = new ArrayList<>();

            for (ColonyObject colonyObject : array) {
                myList.add(colonyObject.displayValue());
            }

            String joinedString = String.join("", myList);
            System.out.println(joinedString);
        }
    }

    static ColonyObject[][] getColonyGrid() {
        return colonyGrid;
    }

    List<Ant> getAntArray() {
        return antArray;
    }

    static int getGridWidth() {
        return GRID_WIDTH;
    }

    static int getGridHeight() {
        return GRID_HEIGHT;
    }

    private void placeQueenOnGrid() {
        Ant queen = Queen.getInstance();
        antArray.add(queen);
        colonyGrid[GRID_HEIGHT / 2][GRID_WIDTH / 2] = queen;
    }
}
