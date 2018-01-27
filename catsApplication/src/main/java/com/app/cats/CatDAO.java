package com.app.cats;

import com.app.cats.domain.Cat;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class CatDAO {

    List<Cat> cats = new ArrayList<Cat>();

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public List<Cat> getCats() {
        return cats;
    }

    public Cat getCatById(Integer id) {
        if (id < cats.size()) {
            return cats.get(id);
        } else {
            return null;
        }
    }
}
