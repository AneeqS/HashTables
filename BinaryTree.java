public class BinaryTree{

    public  Node root;


    //Creates a empty binary tree
    public BinaryTree(){
        root = null;
    }

    //Insert method for inserting students.
    public void insertStudent(Student s){
        root = insertStudent(s, root);
    }
    private static Node insertStudent(Student s, Node t){

        if(s.checkIdFormat(s.getId())){
            throw new IllegalArgumentException("Illegal Format");
        }

        if(!(t == null)){
            if(s.compareToLast(t.data) < 0){
                t.left = insertStudent(s, t.left);
            }
            else if (s.compareToLast(t.data) > 0){
                t.right = insertStudent(s, t.right);
            }
        }
        else
            t = new Node(s);
        return t;
    }

    //Insert method for inserting faculty members
    public void insertFaculty(Faculty f){
        root = insertFaculty(f, root);
    }
    private static Node insertFaculty(Faculty f, Node t){

        if(f.checkIdFormat(f.getId())){
            throw new IllegalArgumentException("Illegal Format");
        }

        if(!(t == null)){
            if(f.compareToLast(t.data1) < 0){
                t.left = insertFaculty(f, t.left);
            }
            else if (f.compareToLast(t.data1) > 0){
                t.right = insertFaculty(f, t.right);
            }
        }
        else
            t = new Node(f);
        return t;

    }

    //Displays the tree in different orders.
    public void displayStudentTree(BinaryTree t){
        System.out.println("Students Inorder\n");
        inOrderS(t.root);
        System.out.println();
    }

    //Sorted Order
    //Left,root,right
    public void inOrderS(){
        inOrderS(root);
    }
    private static void inOrderS(Node t){
        if(!(t == null)){
            inOrderS(t.left);
            System.out.println(t.data.toString());
            inOrderS(t.right);
        }
    }

    //Displays the faculty member tree
    public void displayFacultyTree(BinaryTree t){
        System.out.println("Faculty Inorder\n");
        inOrderF(t.root);
        System.out.println();


    }

    //Inorder
    //Sorted Order
    //Left,root,right
    public void inOrderF(){
        inOrderF(root);
    }
    private static void inOrderF(Node t){
        if(!(t == null)){
            inOrderF(t.left);
            System.out.println(t.data1.toString());
            inOrderF(t.right);
        }
    }

    //This Method deletes a specific student from the tree
    public Node deleteStudent(Student s, Node t){
        if(t != null){
            if(s.compareToLast(t.data) < 0){
                t.left = deleteStudent(s, t.left);
            }
            else if (s.compareToLast(t.data) > 0){
                t.right = deleteStudent(s, t.right);
            }
            else{
                if(t.left == null){
                    return t.right;
                }
                else if(t.right == null){
                    return t.left;
                }
                else{
                    if(s.compareToLast(t.right.data) < 0){
                        t.data = t.right.data;
                        t.right = deleteStudent(t.data, t.right);
                    }
                }
            }
        }
        return t;
    }

    //This Method deletes a specific faculty member from the tree
    public Node deleteFaculty(Faculty f, Node t){
        if(t != null){
            if(f.compareToLast(t.data1) < 0){
                t.left = deleteFaculty(f, t.left);
            }
            else if (f.compareToLast(t.data1) > 0){
                t.right = deleteFaculty(f, t.right);
            }
            else{
                if(t.left == null){
                    return t.right;
                }
                else if(t.right == null){
                    return t.left;
                }
                else{
                    if(f.compareToLast(t.right.data1) < 0){
                        t.data1 = t.right.data1;
                        t.right = deleteFaculty(t.data1, t.right);
                    }
                }
            }
        }
        return t;
    }

}

class Node{
    Student data;
    Faculty data1;
    Node left;
    Node right;
    public Node(Student data){
        this.data = data;
        left = null;
        right = null;
    }
    public Node(Faculty data){
        this.data1 = data;
        left = null;
        right = null;
    }
}


