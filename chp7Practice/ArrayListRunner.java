import java.util.ArrayList;

public class ArrayListRunner
{
    public static void main(String[] args)
    {
        //Initializtion
        ArrayList<String> names = new ArrayList<String>();
        System.out.println(names);
        
        //add()
        names.add("Allice");
        names.add("Bob");
        names.add("David");
        names.add("Edward");
        names.add("Fran");
        names.add("Gomez");
        names.add("Harry");
        System.out.println(names);
        
        //get()/size()
        System.out.println("Size: " + names.size());
        System.out.println("First: " + names.get(0) + "\tLast: " + names.get(names.size()-1));
        
        
        //set()
        names.set(0, "Alice B. Toklas");
        System.out.println(names);
        
        //add() 2
        names.add(3, "Doug");
        System.out.println(names);
        
        //for loop
        for (String name : names)
        {
            System.out.println(name);
        }
        
        //names2
        ArrayList<String> names2 = new ArrayList<String>(names);
        System.out.println(names2);
        
        //remove()
        names.remove(0);
        System.out.println(names2);
        System.out.println(names);
        
    }
}