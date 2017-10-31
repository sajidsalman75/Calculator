package com.example.sajidsalman75.calculator_geganode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	
	//stacks to use in the calculations

        //whole statement will be in this stack
	final Stack digits = new Stack();
	
	//it will be used while calculation
        final Stack calculation = new Stack();

	//it will contains all the operators in it including brackets
        final Stack functions = new Stack();

	//it will contain the open brackets that will be removed when all the closed brackets have been placed
        final Stack brackets = new Stack();
        
	//get all the UI elements
	final TextView tvOut = (TextView) findViewById(R.id.tvOut);
        final Button btnAc = (Button) findViewById(R.id.btnAC);
        final Button btnDel = (Button) findViewById(R.id.btnDEL);
        final Button btnDiv = (Button) findViewById(R.id.btnDivide);
        final Button btn7 = (Button) findViewById(R.id.btnDigit7);
        final Button btn8 = (Button) findViewById(R.id.btnDigit8);
        final Button btn9 = (Button) findViewById(R.id.btnDigit9);
        final Button btnMul = (Button) findViewById(R.id.btnMultiply);
        final Button btn4 = (Button) findViewById(R.id.btnDigit4);
        final Button btn5 = (Button) findViewById(R.id.btnDigit5);
        final Button btn6 = (Button) findViewById(R.id.btnDigit6);
        final Button btnSub = (Button) findViewById(R.id.btnSubtraction);
        final Button btn1 = (Button) findViewById(R.id.btnDigit1);
        final Button btn2 = (Button) findViewById(R.id.btnDigit2);
        final Button btn3 = (Button) findViewById(R.id.btnDigit3);
        final Button btnAdd = (Button) findViewById(R.id.btnAddition);
        final Button btn0 = (Button) findViewById(R.id.btnDigit0);
        final Button btnDot = (Button) findViewById(R.id.btnDot);
        final Button btnBracs = (Button) findViewById(R.id.btnBrackets);
        final Button btnE = (Button) findViewById(R.id.btnDigitEqual);

	//click listener for all the digits will be like this
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                

                //check if it is empty
                if(digits.empty()){
		            //set text in the TextView
                    tvIO.setText(tvIO.getText() + btn0.getText().toString());
                    tvOut.setText(tvOut.getText() + btn0.getText().toString());
                }
                else{
                    //check if there is y on the top
                    //y means there is an operator before it or if there is a bracket
                    if (!digits.peek().toString().equals("y")){
                    //check if the input textbox is empty
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "0");
                            tvOut.setText(tvOut.getText().toString() + btn0.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn0.getText().toString());
                            tvOut.setText(tvOut.getText() + btn0.getText().toString());
                        }
                    }
                    //if there is no y on the top then it means there is a number on the top
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn0.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn0.getText().toString());
                    }
                }
                //check if there is = on the top of functions stack
		        //this = is placed in the stack when = button is pressed
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn0.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn0.getText().toString());
                }
            }
        });

	    //click listener for AC button
        btnAc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);

		        //clear every stack and textboxes
                tvIO.setText("");
                tvOut.setText("");
                digits.removeAllElements();
                calculation.removeAllElements();
                brackets.removeAllElements();
                functions.removeAllElements();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn1.getText().toString());
                    tvOut.setText(tvOut.getText() + btn1.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "1");
                            tvOut.setText(tvOut.getText().toString() + btn1.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn1.getText().toString());
                            tvOut.setText(tvOut.getText() + btn1.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn1.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn1.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText().toString() + btn1.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn1.getText().toString());
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn2.getText().toString());
                    tvOut.setText(tvOut.getText() + btn2.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "2");
                            tvOut.setText(tvOut.getText().toString() + btn2.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn2.getText().toString());
                            tvOut.setText(tvOut.getText() + btn2.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn2.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn2.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn2.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn2.getText().toString());
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn3.getText().toString());
                    tvOut.setText(tvOut.getText() + btn3.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "3");
                            tvOut.setText(tvOut.getText().toString() + btn3.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn3.getText().toString());
                            tvOut.setText(tvOut.getText() + btn3.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn3.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn3.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn3.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn3.getText().toString());
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn4.getText().toString());
                    tvOut.setText(tvOut.getText() + btn4.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "4");
                            tvOut.setText(tvOut.getText().toString() + btn4.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn4.getText().toString());
                            tvOut.setText(tvOut.getText() + btn4.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn4.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn4.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn4.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn4.getText().toString());
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn5.getText().toString());
                    tvOut.setText(tvOut.getText() + btn5.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "5");
                            tvOut.setText(tvOut.getText().toString() + btn5.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn5.getText().toString());
                            tvOut.setText(tvOut.getText() + btn5.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn5.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn5.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn5.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn5.getText().toString());
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn6.getText().toString());
                    tvOut.setText(tvOut.getText() + btn6.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "6");
                            tvOut.setText(tvOut.getText().toString() + btn6.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn6.getText().toString());
                            tvOut.setText(tvOut.getText() + btn6.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn6.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn6.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn6.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn6.getText().toString());
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn7.getText().toString());
                    tvOut.setText(tvOut.getText() + btn7.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "7");
                            tvOut.setText(tvOut.getText().toString() + btn7.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn7.getText().toString());
                            tvOut.setText(tvOut.getText() + btn7.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn7.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn7.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn7.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn7.getText().toString());
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn8.getText().toString());
                    tvOut.setText(tvOut.getText() + btn8.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "8");
                            tvOut.setText(tvOut.getText().toString() + btn8.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn8.getText().toString());
                            tvOut.setText(tvOut.getText() + btn8.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn8.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn8.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn8.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn8.getText().toString());
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(digits.empty()){
                    tvIO.setText(tvIO.getText() + btn9.getText().toString());
                    tvOut.setText(tvOut.getText() + btn9.getText().toString());
                }
                else{
                    if (!digits.peek().toString().equals("y")){
                        if(tvIO.getText().toString().equals("")){
                            tvIO.setText(digits.pop().toString() + "9");
                            tvOut.setText(tvOut.getText().toString() + btn9.getText().toString());
                        }
                        else{
                            tvIO.setText(tvIO.getText() + btn9.getText().toString());
                            tvOut.setText(tvOut.getText() + btn9.getText().toString());
                        }
                    }
                    else{
                        tvIO.setText("");
                        digits.pop();
                        tvIO.setText(tvIO.getText() + btn9.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btn9.getText().toString());
                    }
                }
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    tvIO.setText("");
                    tvOut.setText("");
                    functions.pop();
                    tvIO.setText(tvIO.getText() + btn9.getText().toString());
                    tvOut.setText(tvOut.getText().toString() + btn9.getText().toString());
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);

		        //first of all we check if there is a dot in the input text box
		        //rest of the function will remain same as the digit's click listener
                if(tvIO.getText().length()!=0 && !tvIO.getText().toString().contains(".")){
                    if(digits.empty()){
                        tvIO.setText(tvIO.getText() + btnDot.getText().toString());
                        tvOut.setText(tvOut.getText() + btnDot.getText().toString());
                    }
                    else{
                        if (!digits.peek().toString().equals("y")){
                            if(tvIO.getText().toString().equals("")){
                                tvIO.setText(digits.pop().toString() + ".");
                                tvOut.setText(tvOut.getText().toString() + btnDot.getText().toString());
                            }
                            else{
                                tvIO.setText(tvIO.getText() + btnDot.getText().toString());
                                tvOut.setText(tvOut.getText() + btnDot.getText().toString());
                            }
                        }
                        else{
                            tvIO.setText("");
                            digits.pop();
                            tvIO.setText(tvIO.getText() + btnDot.getText().toString());
                            tvOut.setText(tvOut.getText().toString() + btnDot.getText().toString());
                        }
                    }
                    if (!functions.empty() && functions.peek().toString().equals("=")){
                        tvIO.setText("");
                        tvOut.setText("");
                        functions.pop();
                        tvIO.setText(tvIO.getText() + btnDot.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnDot.getText().toString());
                    }
                }
            }
        });

	    //click listener for brackets button
        btnBracs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
		        //check if functions contains =
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    functions.pop();
                }
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
		        //check if digits contains y
		        //because we place y after an operator or brackets
                if(digits.contains("y")){
			        //remove y
                    digits.pop();
			        //if there is a closing bracket on the top of digits
                    if(digits.peek().equals(")")){
			            //if there is an opening bracket in brackets stack
			            //it means there is still a bracket to be closed
                        if(brackets.contains("(")) {
                            if(!digits.peek().equals(")")){
                                digits.push(tvIO.getText().toString());
                            }
                            digits.push(")");
                            functions.push(")");
                            brackets.pop();
                            tvOut.setText(tvOut.getText().toString() + ")");
                        }
                        else{
                            if(!digits.peek().equals(")")){
                                digits.push(tvIO.getText().toString());
                            }
                            digits.push(btnMul.getText().toString());
                            digits.push("(");
                            functions.push("*");
                            functions.push("(");
                            brackets.push("(");
                            tvOut.setText(tvOut.getText().toString() + btnMul.getText().toString() + "(");
                        }
                    }
                    else {
			            //if there is not a closing bracket on the top
			            //then we will push an opening bracket in every stack
                        digits.push("(");
                        functions.push("(");
                        brackets.push("(");
                        tvOut.setText(tvOut.getText().toString() + "(");
                    }
                }
                else{
			        //if there no y on the top
                    if(brackets.contains("(")){
                        if(!digits.peek().equals(")")){
                            digits.push(tvIO.getText().toString());
                        }
                        digits.push(")");
                        functions.push(")");
                        tvOut.setText(tvOut.getText().toString() + ")");
                        brackets.pop();
                    }
                    else{
                        if(digits.empty() && tvIO.getText().toString().equals("")){
                            digits.push("1");
                            tvOut.setText(tvOut.getText().toString() + "(");
                        }
                        else{
                            digits.push(tvIO.getText().toString());
                            tvOut.setText(tvOut.getText().toString() + btnMul.getText().toString() + "(");
                        }
                        digits.push(btnMul.getText().toString());
                        digits.push("(");
                        functions.push("*");
                        functions.push("(");
                        brackets.push("(");
                    }
                }
                digits.push("y");
            }
        });

	    //click listener of delete button
        btnDel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView tvInOut = (TextView) findViewById(R.id.tvIO);
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    //delete everything in stacks and clear the textboxes
                    functions.pop();
                    digits.removeAllElements();
                    functions.removeAllElements();
                    brackets.removeAllElements();
                    calculation.removeAllElements();
                    tvOut.setText("");
                    tvInOut.setText("");
                }
                else if (!digits.empty()){
                    if(digits.peek().toString().equals("y")){
                        //remove y
                        digits.pop();
                        if(digits.peek().toString().equals(")")){
                            //remove )
                            digits.pop();
                            //remove number
                            if(digits.peek().toString().equals(")")){
                                digits.push("y");
                            }
                            else{
                                digits.pop();
                            }
                            tvOut.setText(tvOut.getText().toString().substring(0, tvOut.length()-1));
                            functions.pop();
                            brackets.push("(");
                        }
                        else if(digits.peek().toString().equals("(")){
                            //remove (
                            digits.pop();
                            tvOut.setText(tvOut.getText().toString().substring(0, tvOut.length()-1));
                            functions.pop();
                            brackets.pop();
                            digits.push("y");
                        }
                        else{
                            //remove sign
                            digits.pop();
                            //set number in textbox number
                            tvInOut.setText(digits.pop().toString());
                            functions.pop();
                            tvOut.setText(tvOut.getText().toString().substring(0, tvOut.length()-1));
                        }
                    }
                    else{
                        //if there is no operator on the top
                        if(!tvInOut.getText().toString().equals("")){
                            tvInOut.setText(tvInOut.getText().toString().substring(0, tvInOut.length()-1));
                            tvOut.setText(tvOut.getText().toString().substring(0, tvOut.length()-1));
                        }
                        if (tvInOut.getText().length() == 0){
                            digits.push("y");
                        }
                    }
                }
                else{
                    if(!tvInOut.getText().toString().equals("")){
                        tvInOut.setText(tvInOut.getText().toString().substring(0, tvInOut.length()-1));
                        tvOut.setText(tvOut.getText().toString().substring(0, tvOut.length()-1));
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
            }
        });

	//click listener for add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    functions.pop();
                }
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(!digits.empty() && digits.peek().toString().equals("y")){
                    digits.pop();
                    if(!digits.peek().toString().equals(")")){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else{
                        digits.push(btnAdd.getText().toString());
                        functions.push(btnAdd.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnAdd.getText().toString());
                    }
                    digits.push("y");
                }
                else{
                    if (!tvIO.getText().toString().equals("")){
                        digits.push(tvIO.getText().toString());
                        digits.push(btnAdd.getText().toString());
                        digits.push("y");
                        functions.push(btnAdd.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnAdd.getText().toString());
                    }
                    else if(digits.empty()){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
                if (!digits.empty() && tvIO.getText().toString().equals("") && !digits.peek().equals("y")){
                    digits.push("+");
                    digits.push("y");
                    functions.push("+");
                    tvOut.setText(tvOut.getText() + "+");
                }
            }
        });

	//click listener for subract button
        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    functions.pop();
                }
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(!digits.empty() && digits.peek().toString().equals("y")){
                    digits.pop();
                    if(!digits.peek().toString().equals(")")){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else{
                        digits.push(btnSub.getText().toString());
                        functions.push(btnSub.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnSub.getText().toString());
                    }
                    digits.push("y");
                }
                else{
                    if (!tvIO.getText().toString().equals("")){
                        digits.push(tvIO.getText().toString());
                        digits.push(btnSub.getText().toString());
                        digits.push("y");
                        functions.push(btnSub.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnSub.getText().toString());
                    }
                    else if(digits.empty()){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
                if (!digits.empty() && tvIO.getText().toString().equals("") && !digits.peek().equals("y")){
                    digits.push("-");
                    digits.push("y");
                    functions.push("-");
                    tvOut.setText(tvOut.getText() + "-");
                }
            }
        });

	//click listener for division button
        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    functions.pop();
                }
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(!digits.empty() && digits.peek().toString().equals("y")){
                    digits.pop();
                    if(!digits.peek().toString().equals(")")){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else{
                        digits.push(btnDiv.getText().toString());
                        functions.push(btnDiv.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnDiv.getText().toString());
                    }
                    digits.push("y");
                }
                else{
                    if (!tvIO.getText().toString().equals("")){
                        digits.push(tvIO.getText().toString());
                        digits.push(btnDiv.getText().toString());
                        digits.push("y");
                        functions.push(btnDiv.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnDiv.getText().toString());
                    }
                    else if(digits.empty()){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
                if (!digits.empty() && tvIO.getText().toString().equals("") && !digits.peek().equals("y")){
                    digits.push("/");
                    digits.push("y");
                    functions.push("/");
                    tvOut.setText(tvOut.getText() + "/");
                }
            }
        });

	//click listener for multiply button
        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!functions.empty() && functions.peek().toString().equals("=")){
                    functions.pop();
                }
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(!digits.empty() && digits.peek().toString().equals("y")){
                    digits.pop();
                    if(!digits.peek().toString().equals(")")){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else{
                        digits.push(btnMul.getText().toString());
                        functions.push(btnMul.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnMul.getText().toString());
                    }
                    digits.push("y");
                }
                else{
                    if (!tvIO.getText().toString().equals("")){
                        digits.push(tvIO.getText().toString());
                        digits.push(btnMul.getText().toString());
                        digits.push("y");
                        functions.push(btnMul.getText().toString());
                        tvOut.setText(tvOut.getText().toString() + btnMul.getText().toString());
                    }
                    else if(digits.empty()){
                        Toast t = Toast.makeText(getApplicationContext(), "Correct your statement", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
                if (!digits.empty() && tvIO.getText().toString().equals("") && !digits.peek().equals("y")){
                    digits.push("*");
                    digits.push("y");
                    functions.push("*");
                    tvOut.setText(tvOut.getText() + "*");
                }
            }
        });

	//click listener for equal button
        btnE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tvIO = (TextView) findViewById(R.id.tvIO);
                if(!functions.empty() && !functions.contains("=") && brackets.empty()){
                    if(digits.peek().toString().equals("y")){
                        digits.pop();
                        if (!digits.peek().equals(")")){
                            Toast t = Toast.makeText(getApplicationContext(), "Please complete the statement", Toast.LENGTH_SHORT);
                            t.show();
                            tvIO.setText("");
                            digits.push("y");
                        }
                    }
                    if(!functions.empty() && digits.peek().equals(")") || !digits.peek().equals("y")) {
                        if(!digits.peek().equals(")") && !tvIO.getText().toString().equals("")) {
                            digits.push(tvIO.getText().toString());
                        }
                        while (!functions.empty()) {
                            while (functions.contains("(")) {
                                Stack digits1 = new Stack();
                                Stack functions1 = new Stack();
                                Stack calculations1 = new Stack();
                                Stack temp = new Stack();
                                Stack brackets1 = new Stack();
                                while (!digits.peek().equals(")")) {
                                    calculation.push(digits.pop().toString());
                                }
                                digits.pop();
                                while(!functions.peek().toString().equals(")")){
                                    temp.push(functions.pop().toString());
                                }
                                functions.pop();
                                while (!functions.peek().toString().equals("(")){
                                    functions1.push(functions.pop().toString());
                                }
                                functions.pop();
                                while (!digits.peek().equals("(")) {
                                    calculations1.push(digits.pop().toString());
                                }
                                digits.pop();
                                while (!calculations1.empty()) {
                                    digits1.push(calculations1.pop().toString());
                                }
                                while (functions1.contains(")")){
                                    functions1.remove(")");
                                    brackets1.push(")");
                                }
                                while (digits1.contains(")")){
                                    digits1.remove(")");
                                }
                                calculations1.removeAllElements();
                                while (!functions1.empty()){
                                    if (functions1.contains("/")) {
                                        while (!digits1.peek().equals("/")) {
                                            calculations1.push(digits1.pop().toString());
                                        }
                                        functions1.remove("/");
                                        digits1.pop();
                                        digits1.push(Double.parseDouble(digits1.pop().toString()) / Double.parseDouble(calculations1.pop().toString()));
                                        while (!calculations1.empty()) {
                                            digits1.push(calculations1.pop());
                                        }
                                        continue;
                                    }
                                    if (functions1.contains("*")) {
                                        while (!digits1.peek().equals("*")) {
                                            calculations1.push(digits1.pop().toString());
                                        }
                                        functions1.remove("*");
                                        digits1.pop();
                                        digits1.push(Double.parseDouble(digits1.pop().toString()) * Double.parseDouble(calculations1.pop().toString()));
                                        functions1.remove("*");
                                        while (!calculations1.empty()) {
                                            digits1.push(calculations1.pop());
                                        }
                                        continue;
                                    }
                                    if (functions1.contains("-")) {
                                        while (!digits1.peek().equals("-")) {
                                            calculations1.push(digits1.pop().toString());
                                        }
                                        functions1.remove("-");
                                        digits1.pop();
                                        functions.remove("-");
                                        digits1.push(Double.parseDouble(digits1.pop().toString()) - Double.parseDouble(calculations1.pop().toString()));
                                        while (!calculations1.empty()) {
                                            digits1.push(calculations1.pop());
                                        }
                                        continue;
                                    }
                                    if (functions1.contains("+")) {
                                        while (!digits1.peek().equals("+")) {
                                            calculations1.push(digits1.pop().toString());
                                        }
                                        functions1.remove("+");
                                        digits1.pop();
                                        digits1.push(Double.parseDouble(digits1.pop().toString()) + Double.parseDouble(calculations1.pop().toString()));
                                        while (!calculations1.empty()) {
                                            digits1.push(calculations1.pop());
                                        }
                                        continue;
                                    }
                                }
                                digits.push(digits1.pop().toString());
                                digits1.removeAllElements();
                                calculations1.removeAllElements();
                                brackets.remove("(");
                                while (!brackets1.empty()){
                                    digits.push(")");
                                    functions.push(")");
                                    brackets1.pop();
                                }
                                functions1.removeAllElements();
                                brackets1.removeAllElements();
                                while (!temp.empty()){
                                    functions.push(temp.pop().toString());
                                }
                                while(!calculation.empty()){
                                    digits.push(calculation.pop().toString());
                                }
                                continue;
                            }
                            if (functions.contains("/")) {
                                while (!digits.peek().equals("/")) {
                                    calculation.push(digits.pop().toString());
                                }
                                digits.pop();
                                digits.push(Double.parseDouble(digits.pop().toString()) / Double.parseDouble(calculation.pop().toString()));
                                functions.remove("/");
                                while (!calculation.empty()) {
                                    digits.push(calculation.pop());
                                }
                                continue;
                            }
                            if (functions.contains("*")) {
                                while (!digits.peek().equals("*")) {
                                    calculation.push(digits.pop().toString());
                                }
                                digits.pop();
                                digits.push(Double.parseDouble(digits.pop().toString()) * Double.parseDouble(calculation.pop().toString()));
                                functions.remove("*");
                                while (!calculation.empty()) {
                                    digits.push(calculation.pop());
                                }
                                continue;
                            }
                            if (functions.contains("-")) {
                                while (!digits.peek().equals("-")) {
                                    calculation.push(digits.pop().toString());
                                }
                                digits.pop();
                                digits.push(Double.parseDouble(digits.pop().toString()) - Double.parseDouble(calculation.pop().toString()));
                                functions.remove("-");
                                while (!calculation.empty()) {
                                    digits.push(calculation.pop());
                                }
                                continue;
                            }
                            if (functions.contains("+")) {
                                while (!digits.peek().equals("+")) {
                                    calculation.push(digits.pop().toString());
                                }
                                digits.pop();
                                digits.push(Double.parseDouble(digits.pop().toString()) + Double.parseDouble(calculation.pop().toString()));
                                functions.remove("+");
                                while (!calculation.empty()) {
                                    digits.push(calculation.pop());
                                }
                                continue;
                            }
                        }
                        if(Double.parseDouble(digits.peek().toString())%1 == 0){
                            tvIO.setText(Integer.toString((int) Double.parseDouble(digits.pop().toString())));
                        }
                        else{
                            tvIO.setText(digits.pop().toString());
                        }
                        functions.push("=");
                    }
                }
            }
        });
    }
}

