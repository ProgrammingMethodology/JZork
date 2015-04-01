package gr.teicm.pm.jzork;

import gr.teicm.pm.jzork.items.Item;
import java.util.ArrayList;
import java.util.List;

public abstract class Inventory {

    private List<Item> itemList;
    private int id;

    public Inventory(int i) {
        id = i;
        itemList = new ArrayList<Item>();
    }

    public Inventory(int i, List<Item> l) {
        id = i;
        itemList = l;
    }
//add a newly created item in the container

    public void addItem(Item it) {
        itemList.add(it);
    }

    public static String describeItems(List<Item> items) {
        int itCount = items.size();
        switch (itCount) {
            case 0:
                return "nothing";
            case 1:
                return items.get(0).getName();
            default:
                int i;
                String desc = "";
                for (i = 0; i < itCount - 1; ++i) {
                    desc += items.get(i).getName() + ", ";
                }
                return desc + "and " + items.get(i).getName();
        }
    }

    public String describeItems() {
        return describeItems(itemList);
    }
//removes the item from the container

    public void removeItem(Item it) {
        itemList.remove(it);
    }

    public boolean containsItem(Item it) {
        return itemList.contains(it);
    }

    public Item itemWithName(String name) {
        name = name.toLowerCase();
        for (Item it : itemList) {
            if (it.getName().toLowerCase().equals(name)) {
                return it;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
