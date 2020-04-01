package sample;
// This class will hold enums of circuits and will be used by the

import java.util.Random;

public class Exercises
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
        PULL_UPS,PULL_DOWNS, BENT_OVER_ROWS, HYPEREXTENSIONS;
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

    public static void testRandom()
    {
        // Generate a list of 30 random workouts
        for (int i=1;i<30;i++)
        {
            System.out.println(cardio.randomCardio() + "," + tricep.randomTricep() +
                    "," + back.randomBack() + "," + legs.randomLegs() + "," + core.randomCore()
                    + "," + bicep.randomBicep());
        }
    }
    public static void main(String[] args)
    {
        testRandom();
    }
}