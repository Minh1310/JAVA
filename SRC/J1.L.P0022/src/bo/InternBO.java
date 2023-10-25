
package bo;

import java.util.ArrayList;
import java.util.List;

import entity.Intern;

public class InternBO implements IMethod<Intern> {
	
	private List<Intern> list;
    public InternBO(List<Intern> list) {
		super();
		this.list = list;
	}
    

	public InternBO() {
		super();
		list = new ArrayList<Intern>();
	}


	/**
     * @param list
     * @param id
     * @return
     */
    private boolean checkExist( String id){
            for(Intern ls : list){
                if(ls.getId().equalsIgnoreCase(id)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean add() {
        Intern action = new Intern();
        action.input();
        if(checkExist(action.getId())){
            return false;
        }
        list.add(action);
        return true;
    }

    @Override
    public void display() {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());
    }

    @Override
    public List<Intern> search(String name) {
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


    @Override
    public void display(List<Intern> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display()); 
    }
}