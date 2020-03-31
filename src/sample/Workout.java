package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.awt.*;
import java.util.Random;

public class Workout
{

    public enum core
    {
        PLANK,CRUNCHES,LEG_LIFT,SIT_UPS, BICYCLES, REVERSE_CRUNCHES, SIDE_PLANK, RUSSIAN_TWISTS;
        public static core randomCore()
        {
            Random rand = new Random();
            int random = rand.nextInt(core.values().length); // Gives values 0-3
            return core.values()[random];
        }
    }
    private enum legs
    {
        BACK_SQUAT,LUNGES, LEG_CURLS, LEG_EXTENSIONS, CALF_RAISES, DEADLIFT, SUMO_DEADLIFT, FRONT_SQUAT;
        public static legs randomLegs()
        {
            Random rand = new Random();
            int random = rand.nextInt(legs.values().length); // Gives values 0-3
            return legs.values()[random];
        }
    }
    private enum back
    {
        PULL_UPS,PULL_DOWNS, BENT_OVER_ROWS, HYPER_EXTENSIONS;
        public static back randomBack()
        {
            Random rand = new Random();
            int random = rand.nextInt(back.values().length); // Gives values 0-3
            return back.values()[random];
        }
    }
    private enum chest
    {
        BENCH_PRESS,INCLINE_BENCH_PRESS,DUMBBELL_FLY, PUSH_UPS,INCLINE_CHEST_PRESS;
        public static chest randomChest()
        {
            Random rand = new Random();
            int random = rand.nextInt(chest.values().length); // Gives values 0-3
            return chest.values()[random];
        }
    }
    private enum bicep
    {
        BICEP_CURLS,HAMMER_CURLS,CHIN_UPS;
        public static bicep randomBicep()
        {
            Random rand = new Random();
            int random = rand.nextInt(bicep.values().length); // Gives values 0-3
            return bicep.values()[random];
        }
    }
    private enum tricep
    {
        SKULL_CRUSHERS,TRICEP_EXTENSIONS,DIAMOND_PUSH_UPS;
        public static tricep randomTricep()
        {
            Random rand = new Random();
            int random = rand.nextInt(tricep.values().length); // Gives values 0-3
            return tricep.values()[random];
        }
    }
    private enum cardio
    {
        BURPEES,STAR_JUMPS,SKIPPING, RUNNING, BIKING;
        public static cardio randomCardio()
        {
            Random rand = new Random();
            int random = rand.nextInt(cardio.values().length);
            return cardio.values()[random];
        }
    }


    @FXML
    private Button fullButton;
    private Button coreButton;
    private Button legsButton;
    private Button cardioButton;
    private Button backButton;
    private Button chestButton;
    private Button bicepButton;
    private Button tricepButton;


    public void fullBodyWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(cardio.randomCardio() + "\n" + tricep.randomTricep() +
                "\n" + back.randomBack() + "\n" + legs.randomLegs() + "\n" + core.randomCore()
                + "\n" + bicep.randomBicep());
        alert.showAndWait();
    }


    public void coreWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(core.randomCore() + "\n" + core.randomCore() + "\n" +core.randomCore());
        alert.showAndWait();
    }

    public void legWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(legs.randomLegs() + "\n" +legs.randomLegs() + "\n" + legs.randomLegs());
        alert.showAndWait();
    }

    public void cardioWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(cardio.randomCardio() + "\n" +cardio.randomCardio()+ "\n" + cardio.randomCardio());
        alert.showAndWait();
    }

    public void backWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(bicep.randomBicep() + "\n" +bicep.randomBicep() + "\n" + bicep.randomBicep());
        alert.showAndWait();
    }

    public void chestWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(chest.randomChest() + "\n" +chest.randomChest() + "\n" + chest.randomChest());
        alert.showAndWait();
    }

    public void bicepWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(bicep.randomBicep() + "\n" + bicep.randomBicep() + "\n" + bicep.randomBicep());
        alert.showAndWait();
    }

    public void tricepWorkout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Workout circuit - Complete one minute of each exercise and repeat the circuit 3 times.");
        alert.setContentText(tricep.randomTricep() + "\n" +tricep.randomTricep() + "\n" + tricep.randomTricep());
        alert.showAndWait();
    }


}
