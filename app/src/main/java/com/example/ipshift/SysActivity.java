package com.example.ipshift;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SysActivity extends AppCompatActivity {
    Spinner co_sysp01,co_sysp02;
    EditText co_syet01,co_syet02;
    Button co_sybt01,co_sybt02,co_sybt03;
    TextView co_sytv02,co_sytv03;
    String[] str_sp01;
    String input_int,input_poi;
    int shift_start=0,shift_end=0;
    Toast toast;
    boolean boo=false;
    boolean isPoint=false;//is or not exist point
    Map<String,String> hexMap=new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        putDataMap();
        toast=Toast.makeText(SysActivity.this,getResources().getString(R.string.choice_type),Toast.LENGTH_SHORT);
        str_sp01=getResources().getStringArray(R.array.sys_type);
        co_sysp01=(Spinner)findViewById(R.id.co_sysp01);
        co_sysp02=(Spinner)findViewById(R.id.co_sysp02);
        co_syet01=(EditText)findViewById(R.id.co_syet01);
        co_syet02=(EditText)findViewById(R.id.co_syet02);
        co_sybt01=(Button)findViewById(R.id.co_sybt01);
        co_sybt02=(Button)findViewById(R.id.co_sybt02);
        co_sybt03=(Button)findViewById(R.id.co_sybt03);
        co_sytv02=(TextView)findViewById(R.id.co_sytv02);
        co_sytv03=(TextView)findViewById(R.id.co_sytv03);

        co_sysp01.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp01));
        co_sysp02.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp01));

        co_sysp01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                shift_start = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        co_sysp02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                shift_end = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        co_sybt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_int = co_syet01.getText().toString();
                input_poi = co_syet02.getText().toString();
                if (checkInput(input_int, 0,shift_start)&&checkInput(input_poi,1,shift_start)) {
                    if(shift_start==shift_end){
                        toast.setText(R.string.choice_type);
                        toast.show();
                    } else
                        toShiftSys(shift_start,shift_end,input_int,input_poi,isPoint);
                }

            }
        });
        co_sybt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co_syet01.setText("");
                co_syet02.setText("");
                co_sytv02.setText("");
                co_sybt03.setVisibility(View.INVISIBLE);
                co_syet01.setText("");
            }
        });
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    //check input is right
    public boolean checkInput(String str_ch,int int_poi,int b_o_d_h) {//0 mean int,1 mean point
        if(0==int_poi&&str_ch.isEmpty()) {
            boo=false;
            toast.setText(R.string.isNull2);
            toast.show();
        }else if(0==int_poi||(1==int_poi&&!str_ch.isEmpty())) {
            char max_ch='1';
            String toast_text="";
            switch (b_o_d_h){
                case 0:max_ch='1';toast_text=getResources().getString(R.string.bin_illegal);break;
                case 1:max_ch='7';toast_text=getResources().getString(R.string.oct_illegal);break;
                case 2:max_ch='9';toast_text=getResources().getString(R.string.dec_illegal);break;
                case 3:max_ch='F';toast_text=getResources().getString(R.string.hex_illegal);
            }
            for (int i = 0; i < str_ch.length(); i++) {
                if((str_ch.charAt(i) >= 58 && (str_ch.charAt(i)) <= 64)){
                    boo = false;
                    toast.setText(R.string.illegal);
                    toast.show();
                    break;
                }
                else if ((str_ch.charAt(i) >= '0' && str_ch.charAt(i) <= max_ch)) {
                    boo = true;
                }
                else {
                    boo = false;
                    toast.setText(toast_text);
                    toast.show();
                    break;
                }
            }
            isPoint=true;
        }else {//only int
            boo = true;
            isPoint=false;
        }
        return boo;
    }
    //shift different system
    public void toShiftSys(int shift_start,int shift_end,String input_int,String input_poi,boolean isPoint){
        if (0 == shift_start) {
            if (1 == shift_end)
                binToOct(input_int,input_poi,isPoint);
            else if (2 == shift_end)
                binToDec(input_int,input_poi,isPoint);
            else if (3 == shift_end)
                binToHex(input_int,input_poi,isPoint);
        } else if (1 == shift_start) {
            if (0 == shift_end)
                octToBin(input_int,input_poi,isPoint);
            else if (2 == shift_end)
                octToDec(input_int,input_poi,isPoint);
            else if (3 == shift_end)
                octToHex(input_int,input_poi,isPoint);
        } else if (2 == shift_start) {
            if (0 == shift_end)
                decToBin(input_int,input_poi,isPoint);
            else if (1 == shift_end)
                decToOct(input_int,input_poi,isPoint);
            else if (3 == shift_end)
                decToHex(input_int,input_poi,isPoint);
        } else if (3 == shift_start) {
            if (0 == shift_end)
                hexToBin(input_int,input_poi,isPoint);
            else if (1 == shift_end)
                hexToOct(input_int,input_poi,isPoint);
            else if (2 == shift_end)
                hexToDec(input_int,input_poi,isPoint);
        }

    }
    public void binToOct(String input_int,String input_poi,boolean isPoint){
        String out="";
        String out_int="";
        String out_poi="";
        input_int=makeUpDigits(input_int,3,true);
        input_poi=makeUpDigits(input_poi,3,false);
        int len=input_int.length();
        for(int i=len-1;i>=0;i-=3){
            out_int=Integer.parseInt("" + input_int.charAt(i))*(int)Math.pow(2,0)+
                    Integer.parseInt(""+input_int.charAt(i-1))*(int)Math.pow(2,1)+
                    Integer.parseInt(""+input_int.charAt(i-2))*(int)Math.pow(2,2)+
                    out_int;
        }
        out=out_int;
        if(isPoint){
            for(int i=0;i<input_poi.length();i+=3)
                out_poi+=(Integer.parseInt(""+input_poi.charAt(i))*Math.pow(2,-1)+
                        Integer.parseInt(""+input_poi.charAt(i+1))*Math.pow(2,-2)+
                        Integer.parseInt(""+input_poi.charAt(i+2))*Math.pow(2,-3));
            out=""+(Double.parseDouble(out)+Double.parseDouble(out_poi));
        }
        showResult(out);
    }
    public void binToDec(String input_int,String input_poi,boolean isPoint){
        String out="";
        int out_int=0;
        double out_poi=0;
        int len=input_int.length();
        for(int i=len-1;i>=0;i--){
            out_int+=(Integer.parseInt(""+input_int.charAt(i)))*(int)(Math.pow(2,(len-i-1)));
        }
        out=String.valueOf(out_int);
        if(isPoint){
            for(int i=0;i<input_poi.length();i++)
                out_poi+=(Integer.parseInt(""+input_poi.charAt(i)))*(Math.pow(2,(-(i+1))));
            out=""+(Double.parseDouble(out)+out_poi);
        }
        showResult(out);
    }
    public void binToHex(String input_int,String input_poi,boolean isPoint){
        String out="";
        String out_int="";
        String out_poi="";
        int mid=0;
        input_int=makeUpDigits(input_int,4,true);
        input_poi=makeUpDigits(input_poi,4,false);
        int len=input_int.length();
        for(int i=len-1;i>=0;i-=4){
            mid=Integer.parseInt(""+input_int.charAt(i))*(int)Math.pow(2,0)+
                    Integer.parseInt(""+input_int.charAt(i-1))*(int)Math.pow(2,1)+
                            Integer.parseInt(""+input_int.charAt(i-2))*(int)Math.pow(2,2)+
                                    Integer.parseInt(""+input_int.charAt(i-3))*(int)Math.pow(2,3);
            switch(mid){
                case 10:out_int="A"+out_int;break;
                case 11:out_int="B"+out_int;break;
                case 12:out_int="C"+out_int;break;
                case 13:out_int="D"+out_int;break;
                case 14:out_int="E"+out_int;break;
                case 15:out_int="F"+out_int;break;
                default:out_int=mid+out_int;
            }
            out=out_int;
        }
        if(isPoint){
            for(int i=0;i<input_poi.length();i+=4) {
                Log.e("a", input_poi + " " + input_poi.charAt(i) + " ");
                out_poi += (Integer.parseInt("" + input_poi.charAt(i)) * Math.pow(2, -1) +
                        Integer.parseInt("" + input_poi.charAt(i + 1)) * Math.pow(2, -2) +
                        Integer.parseInt("" + input_poi.charAt(i + 2)) * Math.pow(2, -3) +
                        Integer.parseInt("" + input_poi.charAt(i + 3)) * Math.pow(2, -4));
            }
            out=out+"."+out_poi.split("\\.")[1];

        }
        showResult(out);
    }
    public String[] octToBin(String input_int,String input_poi,boolean isPoint){
        String out="";
        String out_int="";
        String out_poi="";
        for(int i=0;i<input_int.length();i++)
            out_int+=hexMap.get(""+input_int.charAt(i)).substring(1);
        out=out_int;
        if(isPoint){
            for(int i=0;i<input_poi.length();i++)
                out_poi+=hexMap.get("" + input_int.charAt(i)).substring(1);
            out = out_int + "." + out_poi;
        }
        showResult(out);
        String[] str_bin={out_int,out_poi};
        return str_bin;
    }
    public void octToDec(String input_int,String input_poi, boolean isPoint){
        String[] str_bin=octToBin(input_int,input_poi,isPoint);
        co_sytv02.setText("");
        co_sybt03.setVisibility(View.INVISIBLE);
        binToDec(str_bin[0], str_bin[1], isPoint);
    }
    public void octToHex(String input_int,String input_poi,boolean isPoint){
        String[] str_bin = octToBin(input_int,input_poi,isPoint);
        co_sytv02.setText("");
        co_sybt03.setVisibility(View.INVISIBLE);
        binToHex(str_bin[0], str_bin[1],isPoint);
    }
    public String[] decToBin(String input_int,String input_poi,boolean isPoint){
        int ip_int=Integer.parseInt(input_int);
        String out="";
        String out_int="";
        String out_poi="";
        while(0!=ip_int){
            out_int=ip_int%2+out_int;
            ip_int/=2;
        }
        out=out_int;
        if(isPoint){
            double ip_poi=Double.parseDouble("0."+input_poi);
            int i=0;
            while(0.0!=ip_poi) {
                input_poi=String.valueOf(ip_poi *= 2.0);
                out_poi += input_poi.charAt(0);
                ip_poi = Double.parseDouble("0." + input_poi.split("\\.")[1]);
                if(7==i)
                    break;
                i++;
            }
            out = out_int + "." + out_poi+"\n小数点后已自动保留八位";
        }
        showResult(out);
        String[] str_bin={out_int,out_poi};
        return str_bin;
    }
    public void decToOct(String input_int,String input_poi, boolean isPoint) {
        String[] str_bin= decToBin(input_int, input_poi, isPoint);
        co_sytv02.setText("");
        co_sybt03.setVisibility(View.INVISIBLE);
        binToOct(str_bin[0],str_bin[1],isPoint);
    }
    public void decToHex(String input_int,String input_poi,boolean isPoint){
        String[] str_bin = decToBin(input_int, input_poi, isPoint);
        co_sytv02.setText("");
        co_sybt03.setVisibility(View.INVISIBLE);
        binToHex(str_bin[0],str_bin[1],isPoint);
    }
    public String[] hexToBin(String input_int,String input_poi,boolean isPoint){
        String out;
        String out_int="";
        String out_poi="";
        for(int i=0;i<input_int.length();i++)
            out_int+=hexMap.get(""+input_int.charAt(i));
        out=out_int;
        if(isPoint){
            for(int i=0;i<input_poi.length();i++)
                out_poi+=hexMap.get(""+input_poi.charAt(i));
            out = out_int + "." + out_poi;
        }
        showResult(out);
        String[] str_bin={out_int,out_poi};
        return str_bin;
    }
    public void hexToOct(String input_int,String input_poi, boolean isPoint){
        String[] str_bin= hexToBin(input_int,input_poi,isPoint);
        co_sytv02.setText("");
        co_sybt03.setVisibility(View.INVISIBLE);
        binToOct(str_bin[0],str_bin[1],isPoint);
    }
    public void hexToDec(String input_int,String input_poi,boolean isPoint){
        String[] str_bin = hexToBin(input_int,input_poi,isPoint);
        co_sytv02.setText("");
        co_sybt03.setVisibility(View.INVISIBLE);
        binToDec(str_bin[0], str_bin[1], isPoint);
    }
    public void showResult(String out){
        co_sytv02.setText(out);
        co_sybt03.setVisibility(View.VISIBLE);
    }
    public void putDataMap(){
        hexMap.put("0","0000");
        hexMap.put("1","0001");
        hexMap.put("2","0010");
        hexMap.put("3","0011");
        hexMap.put("4","0100");
        hexMap.put("5","0101");
        hexMap.put("6","0110");
        hexMap.put("7","0111");
        hexMap.put("8","1000");
        hexMap.put("9","1001");
        hexMap.put("A","1010");
        hexMap.put("B","1011");
        hexMap.put("C","1100");
        hexMap.put("D","1101");
        hexMap.put("E","1110");
        hexMap.put("F","1111");
    }
    public String makeUpDigits(String str, int total_di,boolean boo){
        int len=str.length();
        if(3==total_di)
            if(boo)
                switch(len%total_di){
                    case 0:break;
                    case 1:str="00"+str;break;
                    case 2:str="0"+str;
                }
            else
                switch(len%total_di){
                    case 0:break;
                    case 1:str+="00";break;
                    case 2:str+="0";
                }
        else if(4==total_di)
            if(boo)
                switch(len%total_di){
                    case 0:break;
                    case 1:str="000"+str;break;
                    case 2:str="00"+str;break;
                    case 3:str="0"+str;
                }
            else
                switch(len%total_di){
                    case 0:break;
                    case 1:str+="000";break;
                    case 2:str+="00";break;
                    case 3:str+="0";
                }
        return str;
    }
}
