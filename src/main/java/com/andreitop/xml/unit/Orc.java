package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("trall")
public class Orc implements Unit {

    private Mount mount;
    private String weapon;
    private int colorCode;

    @Autowired
    public Orc(@Qualifier("frostWolf") Mount mount) {
        this.mount = mount;
    }

    @Override
    public void mountMove() {
        mount.move();
    }

    public String getWeapon() {
        return weapon;
    }

    @Value("furryaxe")
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getColorCode() {
        return colorCode;
    }

    @Value("#{9}")
    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public Mount getMount() {
        return mount;
    }
}




