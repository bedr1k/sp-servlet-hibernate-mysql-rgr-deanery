package rgr.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="exam", catalog="deanery")
public class Exam implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
    private int grade;
    private Date examDay;
    private Discipline discipline;
    private Student student;

    public Exam() {
    }
    public Exam(long id, int grade, Date examDay, Discipline discipline, Student student) {
        this.id = id;
        this.grade = grade;
        this.examDay = examDay;
        this.discipline = discipline;
        this.student = student;
    }
    public Exam(int grade, Date examDay, Discipline discipline, Student student) {
		super();
		this.grade = grade;
		this.examDay = examDay;
		this.discipline = discipline;
		this.student = student;
	}
	public Exam(long id, int grade, Discipline discipline, Student student) {
		super();
		this.id = id;
		this.grade = grade;
		this.discipline = discipline;
		this.student = student;
	}
	public Exam(int grade, Discipline discipline, Student student) {
		super();
		this.grade = grade;
		this.discipline = discipline;
		this.student = student;
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
    @Column(name="grade", nullable = false)
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="exam_day", length=10)
    public Date getExamDay() {
        return examDay;
    }
    public void setExamDay(Date examDay) {
        this.examDay = examDay;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="discipline_id", nullable=false)
    public Discipline getDiscipline() {
        return discipline;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="student_id", nullable=false)
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", grade=" + grade +
                ", examDay=" + examDay +
                ", discipline='" + discipline.getName() +
                "', student=" + student +
                '}';
    }
}
