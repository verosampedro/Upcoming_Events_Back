package VeroSlaves.Upcoming_Events_Back.cities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import VeroSlaves.Upcoming_Events_Back.events.Event;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_city")
    private Long id;

    @Column
    private String city;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "city", cascade=CascadeType.ALL)
    private Set<Event> events;
}
