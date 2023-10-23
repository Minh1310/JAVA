
package bo;

import java.util.ArrayList;

import entity.Fresher;

public class FresherBO implements IMethod<Fresher> {

    /**
     * @param list
     * @param id
     * @return
     */
    private boolean checkExist(ArrayList<Fresher> list, String id){
            for(Fresher ls : list){
                if(ls.getId().equalsIgnoreCase(id)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean add(ArrayList<Fresher> list) {
        Fresher action = new Fresher();
        action.input();
        if(checkExist(list, action.getId())){
            return false;
        }
        list.add(action);
        return true;
    }

    @Override
    public void display(ArrayList<Fresher> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());
    }

    @Override
    public ArrayList<Fresher> search(ArrayList<Fresher> list,String name) {
        ArrayList<Fresher> listFind = new ArrayList<>();
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
    
}