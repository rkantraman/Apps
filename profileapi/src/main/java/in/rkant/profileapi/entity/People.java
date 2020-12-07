package in.rkant.profileapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class People {

	
	    @Id
	    @GeneratedValue
	    private Long id;
	    private Integer age;
	    private String name;
	    @Column(name = "nick_name")
	    private String nickName;
	    private String company;
	    private Date birthday;
	    private boolean married;
//	    @OneToOne(cascade = ALL)
//	    @JoinColumn(name = "id_card_id")
//	    private IdCard idCard;
//	    @OneToMany(cascade = ALL)
//	    private Set<Phone> phones = new HashSet<Phone>();
//	    @ManyToMany(cascade = ALL, fetch = FetchType.LAZY)
//	    private Set<Address> addresses = new HashSet<Address>();
	    
	    
	    
	    public People() {}
	    public People(Integer age, String name, String nickName, String company, Date birthday, boolean married) {
	    	this.age = age;
	    	this.name = name;
	    	this.nickName = nickName;
	    	this.company = company;
	    	this.birthday = birthday;
	    	this.married = married;
	    }
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public boolean isMarried() {
			return married;
		}
		public void setMarried(boolean married) {
			this.married = married;
		}
	
	
	
	
	
	
	
	
	
	
	
	

}

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String name;
//	private String city;
	