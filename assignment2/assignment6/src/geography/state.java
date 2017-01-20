package geography;


import java.util.ArrayList;

public class state {

    private int coordX;
    private int coordY;
    private String name;
    private String stateCapital;
    private String river;
    ArrayList<city> cities;


    state(int x, int y, String riverName, String stateName){
        coordX = x;
        coordY = y;
        river = riverName;
        name = stateName;
        cities = new ArrayList<>();
    }

    public static double distance(state A, state B){

        /*
          make a variable to hold the distance to be returned.
          use to coordinates of the capital cities as the coordinates of the states
          Use get method to find the coordinates of state A and state B capitals.

          use the distance formula to get the distance between 2 cities.
          D = sqrt((x2 - x1)^2 + (y2 - 1)^2)

         */
        return 0;
    }

    public void addCity(city cities){

        /*
        add the city to the cities arraylist.
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

    public void setName(String stateName){
        name = stateName;
    }

    public String getRiver(){
        return river;
    }

    public void setRiver(String riverName){
        river = riverName;
    }


    public String getStateCapital(){
        return stateCapital;
    }

    public void setCityCapital(String capitalName){
        stateCapital = capitalName;
    }
}
