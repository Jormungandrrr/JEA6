/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JPA;
import dao.RaidDao;
import javax.inject.Inject;

/**
 *
 * @author Jorrit
 */
public class RaidService {
     @Inject @JPA
     private RaidDao dao;
     
     
}
