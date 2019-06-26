package com.collection;

import java.util.Objects;

public class Item {
   private String description;
   private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "[descripion="+description+",partNumber"+partNumber+"]";
    }

    public boolean equals(Object otherObject){
        if (this == otherObject)return true;
        if (otherObject == null)return false;
        if (getClass() != otherObject.getClass())return false;
        Item other = (Item)otherObject;
        return Objects.equals(description,other.partNumber)&&partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description,partNumber);
    }

    public int compareTo(Item other){
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
