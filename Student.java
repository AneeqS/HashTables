public class Student{
    //The Three characteristics for Student class
    private String firstName;
    private String lastName;
    private String studentId;


    //Constructor for Student Class with no parameters
    public Student(){
        firstName = null;
        lastName = null;
        studentId = "" ;
    }

    //Constructor for Student Class with parameters
    public Student(String first, String last, String id){
        firstName = first;
        lastName = last;
        studentId = id;
    }

    //Getter method for FirstName
    public String getFirstName(){
        return firstName;
    }

    //Getter method for LastName
    public String getLastName(){
        return lastName;
    }

    //Getter Method for id
    public String getId(){
        return studentId;
    }

    //Setter Method for FirstName
    public void setFirstName(String first){
        this.firstName = first;
    }

    //Setter Method for LastName
    public void setLastName(String last){
        this.lastName = last;
    }

    //Setter Method for Id
    public void setId(String id ){
        if(checkIdFormat(id) == false)
            throw new IllegalArgumentException("Illegal Format");
        else
            this.studentId = id;
    }

    //Checks if the two id's are equal
    public boolean isEquals(String id){
        return studentId.equals(id);
    }

    //Puts the first name, last name, and id into one string.
    public String toString(){
        String temp = firstName + " " + lastName + " " + studentId;
        return temp;
    }

    //Compares the last name of two students.
    public int compareToLast(Student s){
        int index1 = 0;
        int index2 = 0;
        int length = 0;
        int i = 0;

        if(lastName.length() < s.getLastName().length())
            length = lastName.length();
        else
            length = s.getLastName().length();

        if(lastName.charAt(0) == s.getLastName().charAt(0)){
            for(i = 1; i < length; i++){
                if(lastName.charAt(i) != s.getLastName().charAt(i)){
                    index1++;
                    index2++;
                    break;
                }
                if(i == length - 1){
                    return 0;
                }
            }
        }
        if(lastName.charAt(index1) < s.getLastName().charAt(index2)){
            return -1;
        }
        return 1;
    }

    //Compares the first names of two students.
    public int compareToFirst(Student s){
        int index1 = 0;
        int index2 = 0;
        int length = 0;
        int i = 0;

        if(firstName.length() < s.getFirstName().length())
            length = firstName.length();
        else
            length = s.getFirstName().length();

        if(lastName.charAt(0) == s.getFirstName().charAt(0)){
            for(i = 1; i < length; i++){
                if(firstName.charAt(i) != s.getFirstName().charAt(i)){
                    index1++;
                    index2++;
                    break;
                }
                if(i == length - 1){
                    return 0;
                }
            }
        }
        if(firstName.charAt(index1) < s.getFirstName().charAt(index2)){
            return -1;
        }
        return 1;
    }

    //Checks the format of id to see if it matches the required format.
    public boolean checkIdFormat(String id){
        if(id.charAt(0) != 'S'){
            return true;
        }
        if(id.length() > 8)
            return true;
        else
            return false;
    }

    public int last4Id(Student s){
        String temp = s.getId().substring(4,8);
        int temp1 = 0;
        temp1 = Integer.parseInt(temp);
        return temp1;
    }

}