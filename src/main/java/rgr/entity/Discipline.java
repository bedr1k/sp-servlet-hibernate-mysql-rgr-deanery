package rgr.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="discipline", catalog="deanery")
public class Discipline implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
    private String name;
    private List<Exam> exams;
    
    public Discipline() {
    }
    public Discipline(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Discipline(long id, String name, List<Exam> exams) {
        this.id = id;
        this.name = name;
        this.exams = exams;
    }
    public Discipline(String name) {
		super();
		this.name = name;
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
    @OneToMany(fetch=FetchType.EAGER, mappedBy="discipline")
    public List<Exam> getExams() {
        return exams;
    }
    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
