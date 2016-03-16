package com.prokabaddi.model;

public class Teams
{
    
 // the name of the team object
    private String teamName;    


    public Teams (String name){
        this.teamName =name;
        }

    public String getName(){
        return teamName;
    }

    @Override
    public String toString(){
        return teamName;
    }
    }


