public class treeNode implements Comparable {

    treeNode left = null;
    treeNode right = null;

    char bitValue = '*';
    int weight = 0;

    treeNode(char s, int t) {

        this.weight = t;
        this.bitValue = s;
    }

    treeNode(treeNode L, treeNode R) {

        this.right = R;
        this.left = L;
        this.weight = (L.weight + R.weight);
    }

    public int compair(treeNode object) {
        if (this.weight < object.weight) {
            return 1;
        } else if (this.weight > object.weight) {
            return 0;
        } else if (this.weight == object.weight) {
            return -1;
        }
    }

}