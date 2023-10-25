
package bo;

import java.util.List;

public interface IMethod<E> {
    
    /**
     *
     * Use to add information
     */
    abstract public boolean add();

    /**
     * Use to search information you want
     */
    abstract public List<E> search(String text);

    /**
     * Use to display information 
     * 
     * @param list is list information 
     */
    abstract public void display();

    /**
     * 
     * @param list is list take from input
     */
    abstract public void display(List<E> list);
}