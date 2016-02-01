package com.mytripgh.tripgh;

/**
 * Created by eit on 4/18/15.
 */
public class LazyItem {
    String name;
    String id;
    int image;
    String description;
    public LazyItem(String id,String name,String description,int image){
        this.image = image;
        this.id = id;
        this.description = description;
        this.name = name;

    }


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
}
