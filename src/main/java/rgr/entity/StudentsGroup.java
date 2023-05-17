package rgr.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students_group", catalog="deanery")
public class StudentsGroup implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
    private String name;
    private long course;
    private List<Student> students;

    public StudentsGroup() {
    }
    public StudentsGroup(long id, String name, long course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
    public StudentsGroup(String name, long course) {
		super();
		this.name = name;
		this.course = course;
	}
	@OneToMany(fetch=FetchType.EAGER, mappedBy="group")
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="course", nullable = false)
    public long getCourse() {
        return course;
    }
    public void setCourse(long course) {
        this.course = course;
    }
    @Override
    public String toString() {
        return "StudentsGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
