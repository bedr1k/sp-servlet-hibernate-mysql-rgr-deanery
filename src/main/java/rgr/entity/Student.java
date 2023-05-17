package rgr.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student", catalog="deanery")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private StudentsGroup group;
    private List<Exam> exams;

    public Student() {
    }
    public Student(long id, String firstName, String secondName, String patronymic, StudentsGroup group) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.group = group;
    }
    public Student(String firstName, String secondName, String patronymic, StudentsGroup group) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.patronymic = patronymic;
		this.group = group;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public long getId() {
        return id;
    }
    @OneToMany(fetch=FetchType.EAGER, mappedBy="student")
    public List<Exam> getExams() {
        return exams;
    }
    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name="first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name="second_name", nullable = false)
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    @Column(name="patronymic", nullable = false)
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="group_id", nullable=false)
    public StudentsGroup getGroup() {
        return group;
    }
    public void setGroup(StudentsGroup group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                "'}";
    }
}
