package AplikacjaSpring;

import java.util.ArrayList;
import java.util.List;

public class CatDAO {

    List<Cat> cats = new ArrayList<Cat>();

    public void addCat(Cat cat) {
        cats.add(cat);
    }
    public List<Cat> getCats() {
        return cats;
    }
}
