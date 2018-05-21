package service;

import Dao.JPA;
import Dao.ProfileDao;
import Models.Message;
import Models.Profile;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

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
    public Profile findById(long id) {
            return profileDao.find(id);
        }

    public Profile findByName(String name) {
        return profileDao.findByName(name);
    }
    
    public Profile findByUsername(String username) {
        return profileDao.findByUsername(username);
    }
    
    public List<Message> searchMessages(String searchTerm){
        return profileDao.search(searchTerm);
    }
    /**
     *
     */
    public ProfileService() {
        }

    }
