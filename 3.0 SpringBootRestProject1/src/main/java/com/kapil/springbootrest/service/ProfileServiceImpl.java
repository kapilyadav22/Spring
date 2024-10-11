package com.kapil.springbootrest.service;

import com.kapil.springbootrest.component.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    Profile kapil = new Profile(1, "Kapil", "Yadav", "kapilyadav22", "singhkapil347@gmail.com",123, "Male", 26);
    Profile profile1 = new Profile(2, "Amit", "Sharma", "amitsharma11", "amitsharma@gmail.com", 456, "Male", 30);
    Profile profile2 = new Profile(3, "Riya", "Verma", "riya.verma21", "riyaverma@gmail.com", 789, "Female", 24);
    Profile profile3 = new Profile(4, "Anjali", "Patel", "anjalipatel", "anjalipatel@gmail.com", 101, "Female", 28);
    Profile profile4 = new Profile(5, "Rahul", "Kumar", "rahul.kumar89", "rahulkumar89@gmail.com", 234, "Male", 32);
    Profile profile5 = new Profile(6, "Priya", "Singh", "priyasingh23", "priyasingh23@gmail.com", 567, "Female", 27);


    List<Profile> profileList = new ArrayList<>();

    @Override
    public Profile getProfile(int id) {
        return kapil;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profile;
    }

    @Override
    public List<Profile> deleteProfile(int id) {
    if(!profileList.isEmpty()) {
       profileList.removeIf(profile -> profile.getId() == id);
       return profileList;
        }
        return null;
    }

    @Override
    public Profile createProfile(Profile profile) {
        profileList.add(profile);
//        return "Data inserted successfully";
        return profile;
    }
    @Override
    public List<Profile> getAllProfiles() {
        profileList.clear();
        profileList.addAll(Arrays.asList(kapil,profile1, profile2, profile3, profile4, profile5));
        return profileList;
    }
}
