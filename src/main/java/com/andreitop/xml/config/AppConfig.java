package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import com.andreitop.xml.unit.Troll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
@PropertySource("classpath:config/heroes.properties")
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean("dateFormatter")
    public SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat("dd-mm-yyyy");
    }

    @Bean("frostWolf")
    public Mount getWolf() {
        return new Wolf();
    }

    @Bean("shadowTiger")
    public Mount getTiger() {
        return new Tiger();
    }


    @Bean("trollMountMap")
    public HashMap getTrollMountMap() {
        HashMap<String, Mount> map = new HashMap<>();
        map.put("m1", getWolf());
        map.put("m2", getTiger());
        return map;
    }

    @Bean("trollMountSet")
    public Set getTrollMountSet() {
        Set<Mount> mounts = new HashSet<>();
        mounts.add(getWolf());
        mounts.add(getTiger());
        return mounts;
    }

    @Bean("zulJin")
    public Troll getTroll() throws ParseException {
        Troll troll = new Troll();
        troll.setColorCode(ThreadLocalRandom.current().nextInt(1, 10));
        troll.setCreationDate(new SimpleDateFormat("dd/mm/yyyy").parse(env.getProperty("character.created")));
        List<Mount> listOfMounts = new ArrayList<>();
        listOfMounts.add(Troll.DEFAULT_MOUNT);
        listOfMounts.add(null);
        listOfMounts.add(getTiger());
        troll.setListOfMounts(listOfMounts);
        troll.setSetOfMounts(getTrollMountSet());
        troll.setMapOfMounts(getTrollMountMap());
        return troll;
    }
}
