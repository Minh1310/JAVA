
package bo;

import java.util.ArrayList;
import java.util.List;
import entity.Fresher;
public class FresherBO implements IMethod<Fresher> {
    private List<Fresher> list;

    public FresherBO(List<Fresher> list) {
        this.list = list;
    }

    public FresherBO() {
        list = new ArrayList<>();
        list.add(new Fresher("HE161654", "F", "A", "10/10/2003", "FPT",
                            "1234567890", "minh@gmail.com", 1,
                            "12/12/2022", "A", "FPT"));
    }

    public List<Fresher> getList() {
        return list;
    }

    public void setList(List<Fresher> list) {
        this.list = list;
    }

    /**
     * @param id
     * @return
     */
    private boolean checkExist(String id){
        return list.stream().anyMatch((ls) -> (ls.getId().equalsIgnoreCase(id)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display() {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fresher> search(String name) {
        List<Fresher> listFind = new ArrayList<>();
        list.forEach(ls -> {
            if(
                ls.getFirstName().toLowerCase().contains(name)|| 
                ls.getLastName().toLowerCase().contains(name)
            ) {
                listFind.add(ls);
            }
        });
        return listFind;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add() {
        Fresher action = new Fresher();
        action.input();
        if (checkExist(action.getId())) {
            return false;
        }
        list.add(action);
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void display(List<Fresher> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());   
    }
}
    
