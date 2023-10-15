package bo;

import java.util.ArrayList;

public interface IMethod<E>  {
    
    /**
     *
     * Use to add information
     */
    abstract public boolean add(ArrayList<E> list);

    /**
     * Use to search information you want
     */
    abstract public ArrayList<E> search(ArrayList<E> list, String text);

    /**
     * Use to display information 
     * 
     * @param list is list information 
     */
    abstract public void display(ArrayList<E> list);
}