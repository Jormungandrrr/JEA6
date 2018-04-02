package service;

import Dao.JPA;
import Dao.ProfileDao;
import Models.Profile;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author Jorrit
 */
@Stateless
public class ProfileService {

        @Inject @JPA
        private ProfileDao profileDao;

    /**
     *
     * @param P
     */
    public void addprofile(Profile P) {
            profileDao.create(P);
        }

    /**
     *
     * @param P
     */
    public void removeProfile(Profile P) {
            profileDao.remove(P);
        }

    /**
     *
     * @return
     */
    public ArrayList<Profile> getProfiles() {
            return profileDao.getProfiles();
        }
        
    /**
     *
     * @param id
     * @return
     */
    public Profile findById(int id) {
            return profileDao.find(id);
        }

    /**
     *
     */
    public ProfileService() {
        }

    }
