package bo;

import java.util.ArrayList;
import java.util.List;
import entity.Intern;

public class InternBO implements IMethod<Intern> {

    private List<Intern> list;

    public InternBO(List<Intern> list) {
        this.list = list;
    }

    public List<Intern> getList() {
        return list;
    }

    public void setList(List<Intern> list) {
        this.list = list;
    }

    public InternBO() {
        list = new ArrayList<>();
        list.add(new Intern("HE151554", "I", "A", "10/10/2003", "FPT",
                            "1234567890", "minh@gmail.com", 2, "SE", "FALL", "FPT"));
    }

    /**
     * @param id
     * @return
     */
    private boolean checkExist(String id) {
        return list.stream().anyMatch((ls) -> (ls.getId().equalsIgnoreCase(id)));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add() {
        Intern action = new Intern();
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
    public void display() {
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        list.forEach(ls -> ls.display());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Intern> search(String name) {
        ArrayList<Intern> listFind = new ArrayList<>();
        list.forEach(ls -> {
            if (ls.getFirstName().toLowerCase().contains(name)
                || ls.getLastName().toLowerCase().contains(name)
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
    public void display(List<Intern> list) {
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        list.forEach(ls -> ls.display());
    }
}
