package com.latidude99.links.repository;

import com.latidude99.links.util.RandomIdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class InMemoryMapLinkRepo implements LinkRepository {
    Map<String, String> links = new TreeMap<>();

    @Override
    public String getShortLink(String longAddress) {
        String shortAddress = RandomIdentifierGenerator.randomString(8);
        boolean unique = false;
        while(!unique){
            if(!links.containsKey(shortAddress)){
                links.put(shortAddress, longAddress);
                unique = true;
            }
            else
                shortAddress = RandomIdentifierGenerator.randomString(8);
        }
        System.out.println("Saved as: " + shortAddress);
        System.out.println("links size: " + links.size());
        return shortAddress;
    }

    @Override
    public String getOriginalLink(String shortAddress) {
        String original = links.get(shortAddress);
        System.out.println("Looking for: " + shortAddress);
        System.out.println("links size: " + links.size());
        if(original != null)
            return original;
        else
            return "";


    }

}
