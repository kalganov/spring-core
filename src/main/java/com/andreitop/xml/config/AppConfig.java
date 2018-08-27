package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import com.andreitop.xml.unit.Human;
import com.andreitop.xml.unit.Orc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
public class AppConfig {
    @Bean("frostWolf")
    public Mount getWolf() {
        return new Wolf();
    }

    @Bean("trall")
    public Orc getOrc() {
        Orc orc = new Orc(getWolf());
        orc.setColorCode(9);
        orc.setWeapon("furryAxe");
        return orc;
    }
}
