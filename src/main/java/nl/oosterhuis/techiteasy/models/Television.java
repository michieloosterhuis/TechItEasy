package nl.oosterhuis.techiteasy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
//    private String brand;
//    private String name;
//    private  Double price;
//    private Double availableSize;
//    private Double refreshRate;
//    private  String screenType;
//    private String screenQuality;
//    private Boolean smartTv;
//    private Boolean wifi;
//    private Boolean voiceControl;
//    private Boolean hdr;
//    private Boolean bluetooth;
//    private Boolean ambiLight;
//    private Integer originalStock;
//    private Integer sold;

    public Television() {
    }

    public Television(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
