
package bo;

import java.util.List;

public interface IMethod<E> {
     
    /**
     *
     * Use to add information
     * @return 
     */
    abstract public boolean add();

    /**
     * Use to search information you want
     * @param text
     * @return 
     */
    abstract public List<E> search(String text);

    /**
     * Use to display information 
     * 
     */
    abstract public void display();

    /**
     * 
     * @param list is list take from input
     */
    abstract public void display(List<E> list);
}