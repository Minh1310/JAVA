
package bo;

import java.util.ArrayList;

import entity.Intern;

public class InternBO implements IMethod<Intern> {

    /**
     * @param list
     * @param id
     * @return
     */
    private boolean checkExist(ArrayList<Intern> list, String id){
            for(Intern ls : list){
                if(ls.getId().equalsIgnoreCase(id)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean add(ArrayList<Intern> list) {
        Intern action = new Intern();
        action.input();
        if(checkExist(list, action.getId())){
            return false;
        }
        list.add(action);
        return true;
    }

    @Override
    public void display(ArrayList<Intern> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());
    }

    @Override
    public ArrayList<Intern> search(ArrayList<Intern> list,String name) {
        ArrayList<Intern> listFind = new ArrayList<>();
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