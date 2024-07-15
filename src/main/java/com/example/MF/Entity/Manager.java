package com.example.MF.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "manager")
@Data
public class Manager extends User{
}
