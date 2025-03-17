package edu.rims.pro_connect.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProjectRequest> projectRequests;

    public void addProjectRequest(ProjectRequest projectRequest) {
        if (getProjectRequests() == null) {
            setProjectRequests(new ArrayList<>());
        }
        getProjectRequests().add(projectRequest);
        projectRequest.setClient(this);
    }
}
