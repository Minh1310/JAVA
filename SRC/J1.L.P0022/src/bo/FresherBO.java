
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
		list = new ArrayList<Fresher>();
	}

    public List<Fresher> getList() {
        return list;
    }

    public void setList(List<Fresher> list) {
        this.list = list;
    }

	/**
     * @param list
     * @param id
     * @return
     */
    private boolean checkExist(String id){
    	for(Fresher ls : list){
            if(ls.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
    return false;
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

	@Override
	public boolean add() {
		  Fresher action = new Fresher();
		  action.input();
		  if(checkExist(action.getId())){
		     return false;
		  }
		  list.add(action);
		  return true;
	}

    @Override
    public void display(List<Fresher> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());   
    }
}
    
