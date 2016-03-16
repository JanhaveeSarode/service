package com.prokabaddi.app;

import java.util.ArrayList;

import com.prokabaddi.model.Game;
import com.prokabaddi.model.Teams;

public class Scheduler
{
    public String[][] rounds;

    //  round robin schedule method
    public String[][] schedule(ArrayList<Teams> list)
    {

        this.rounds = new String[(list.size() - 1) * 2][(list.size() / 2)];

        for (int round = 0; round < (list.size() - 1) * 2; round++)
        {
            for (int match = 0; match < (list.size() / 2); match++)
            {
                Game game = new Game();

                game.teamHome = list.get((round + match) % (list.size() - 1));
                game.teamAway = list.get((list.size() - 1 - match + round) % (list.size() - 1));
                

                // Last team stays in the same place while the others rotate around it.
                if (match == 0)
                {
                    game.teamAway = list.get(list.size() - 1);
                }

                // from rounds half interchange the position of teams in rounds, to get both home and away matches     
                String mixedRounds;
                if (round < (list.size() - 1))
                {
                    mixedRounds = (game.teamHome + " vs " + game.teamAway);
                }
                else
                //interchange the place of teams from half ((teamList.size() - 1)
                {
                    mixedRounds = (game.teamAway + " vs " + game.teamHome);
                }

                rounds[round][match] = mixedRounds;
            }
        }
        return rounds;
    }

}
