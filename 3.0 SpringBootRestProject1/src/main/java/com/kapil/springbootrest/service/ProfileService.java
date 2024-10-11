package com.kapil.springbootrest.service;

import com.kapil.springbootrest.component.Profile;

import java.util.List;

public interface ProfileService {
    Profile getProfile(int id);
    Profile updateProfile(Profile profile);
    List<Profile> deleteProfile(int id);
    Profile createProfile(Profile profile);
    List<Profile> getAllProfiles();
}
