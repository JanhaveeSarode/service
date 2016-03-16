package com.prokabaddi.model;

public class Game
{
    public Teams teamHome;
    public Teams teamAway;
    public String day;
    
    

    public Teams getTeamHome()
    {
        return teamHome;
    }



    public void setTeamHome(Teams teamHome)
    {
        this.teamHome = teamHome;
    }



    public Teams getTeamAway()
    {
        return teamAway;
    }



    public void setTeamAway(Teams teamAway)
    {
        this.teamAway = teamAway;
    }



    public String getDay()
    {
        return day;
    }



    public void setDay(String day)
    {
        this.day = day;
    }
}
