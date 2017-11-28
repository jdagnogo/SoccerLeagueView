# SoccerLeagueView

an Android lib that creates a league view.
Feel free to send me suggestions or improvements  : jdagnogo11@gmail.com

-----------------------------------------------------------------------------------------------------------------------------

# Presentation : 

 <img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/logo.png" width="300" style=" float : left;">
 
This application allows you to :
  * create a league view
  * order by points or win or others..
  * get all the results
  * you only need two or more teams to begin
  * all stat will be generated and you can have access to it.
  

# Screenshots : 

<img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/Screenshot_2017-11-28-11-30-52.png" width="300" style=" float : left;">
<img src="https://github.com/jdagnogo/tournament_lib/blob/master/screenshots/Screenshot_2017-11-28-11-46-07.png" width="300" style=" float : left;">

# How to install :

```
		allprojects {
						repositories {
							...
							maven { url 'https://jitpack.io' }
						}
					}

					
		compile 'com.github.jdagnogo:soccerleagueview:1.0'
```

# How to use :

see the example in MainActivity
```
SoccerLeagueView soccerLeagueView = (SoccerLeagueView) findViewById(R.id.soccer);
        soccerLeagueView.addTeam(teams);
        // dont forget to call this method
        // a league will start if there more than one team
        soccerLeagueView.startLeague("Premiere League");

        // add a list of matches
        matches.add(new Match(teams.get(1),teams.get(1),1,1));
        matches.add(new Match(teams.get(1),teams.get(0),1,1));
        soccerLeagueView.addMatch(matches);

        // or add a single match
        soccerLeagueView.addMatch(new Match(teams.get(1),teams.get(2),1,4));
```
