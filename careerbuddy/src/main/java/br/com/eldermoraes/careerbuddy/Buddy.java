package br.com.eldermoraes.careerbuddy;

import java.io.Serializable;
import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

/**
 *
 * @author eldermoraes
 */
@Entity(value = "BUDDY")
public class Buddy implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private Double salary;
    
    public Buddy(){
        
    }

    public Buddy(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Buddy)) {
            return false;
        }
        Buddy other = (Buddy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.eldermoraes.careerbuddy.Buddy[ id=" + id + " ]";
    }
    
    public static Buddy of (Enums.Buddy buddy, Double salary){
        return new Buddy(buddy.name(), salary);
    }

    
}
