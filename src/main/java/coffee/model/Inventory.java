package coffee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="inventorytab")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@ToString
@DynamicUpdate
@DynamicInsert
public class Inventory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pid")
    private Long id;

    private String itemName;

    private int units;

    public Inventory(String itemName, int units) {
        super();
        this.itemName = itemName;
        this.units = units;
    }

    public Inventory() {
        super();
    }


}
