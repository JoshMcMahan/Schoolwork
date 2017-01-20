package geography;


import java.util.ArrayList;

public class country {

    private int coordX;
    private int coordY;
    private String name;
    private String countryCapital;
    ArrayList<state> states;


    country(int x, int y, String countryName){
        coordX = x;
        coordY = y;
        name = countryName;
        states = new ArrayList<>();
    }

    public static double distance(country A, country B){

        /*
          make a variable to hold the distance to be returned.
          use to coordinates of the capital cities as the coordinates of the states
          Use get method to find the coordinates of country A and country B capitals.

          use the distance formula to get the distance between 2 cities.
          D = sqrt((x2 - x1)^2 + (y2 - 1)^2)

         */
        return 0;
    }

    public void addState(state states){

        /*
        add the states to the country arraylist.
         */
    }

    public int getCoordX(){
        return coordX;
    }

    public int getCoordY(){
        return coordY;
    }

    public void setCoordX(int x){
        coordX = x;
    }

    public void setCoordY(int y){
        coordY = y;
    }
    public String getName(){
        return name;
    }

    public void setName(String countryName){
        name = countryName;
    }

    public String getCountryCapital(){
        return countryCapital;
    }

    public void setCityCapital(String capitalName){
        countryCapital = capitalName;
    }
}
