package service;

import Dao.JPA;
import Dao.ProfileDao;
import Models.Profile;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class ProfileService {

        @Inject @JPA
        private ProfileDao profileDao;

        public void addprofile(Profile P) {
            profileDao.create(P);
        }

        public void removeProfile(Profile P) {
            profileDao.remove(P);
        }

        public ArrayList<Profile> getProfiles() {
            return profileDao.getProfiles();
        }

        public ProfileService() {
        }

    }
