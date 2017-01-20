package geography;


import java.util.ArrayList;

public class city {

    private int coordX;
    private int coordY;
    private String name;
    private String river;
    ArrayList<river> rivers;


    city(int x, int y, String riverName, String cityName){
        coordX = x;
        coordY = y;
        river = riverName;
        name = cityName;
        rivers = new ArrayList<>();
    }

    public static double distance(city A, city B){

        /*
          make a variable to hold the distance to be returned.
          Use get method to find the coordinates of city A and city B.

          use the distance formula to get the distance between 2 cities.
          D = sqrt((x2 - x1)^2 + (y2 - 1)^2)

         */
        return 0;
    }

    public void addRivers(river River){

        /*
        add the river to the rivers arraylist.
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

    public void setName(String cityName){
        name = cityName;
    }

    public String getRiver(){
        return river;
    }

    public void setRiver(String riverName){
        river = riverName;
    }





}
