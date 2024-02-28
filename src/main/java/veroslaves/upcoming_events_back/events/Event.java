package veroslaves.upcoming_events_back.events;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.users.User;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_event")
    private Long id;

    @Column
    private String event_title;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date start_date;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date finish_date;

    @Column(name = "event_image")
    private String event_image;

    @Column
    private Long max_participants;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "events")
    Set<User> users;
    
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String cityName;

    public Event() {
    }

   

    public Event(String event_title, Date start_date, Date finish_date, String event_image, Long max_participants,
            String description, City city, Set<User> users, String cityName) {
        this.event_title = event_title;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.event_image = event_image;
        this.max_participants = max_participants;
        this.description = description;
        this.city = city;
        this.users = users;
        this.cityName = cityName;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public Long getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(Long max_participants) {
        this.max_participants = max_participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public String getCityName() {
        return cityName;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    
}