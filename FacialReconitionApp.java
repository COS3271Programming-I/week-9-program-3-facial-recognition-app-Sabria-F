import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FacialReconitionApp {
    //Initiate two scanners. One to read from the file and the other to get user input.
    static Scanner userinput = new Scanner(System.in);
    static Scanner datainput = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "FaceMeasurments.txt";
        File faceMeasures = new File(fileName);
        datainput = new Scanner(faceMeasures);
        //Create arrays to hold the measurments and ratios.
        double [][] measure;
        measure = new double[6][6];

        double [][] ratio;
        ratio = new double[6][15];

        //Initiate two ints person, and i.
        int person;
        int i;

        //Fill the first array with all the measurments.
        for (person = 0; person <= 5; person++){
            for(i=0; i<=5; i++){
                if(datainput.hasNextDouble()){
                    measure[person][i] = datainput.nextDouble();
                }
            }
        }

        //Calculate all the ratios and fill the ratio array.
        for (person = 0; person <= 5; person++) {
			ratio[person][0] = measure[person][0] / measure [person][1];
			ratio[person][1] = measure[person][0] / measure [person][2];
            ratio[person][2] = measure[person][0] / measure [person][3];
			ratio[person][3] = measure[person][0] / measure [person][4];
            ratio[person][4] = measure[person][0] / measure [person][5];
			ratio[person][5] = measure[person][1] / measure [person][2];
            ratio[person][6] = measure[person][1] / measure [person][3];
            ratio[person][7] = measure[person][1] / measure [person][4];
            ratio[person][8] = measure[person][1] / measure [person][5];
            ratio[person][9] = measure[person][2] / measure [person][3];
            ratio[person][10] = measure[person][2] / measure [person][4];
            ratio[person][11] = measure[person][2] / measure [person][5];
            ratio[person][12] = measure[person][3] / measure [person][4];
            ratio[person][13] = measure[person][3] / measure [person][5];
            ratio[person][14] = measure[person][4] / measure [person][5];
		}

        //Create two more arrays for the mystery person's mesurments and ratios.
        double[] mysteryMeasure;
        mysteryMeasure = new double[6];

        double[] mysteryRatio;
        mysteryRatio = new double[15];

        //Fill the measurments array with the data that the user enters.
        for (int j = 0; j<= 5; j++){
            System.out.print("Enter measurement " + j + " for the mystery person --> ");
            mysteryMeasure[j] = userinput.nextDouble();
        }

        //Calculate the mystery person's ratios.
        mysteryRatio[0] = mysteryMeasure[0] / mysteryMeasure[1];
		mysteryRatio[1] = mysteryMeasure[0] / mysteryMeasure[2];
        mysteryRatio[2] = mysteryMeasure[0] / mysteryMeasure[3];
		mysteryRatio[3] = mysteryMeasure[0] / mysteryMeasure[4];
        mysteryRatio[4] = mysteryMeasure[0] / mysteryMeasure[5];
		mysteryRatio[5] = mysteryMeasure[1] / mysteryMeasure[2];
        mysteryRatio[6] = mysteryMeasure[1] / mysteryMeasure[3];
        mysteryRatio[7] = mysteryMeasure[1] / mysteryMeasure[4];
        mysteryRatio[8] = mysteryMeasure[1] / mysteryMeasure[5];
        mysteryRatio[9] = mysteryMeasure[2] / mysteryMeasure[3];
        mysteryRatio[10] = mysteryMeasure[2] / mysteryMeasure[4];
        mysteryRatio[11] = mysteryMeasure[2] / mysteryMeasure[5];
        mysteryRatio[12] = mysteryMeasure[3] / mysteryMeasure[4];
        mysteryRatio[13] = mysteryMeasure[3] / mysteryMeasure[5];
        mysteryRatio[14] = mysteryMeasure[4] / mysteryMeasure[5];

        //Create an array to hold the sumdiff number for each person.
        double[] sumdiff;
        sumdiff = new double[6];

        //Fill the array with the sumdiff numbers.
        for (person = 0; person <= 5; person++){
            for(i = 0; i <= 14; i++){
                sumdiff[person] += Math.pow(((mysteryRatio[i] - ratio[person][i])/ratio[person][i]),2);
            }
        }

        //Create a double to hold the lowest sumdiff number.
        double lowest = sumdiff[0];

        //Find the lowest number.
        for(person = 0; person <= 5; person++){
            if(sumdiff[person] < lowest){
                lowest = sumdiff[person];
            }
        }

        //Test which person had the lowest number, and tell the user who the mystery picture was of.
        if(sumdiff[0] == lowest){
            System.out.println("That was a picture of Trump.");
        }
        else if(sumdiff[1] == lowest){
            System.out.println("That was a picture of JD Vance.");
        }
        else if(sumdiff[2] == lowest){
            System.out.println("That was a picture of John Macarthur.");
        }
        else if(sumdiff[3] == lowest){
            System.out.println("That was a picture of Milton Freedman.");
        }
        else if(sumdiff[4] == lowest){
            System.out.println("That was a picture of Ronald Reagan.");
        }

        //Close both scanners.
        userinput.close();
        datainput.close();
    }
}
