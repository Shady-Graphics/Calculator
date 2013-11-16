package com.mad.mycalculatormcn;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	// button variables - will hold ref to buttons and the display
	private View bckgrd = null;
	private EditText txtCalc = null;
	private TextView txtMem = null;
	private Button btnZero = null;
	private Button btnOne = null;
	private Button btnTwo = null;
	private Button btnThree = null;
	private Button btnFour = null;
	private Button btnFive = null;
	private Button btnSix = null;
	private Button btnSeven = null;
	private Button btnEight = null;
	private Button btnNine = null;
	private Button btnPlus = null;
	private Button btnMinus = null;
	private Button btnMultiply = null;
	private Button btnDivide = null;
	private Button btnEquals = null;
	private Button btnC = null;
	private Button btnDecimal = null;
	private Button btnMC = null;
	private Button btnMR = null;
	private Button btnMM = null;
	private Button btnMP = null;
	private Button btnBS = null;
	private Button btnPerc = null;
	private Button btnSqrRoot = null;
	private Button btnPM = null;

	// for use with calculation
	private double num = 0;
	// for use with the memory button
	private double memNum = 0;
	// operators
	// 0 = nothing, 1 = plus, 2 = minus, 3 =
	// multiply, 4 = divide
	private int operator = 1;

	// hold state of display i.e after an operator has been pressed
	private boolean readyToClear = false;
	private boolean hasChanged = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_portait);
		initControls();
		initScreenLayout();
		reset();
	}

	// get resource id and sets event handlers for all gui elements
	private void initControls() {
		// getting and storing resource ids
		bckgrd = findViewById(R.id.layoutLinear);

		txtCalc = (EditText) findViewById(R.id.txtCalc);
		txtMem = (TextView) findViewById(R.id.memTextView);
		
		btnZero = (Button) findViewById(R.id.btnZero);
		btnOne = (Button) findViewById(R.id.btnOne);
		btnTwo = (Button) findViewById(R.id.btnTwo);
		btnThree = (Button) findViewById(R.id.btnThree);
		btnFour = (Button) findViewById(R.id.btnFour);
		btnFive = (Button) findViewById(R.id.btnFive);
		btnSix = (Button) findViewById(R.id.btnSix);
		btnSeven = (Button) findViewById(R.id.btnSeven);
		btnEight = (Button) findViewById(R.id.btnEight);
		btnNine = (Button) findViewById(R.id.btnNine);
		btnPlus = (Button) findViewById(R.id.btnPlus);
		btnMinus = (Button) findViewById(R.id.btnMinus);
		btnMultiply = (Button) findViewById(R.id.btnMultiply);
		btnDivide = (Button) findViewById(R.id.btnDivide);
		btnEquals = (Button) findViewById(R.id.btnEquals);
		btnC = (Button) findViewById(R.id.btnC);
		btnDecimal = (Button) findViewById(R.id.btnDecimal);
		btnMC = (Button) findViewById(R.id.btnMC);
		btnMR = (Button) findViewById(R.id.btnMR);
		btnMM = (Button) findViewById(R.id.btnMM);
		btnMP = (Button) findViewById(R.id.btnMP);
		btnBS = (Button) findViewById(R.id.btnBS);
		btnPerc = (Button) findViewById(R.id.btnPerc);
		btnSqrRoot = (Button) findViewById(R.id.btnSqrRoot);
		btnPM = (Button) findViewById(R.id.btnPM);

		// setting on click listeners
		btnZero.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(0);
			}
		});
		btnOne.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(1);
			}
		});
		btnTwo.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(2);
			}
		});
		btnThree.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(3);
			}
		});
		btnFour.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(4);
			}
		});
		btnFive.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(5);
			}
		});
		btnSix.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(6);
			}
		});
		btnSeven.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(7);
			}
		});
		btnEight.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(8);
			}
		});
		btnNine.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleNumber(9);
			}
		});
		btnPlus.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleEquals(1);
			}
		});
		btnMinus.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleEquals(2);
			}
		});
		btnMultiply.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleEquals(3);
			}
		});
		btnDivide.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleEquals(4);
			}
		});
		btnEquals.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleEquals(0);
			}
		});
		btnC.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				reset();
			}
		});
		btnDecimal.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleDecimal();
			}
		});
		btnPM.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handlePlusMinus();
			}
		});
		btnMC.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				memNum = 0;
				txtMem.setText("");
			}
		});
		btnMR.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				if(memNum==0.0){
					
				}
				else{
				setValue(Double.toString(memNum));
				
				txtMem.setText("M:" + Double.toString(memNum));
				readyToClear=true;
				}
			}
		});
		btnMM.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				memNum = memNum
						- Double.parseDouble(txtCalc.getText().toString());
				txtMem.setText("M:" + Double.toString(memNum));
				operator = 0;
			}
		});
		btnMP.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				memNum = memNum
						+ Double.parseDouble(txtCalc.getText().toString());
				txtMem.setText("M:" + Double.toString(memNum));
				operator = 0;
			}
		});
		btnBS.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				handleBackspace();
			}
		});
		btnSqrRoot.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				setValue(Double.toString(Math.sqrt(Double.parseDouble(txtCalc
						.getText().toString()))));
			}
		});
		btnPerc.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				setValue(Double.toString(num * (0.01 * Double.parseDouble(txtCalc.getText().toString()))));
			}
		});

	}// end of initControls

	// method to delete the last digit of the displayed number
	protected void handleBackspace() {
		// if not ready to clear - i.e no operation has been pressed
		if (!readyToClear) {
			// get the text on the display
			String txt = txtCalc.getText().toString();
			// check if the text got from display is has more than 1 number
			// if it has more than 1
			if (txt.length() > 0) {
				// use the substring method to create a new string with the last
				// number outside the string
				// appearing deleted
				txt = txt.substring(0, txt.length() - 1);
				// if the display has 1 number or less
				if (txt.equals("")) {
					// set display equal to 0
					txt = "0";
				}
				// put the new string back in the display
				txtCalc.setText(txt);
				// move the cursor to the end of the string
				txtCalc.setSelection(txt.length());
			}
		}
	}// end of handleBackspace

	// method to setValue of display - used with the MR, sqroot and perc buttons
	// (after the calulation has been performed set value in display)
	protected void setValue(String value) {
		// if operator equal nothing reset gui
		if (operator == 0)
			reset();

		// change the state of ready to clear if true to false
		if (readyToClear) {
			readyToClear = false;
		}

		// update display
		txtCalc.setText(value);
		txtCalc.setSelection(value.length());

		// update hasChanged
		hasChanged = true;
		readyToClear = true;
	}

	// method to to change numbers in the display to plus or minus
	protected void handlePlusMinus() {
		// if not ready to clear
		if (!readyToClear) {
			// get what in the calulator
			String txt = txtCalc.getText().toString();
			//if not equal to zero(can't be plus or minus)
			if (!txt.equals("0")) {
				//changing - to +
				//if - is at position 0
				if (txt.charAt(0) == '-'){
					//use substring method to make a new string with the first number outside the string
					//making the number appear positive
					txt = txt.substring(1, txt.length());
				}
				//make negative by appending a - before the string
				else
					txt = "-" + txt;

				//update cursor and display with new string 
				txtCalc.setText(txt);
				txtCalc.setSelection(txt.length());
			}
		}
	}
	
	//method to handle the decimal place button
	protected void handleDecimal() {
		//if operation equals nothing reset gui
		if (operator == 0)
			reset();
		
		//if readyToClear i.e display equal zero
		if (readyToClear) {
			//add decimal point after the zero
			txtCalc.setText("0.");
			//move the cursor after the decimal place
			txtCalc.setSelection(2);
			//reset readyToChange
			readyToClear = false;
			hasChanged = true;
		}
		//if not readyToChange i.e numbers other than zero
		else {
			//get the string in display
			String txt = txtCalc.getText().toString();
			//if it does not already have a decimal point
			if (!txt.contains(".")) {
				//add decimal point to the end of the string
				txtCalc.append(".");
				hasChanged = true;
			}
		}
	}
	//reset method
	protected void reset() {
		// reset the gui and variables to original state
		num = 0;
		txtCalc.setText("0");
		txtCalc.setSelection(1);
		operator = 1;
	}
	//method to handle the operands of the calulator
	protected void handleEquals(int i) {
		if (hasChanged) {
			//use a switch case to work out which calulation to do depend on the value
			//of the operator pressed
			switch (operator) {
			//addition is 1
			case 1:
				//get text in display convert to double add to the num var and assign to itself
				num = num + Double.parseDouble(txtCalc.getText().toString());
				//finish case
				break;
			//subtraction is 2
			case 2:
				//get text in display convert to double subtract from the num var and assign to itself
				num = num - Double.parseDouble(txtCalc.getText().toString());
				//finish case
				break;
			//multiplication is 3
			case 3:
				//get text in display convert to double multiply with the num var and assign to itself
				num = num * Double.parseDouble(txtCalc.getText().toString());
				//finish case
				break;
			//division is 4
			case 4:
				//get text in display convert to double divide from the num var and assign to itself
				num = num / Double.parseDouble(txtCalc.getText().toString());
				//finish case
				break;
			}
			//convert answer to string
			String txt = Double.toString(num);
			//update display
			txtCalc.setText(txt);
			txtCalc.setSelection(txt.length());
			
			//update state variables
			readyToClear = true;
			hasChanged = false;
		}
		//update operator
		operator = i;
	}

	// method to handle number i.e. when a number is pressed
	protected void handleNumber(int i) {
		// if operator equal nothing reset gui
		if (operator == 0)
			reset();
		// get what in the display
		String txt = txtCalc.getText().toString();
		// if ready to clear
		if (readyToClear) {
			// reset the display and readyToClear
			txt = "";
			readyToClear = false;
		}
		// else if text equals zero then set txt to an empty string
		else if (txt.equals("0"))
			txt = "";
		// add the number pressed to existing text and assign it to itself
		txt = txt + Integer.toString(i);
		// update the display
		txtCalc.setText(txt);
		txtCalc.setSelection(txt.length());
		// update has changed
		hasChanged = true;
	}

	// method to set-up and style the gui
	private void initScreenLayout() {
		bckgrd.setBackgroundColor(Color.GRAY);

		// number buttons
		btnZero.setTextColor(Color.MAGENTA);
		btnOne.setTextColor(Color.MAGENTA);
		btnTwo.setTextColor(Color.MAGENTA);
		btnThree.setTextColor(Color.MAGENTA);
		btnFour.setTextColor(Color.MAGENTA);
		btnFive.setTextColor(Color.MAGENTA);
		btnSix.setTextColor(Color.MAGENTA);
		btnSeven.setTextColor(Color.MAGENTA);
		btnEight.setTextColor(Color.MAGENTA);
		btnNine.setTextColor(Color.MAGENTA);
		btnPM.setTextColor(Color.MAGENTA);
		btnDecimal.setTextColor(Color.MAGENTA);

		// operator buttons
		btnMP.setTextColor(Color.BLUE);
		btnMM.setTextColor(Color.BLUE);
		btnMR.setTextColor(Color.BLUE);
		btnMC.setTextColor(Color.BLUE);
		btnBS.setTextColor(Color.BLUE);
		btnC.setTextColor(Color.RED);
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getMenuInflater().inflate(R.menu.activity_main, menu);
	// return true;
	// }
}
