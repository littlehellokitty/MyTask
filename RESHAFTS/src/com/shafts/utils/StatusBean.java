/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shafts.utils;

import java.io.Serializable;

/**
 *
 * @author Little-Kitty
 * @date 2015-4-9 16:16:02
 */
public class StatusBean implements Serializable{

    private static final long serialVersionUID=1L;
    
    public String getAuthorStatus() {
        return authorStatus;
    }

    public void setAuthorStatus(String authorStatus) {
        this.authorStatus = authorStatus;
    }

    public String getUsability() {
        return usability;
    }

    public void setUsability(String usability) {
        this.usability = usability;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }
    private String authorStatus;
    private String usability;
    private String availableDate;
    
    

}