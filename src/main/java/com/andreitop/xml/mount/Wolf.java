package com.andreitop.xml.mount;

import org.springframework.stereotype.Component;

@Component("frostWolf")
public class Wolf implements Mount {
    public void move() {
        System.out.println("I'm a wolf!");
    }
}
