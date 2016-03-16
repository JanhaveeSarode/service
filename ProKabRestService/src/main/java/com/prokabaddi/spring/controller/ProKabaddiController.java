package com.prokabaddi.spring.controller;

import java.util.ArrayList;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prokabaddi.app.Scheduler;
import com.prokabaddi.model.Teams;

/**
 * Handles requests for the ProKabaddi scheduler service.
 */
@Controller
public class ProKabaddiController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProKabaddiController.class);
	
	
	public static ArrayList<Teams> teamList = new ArrayList<Teams>();

    public static Scheduler        schedule = new Scheduler();
	
	
	
	@RequestMapping(value = "/rest/schd/{no}", method = RequestMethod.GET)
	public @ResponseBody String getMatchSchedule(@PathVariable("no") int no) {
		logger.info("number of teams="+no);
		JSONObject jsonObject = new JSONObject();
        createDefaultList(no);
        String[][] fixtures = schedule.schedule(teamList);
       // logger.info("fixtures: "+fixtures.toString());
       jsonObject.put("fixtures", fixtures);
        String result = jsonObject.toString();
        
        return result;
	}
	
	 private ArrayList<Teams> createDefaultList(int noOfTeams)
	    {
	        for (int i = 0; i < noOfTeams; i++)
	        {
	            teamList.add(new Teams("Team " + (i + 1)));
	        }
	        return null;
	    }
	
}
