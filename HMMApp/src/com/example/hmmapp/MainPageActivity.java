package com.example.hmmapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainPageActivity extends Activity {

	String selectedWorkout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		//set the items in the workout listview
		final ListView workoutList = (ListView) findViewById(R.id.listView_workouts);
		
		//set up a click event for the workout listview.
		workoutList.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
		    @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
		    { 
		    	//Get the workout that was selected from the list view.
		    	selectedWorkout =(String) (workoutList.getItemAtPosition(position));
		    	
		    	//Remove the start page
		    	findViewById(R.id.startPage).setVisibility(View.GONE);
		    	
		    	//Based on the selection, make the appropriate workout information page visible
		    	CreateWorkoutInformationPage();
		    	
		    }
		});
		
		//get the buttons from each workout information page
		final Button HillWorkoutStartButton = (Button) findViewById(R.id.btnStartHillWorkout);
		final Button SteadyWorkoutStartButton = (Button) findViewById(R.id.btnStartSteadyWorkout);
		final Button RandomWorkoutStartButton = (Button) findViewById(R.id.btnStartRandomWorkout);
		
		//Create an on click event to get the input workout information and start the workout
		View.OnClickListener WorkoutButtonClickListener = new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Get information
				switch (v.getId()){
					case R.id.btnStartHillWorkout:{
						
						//Hide the Hill Workout Info Page and show the Workout Page
						findViewById(R.id.HillWorkoutInfoPage).setVisibility(View.GONE);
	                 break;
					}
					case R.id.btnStartSteadyWorkout:{
						
						//Hide the Steady Workout Info Page and show the Workout Page
						findViewById(R.id.SteadyWorkoutInfoPage).setVisibility(View.GONE);
		                 break;
					}
					case R.id.btnStartRandomWorkout:{
						
						//Hide the Random Workout Info Page and show the Workout Page
						findViewById(R.id.RandomWorkoutInfoPage).setVisibility(View.GONE);
		                 break;
					}
				}
				
				//Show the Workout Page
				findViewById(R.id.WorkoutPage).setVisibility(View.VISIBLE);
				
			}
			
		};
		
		HillWorkoutStartButton.setOnClickListener(WorkoutButtonClickListener);
		SteadyWorkoutStartButton.setOnClickListener(WorkoutButtonClickListener);
		RandomWorkoutStartButton.setOnClickListener(WorkoutButtonClickListener);
	}
	
	public void CreateWorkoutInformationPage(){
		//If Hill was selected from the list, show the Hill Workout Page
    	if(selectedWorkout.equals("Hill"))
    	{
    		findViewById(R.id.HillWorkoutInfoPage).setVisibility(View.VISIBLE);
    	}
    	//If Steady was selected from the list, show the Steady Workout Page
    	else if(selectedWorkout.equals("Steady"))
    	{
    		findViewById(R.id.SteadyWorkoutInfoPage).setVisibility(View.VISIBLE);
    	}
    	//If Random was selected from the list, show the Random Workout Page
    	else
    	{
    		findViewById(R.id.RandomWorkoutInfoPage).setVisibility(View.VISIBLE);
    	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
