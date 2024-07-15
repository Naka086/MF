package com.example.MF.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "fresher")
@Data
public class Fresher extends User{
    @OneToMany(mappedBy = "fresher")
    private List<Result> results;
}
