package bo;

import java.util.ArrayList;

import entity.Experience;

public class ExperienceBO implements IMethod<Experience>{

    /**
     * @param list
     * @param id
     * @return
     */
    private boolean checkExist(ArrayList<Experience> list, String id){
            for(Experience ls : list){
                if(ls.getId().equalsIgnoreCase(id)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean add(ArrayList<Experience> list) {
        Experience experience = new Experience();
        experience.input();
        if(checkExist(list, experience.getId())){
            return false;
        }
        list.add(experience);
        return true;
    }

    @Override
    public void display(ArrayList<Experience> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        list.forEach(ls-> ls.display());
        
    }

    @Override
    public ArrayList<Experience> search(ArrayList<Experience> list, String name) {
        ArrayList<Experience> listFind = new ArrayList<>();
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