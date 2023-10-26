
package bo;

import java.util.ArrayList;
import java.util.List;

import entity.Experience;

public class ExperienceBO implements IMethod<Experience>{
	
    private  List<Experience> list;
    
    public ExperienceBO() {
        this.list = new ArrayList<>();
        list.add(new Experience("HE171754", "E", "A", "10/10/2003", "FPT",
                                "1234567890", "minh@gmail.com", 0, 3, "Speaking"));
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
        return list.stream().anyMatch((ls) -> (ls.getId().equalsIgnoreCase(id)));
    }

    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Experience> search(String text) {
        List<Experience> listFind = new ArrayList<>();
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
    public void display(List<Experience> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display()); 
    }
}