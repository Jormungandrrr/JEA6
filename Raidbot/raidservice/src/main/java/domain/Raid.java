/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.*;

/**
 *
 * @author Jorrit
 */
public class Raid {
    String Gymname;
    String Boss;
    Point Location;

    public Raid(String gymname, String boss, Point location) {
        Gymname = gymname;
        Boss = boss;
        Location = location;
    }

    public String getGymname() {
        return Gymname;
    }

    public void setGymname(String gymname) {
        Gymname = gymname;
    }

    public String getBoss() {
        return Boss;
    }

    public void setBoss(String boss) {
        Boss = boss;
    }

    public Point getLocation() {
        return Location;
    }

    public void setLocation(Point location) {
        Location = location;
    }
}
