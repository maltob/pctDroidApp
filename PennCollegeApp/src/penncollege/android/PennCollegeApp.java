package penncollege.android;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class PennCollegeApp extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	    	  
    	  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //setContentView(R.layout.page1);
        
        ImageView myImageView= (ImageView)findViewById(R.id.widget31);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.boot);
        myImageView.startAnimation(myFadeInAnimation); //Set animation to your ImageVie
       
       
       
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
        	
        	public void run() {

        		

        }

        }, 10000);

        
       
    } // End onCreate(Bundle savedInstanceState)
    
   

    
    
    
    
} // End class PennCollegeApp



