import java.util.ArrayList;
import java.util.Arrays;



public class Permutations<E> {
    private ArrayList<E> array;
    private Permutations<E> child;
    private final int size;
    private final E firstPosition;
    private int counter = 0;

    public Permutations(final List<E> oList) {

        final ArrayList<E> copy = new ArrayList<E>(oList);
        this.size = copy.size();
        if (size > 0) {
            this.firstPosition = copy.get(0);
            this.child = new Permutations<>(copy);
            this.array = this.child.next();
        } else this.firstPosition = null;
    }

    public boolean hasNext() {

        return size != 0 && counter < size;
    }

    public ArrayList<E> next() {

        if (!hasNext())
            return null;
        if (array == null) {
            ++counter;
            return array;
        }

        ArrayList<E> myArray = new ArrayList<E>(array);
        myArray.add(counter++, firstPosition);
        if (counter == size && child.hasNext()) {
            this.array = child.next();
            counter = 0;
        }
        return myArray;
    }
}

