package com.deitel.final_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import java.util.Random;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity 
{
	
	private TextView questionOneTextView;
	private TextView questionTwoTextView;
	private TextView questionThreeTextView;
	private EditText questionOneEditText;
	private EditText questionTwoEditText;
	private EditText questionThreeEditText;
	private Button submitButton;
	private Button resetButton;
	private TextView correctTextView;
	private ImageView star1;
	private ImageView star2;
	private ImageView star3;
	private int correctAnswer;
	private int first;
	private int second;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		questionOneTextView = (TextView) findViewById(R.id.questionOneTextView);
		questionTwoTextView = (TextView) findViewById(R.id.questionTwoTextView);
		questionThreeTextView = (TextView) findViewById(R.id.questionThreeTextView);
		
		questionOneEditText = (EditText) findViewById(R.id.questionOneEditText);
		questionTwoEditText = (EditText) findViewById(R.id.questionTwoEditText);
		questionThreeEditText = (EditText) findViewById(R.id.questionThreeEditText);
		
		correctTextView = (TextView) findViewById(R.id.correctTextView);
		
		submitButton = (Button) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(submitButtonListener);
		
		resetButton = (Button) findViewById(R.id.resetButton);
		resetButton.setOnClickListener(resetButtonListener);
		startQuiz();
		
		star1 = (ImageView) findViewById(R.id.star1);
		star2 = (ImageView) findViewById(R.id.star2);
		star3 = (ImageView) findViewById(R.id.star3);
		
		
	}
	private void startQuiz()
	{
		Random rand = new Random(11);
		
		correctAnswer = 0;
		first = rand.nextInt();
		second = rand.nextInt();
		
		questionOneTextView.setText(first+" + "+second+" =");
		questionTwoTextView.setText(first+" - "+second+" =");
		questionThreeTextView.setText(first+" * "+second+" =");
		
		questionOneEditText.setText("");
		questionTwoEditText.setText("");
		questionThreeEditText.setText("");
		correctTextView.setText("");
		
		star1.setVisibility(View.INVISIBLE);
		star2.setVisibility(View.INVISIBLE);
		star3.setVisibility(View.INVISIBLE);
	}
	
	private OnClickListener resetButtonListener = new OnClickListener()
	{

		@Override
		public void onClick(View v) 
		{
			startQuiz();
		}
	};
	
	private OnClickListener submitButtonListener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			String questionone = questionOneEditText.getText().toString();
			String questiontwo = questionTwoEditText.getText().toString();
			String questionthree = questionThreeEditText.getText().toString();
			
			if( (first+second)== Integer.parseInt(questionone))
			{
				correctAnswer++;	
			}
			if( (first-second)== Integer.parseInt(questiontwo))
			{
				correctAnswer++;	
			}
			if( (first*second)== Integer.parseInt(questionthree))
			{
				correctAnswer++;	
			}
			
			correctTextView.setText("You got "+correctAnswer+" questions correct!");
			
			
			if (correctAnswer == 1)
			{
				star1.setVisibility(View.VISIBLE);
			}
			if (correctAnswer == 2)
			{
				star1.setVisibility(View.VISIBLE);
				star2.setVisibility(View.VISIBLE);
			}
			if (correctAnswer == 3)
			{
				star1.setVisibility(View.VISIBLE);
				star2.setVisibility(View.VISIBLE);
				star3.setVisibility(View.VISIBLE);
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
