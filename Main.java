public class Main{

    public static void main(String[] args) {


        Student a = new Student("G", "V", "S6111006");
        Student b = new Student("S", "H", "S3111003");
        Student c = new Student("A", "S", "S5111005");
        Student d = new Student("A", "A", "S1111001");
        Student e = new Student("K", "I", "S4111004");
        Student f = new Student("K", "D", "S2111002");

        Faculty g = new Faculty("S", "T", "F3111003");
        Faculty h = new Faculty("J", "W", "F4111004");
        Faculty i = new Faculty("J", "Y", "F6111006");
        Faculty j = new Faculty("K", "G", "F1111001");
        Faculty k = new Faculty("K", "L", "F2111002");
        Faculty l = new Faculty("J", "W", "F5111005");

        BinaryTree students = new BinaryTree();
        BinaryTree faculty = new BinaryTree();

        students.insertStudent(a);
        students.insertStudent(b);
        students.insertStudent(c);
        students.insertStudent(d);
        students.insertStudent(e);
        students.insertStudent(f);

        faculty.insertFaculty(g);
        faculty.insertFaculty(h);
        faculty.insertFaculty(i);
        faculty.insertFaculty(j);
        faculty.insertFaculty(k);
        faculty.insertFaculty(l);

        students.displayStudentTree(students);
        faculty.displayFacultyTree(faculty);
        
        ChainedHashTable studentHash = new ChainedHashTable(1000);
        ChainedHashTable facultyHash = new ChainedHashTable(1000);

        studentHash.put(a.last4Id(a), a);
        studentHash.put(b.last4Id(b), b);
        studentHash.put(c.last4Id(c), c);
        studentHash.put(d.last4Id(d), d);
        studentHash.put(e.last4Id(e), e);
        studentHash.put(f.last4Id(f), f);
        System.out.println("This is the Student Hash Table");
        studentHash.printTable();
        System.out.println();

        facultyHash.put(g.last4Id(g), g);
        facultyHash.put(h.last4Id(h), h);
        facultyHash.put(i.last4Id(i), i);
        facultyHash.put(j.last4Id(j), j);
        facultyHash.put(k.last4Id(k), k);
        facultyHash.put(l.last4Id(l), l);
        System.out.println("This is the Staff Hash Table");
        facultyHash.printTable();
        System.out.println();

    }

}

