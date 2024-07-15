package com.example.MF.Entity;

import jakarta.persistence.*;

public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float avg;
    private String note;

    public Result(Long id, Float avg, String note) {
        this.id = id;
        this.avg = avg;
        this.note = note;
    }

    @ManyToOne
    @JoinColumn(name = "fresher_id", nullable = false)
    private Fresher fresher;
}
