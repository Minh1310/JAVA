
package bo;

import java.util.ArrayList;
import java.util.List;

import entity.Experience;

public class ExperienceBO implements IMethod<Experience>{
	
    private  List<Experience> list;
    
    public ExperienceBO() {
        this.list = new ArrayList<>();
    }

    public ExperienceBO(List<Experience> list) {
        this.list = list;
    }

    public List<Experience> getList() {
        return list;
    }

    public void setList(List<Experience> list) {
        this.list = list;
    }

    /**
     * @param list
     * @param id
     * @return
     */
    private boolean checkExist( String id){
            for(Experience ls : list){
                if(ls.getId().equalsIgnoreCase(id)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean add() {
        Experience experience = new Experience();
        experience.input();
        if(checkExist(experience.getId())){
            return false;
        }
        list.add(experience);
        return true;
    }

    @Override
    public List<Experience> search(String text) {
        ArrayList<Experience> listFind = new ArrayList<>();
        list.forEach(ls -> {
            if(
                ls.getFirstName().toLowerCase().contains(text)|| 
                ls.getLastName().toLowerCase().contains(text)
            ) {
                listFind.add(ls);
            }
        });
        return listFind; 
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
    public void display(List<Experience> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display()); 
    }
}