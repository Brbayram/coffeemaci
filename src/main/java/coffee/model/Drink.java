package coffee.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@Table(name="drink")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Drink {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="drinkpid")
    private Long id;


    /**
     * Name of the drink.
     */
    private String name;

    /**
     * Cost for the drink.
     */
    private Double cost;

    /**
     * Map containing ingredients required for making the drink along with the quantity.
     */

    @ElementCollection
    @CollectionTable(name="drink_ingredients", joinColumns=@JoinColumn(name="eidFk"))
//	@MapKeyColumn(name="key")
    @Column(name="value")
    private Map<String, Integer> ingredients = new HashMap<>();


    private String filePath;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Map<String, Integer> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }




    //	Dated for auditing
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
//	private LocalDateTime createdAt;
    private Date createdAt;


    @LastModifiedDate
//	private LocalDateTime lastModifiedAt;
    private Date lastModifiedAt;


}

