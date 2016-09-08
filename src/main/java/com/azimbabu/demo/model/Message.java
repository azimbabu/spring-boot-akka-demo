package com.azimbabu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by azim on 9/7/16.
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private final long id;
    private final String payload;
}
