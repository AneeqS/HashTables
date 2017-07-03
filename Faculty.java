public class Faculty{
    //The Three characteristics for Faculty class

    private String firstName;
    private String lastName;
    private String facultyId;


    //Constructor for Faculty Class with no parameters
    public Faculty(){
        firstName = null;
        lastName = null;
        facultyId = "" ;
    }

    //Constructor for Faculty Class with parameters
    public Faculty(String first, String last, String id){
        firstName = first;
        lastName = last;
        facultyId = id;
    }

    //Getter method for FirstName
    public String getFirstName(){
        return firstName;
    }

    //Getter method for LastName
    public String getLastName(){
        return lastName;
    }

    //Getter method for Id
    public String getId(){
        return facultyId;
    }

    //Setter Method for FirstName
    public void setFirstName(String first){
        firstName = first;
    }

    //Setter Method for LastName
    public void setLastName(String last){
        lastName = last;
    }

    //Setter Method for Id
    public void setId(String id ){
        if(checkIdFormat(id) == false)
            throw new IllegalArgumentException("Illegal Format");
        else
            this.facultyId = id;
    }

    //Checks if the two id's are equal
    public boolean isEquals(String id){
        return facultyId.equals(id);
    }

    //Puts the first name, last name, and id into one string.
    public String toString(){
        String temp = firstName + " " + lastName + " " + facultyId;
        return temp;
    }

    //Compares the last name of two faculty members.
    public int compareToLast(Faculty f){
        int index1 = 0;
        int index2 = 0;
        int length = 0;
        int i = 0;

        if(lastName.length() < f.getLastName().length())
            length = lastName.length();
        else
            length = f.getLastName().length();

        if(lastName.charAt(0) == f.getLastName().charAt(0)){
            for(i = 1; i < length; i++){
                if(lastName.charAt(i) != f.getLastName().charAt(i)){
                    index1++;
                    index2++;
                    break;
                }
                if(i == length - 1){
                    return 0;
                }
            }
        }
        if(lastName.charAt(index1) < f.getLastName().charAt(index2)){
            return -1;
        }
        return 1;
    }

    //Compares the first name of two faculty members.
    public int compareToFirst(Faculty f){
        int index1 = 0;
        int index2 = 0;
        int length = 0;
        int i = 0;

        if(firstName.length() < f.getFirstName().length())
            length = firstName.length();
        else
            length = f.getFirstName().length();

        if(lastName.charAt(0) == f.getFirstName().charAt(0)){
            for(i = 1; i < length; i++){
                if(firstName.charAt(i) != f.getFirstName().charAt(i)){
                    index1++;
                    index2++;
                    break;
                }
                if(i == length - 1){
                    return 0;
                }
            }
        }
        if(firstName.charAt(index1) < f.getFirstName().charAt(index2)){
            return -1;
        }
        return 1;
    }

    //Checks the format of id to see if it matches the required format.
    public boolean checkIdFormat(String id){
        if(id.charAt(0) != 'S'){
            return false;
        }
        if(id.length() > 8)
            return false;
        else
            return true;
    }

    public int last4Id(Faculty f){
        String temp = f.getId().substring(4,8);
        int temp1 = 0;
        temp1 = Integer.parseInt(temp);
        return temp1;
    }

}
