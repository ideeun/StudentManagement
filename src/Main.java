import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private Set<String> courses;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new HashSet<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", Возраст: " + age + ", Курсы: " + courses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Set<String> getCourses() {
        return courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }
}

class StudentManagement {
    private Map<Integer, Student> students;

    public StudentManagement() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        students.remove(id);
    }

    public void updateStudent(int id, String name, int age, Set<String> courses) {
        Student student = students.get(id);
        if (student != null) {
            students.put(id, new Student(id, name, age));
            for (String course : courses) {
                students.get(id).addCourse(course);
            }
        }
    }

    public void printAllStudents() {
        List<Student> sortedStudents = new ArrayList<>(students.values());

        Iterator<Student> iterator = sortedStudents.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Student findStudentById(int id) {
        return students.get(id);
    }

    public void printStudentsByCourse(String course) {
        for (Student student : students.values()) {
            if (student.getCourses().contains(course)) {
                System.out.println(student);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagement mn = new StudentManagement();

        Student s1 = new Student(1, "Александр Нырко", 19);
        Student s2 = new Student(2, "Бектур Кенжебаев", 20);
        Student s3 = new Student(3, "Эмир Айтмурзаев", 19);
        Student s4 = new Student(4, "Талант Матаев", 18);

        s1.addCourse("Java");
        s2.addCourse("Java");
        s3.addCourse("Python");
        s4.addCourse("C++");

        mn.addStudent(s1);
        mn.addStudent(s2);
        mn.addStudent(s3);
        mn.addStudent(s4);

        System.out.println("Все студенты:");
        mn.printAllStudents();

        System.out.println("Поиск студента с ID 2:");
        System.out.println(mn.findStudentById(2));

        System.out.println("Студенты, записанные на курс Java:");
        mn.printStudentsByCourse("Java");

        Set<String> newCourses = new HashSet<>(Arrays.asList("C++", "Java"));
        mn.updateStudent(3, "Эмир Айтмурзаев", 20, newCourses);

        System.out.println("Все студенты после обновления:");
        mn.printAllStudents();

        mn.removeStudent(2);

        System.out.println("Все студенты после удаления:");
        mn.printAllStudents();
    }
}
