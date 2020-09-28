package com.dinitha.testapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "smartReadings")
@Getter
@Setter

public class SmartReading {
    @Id
    @SequenceGenerator(name="generator", sequenceName="SMART_READING_SEQ",allocationSize=1)
    @GeneratedValue(generator = "generator")
    @Column(name = "reading_id")
    private Long readingId;

    @Column(name = "deviceId")
    private String deviceId;

    @Column(name = "level")
    private Long level;
}
