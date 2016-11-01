package com.example.ipshift;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class IpActivity extends AppCompatActivity {
    Spinner co_ipsp01;
    private int pos0, pos1, pos2, pos3;
    String[] str_sp01;
    String[] str_sp02;
    LinearLayout co_ll_a0, co_ll_a1, co_ll_a2, co_ll_a3, co_ll_a4, co_ll_b0, co_ll_b1, co_ll_b2, co_ll_b3, co_ll_b4;

    EditText co_et_a00, co_et_a01, co_et_a02, co_et_a03, co_et_a04;
    Button co_bt_a00, co_bt_b00;
    TextView co_tv_b00, co_tv_b01, co_tv_b02, co_tv_b03, co_tv_b04, co_tv_b05;

    Spinner co_et_a10, co_et_a11, co_et_a12, co_et_a13;
    Button co_bt_a10, co_bt_b10;
    TextView co_tv_b10;

    EditText co_et_a20;
    Button co_bt_a20, co_bt_b20;
    TextView co_tv_b20, co_tv_b21;

    EditText co_et_a30;
    Button co_bt_a30, co_bt_b30;
    TextView co_tv_b30, co_tv_b31, co_tv_b32;

    EditText co_et_a40, co_et_a41, co_et_a42, co_et_a43, co_et_a44;
    Button co_bt_a40, co_bt_b40;
    TextView co_tv_b40, co_tv_b41, co_tv_b42, co_tv_b43;
    Toast toast;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toast = Toast.makeText(IpActivity.this, "", Toast.LENGTH_SHORT);
        str_sp01 = getResources().getStringArray(R.array.ip_type);
        str_sp02 = getResources().getStringArray(R.array.numerical_type);
        getComponents();
        clear();
        co_ipsp01 = (Spinner) findViewById(R.id.co_ipsp01);
        co_ipsp01.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp01));
        co_ipsp01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hidden_a();
                switch (i) {
                    case 0:
                        clearZero();
                        co_ll_a0.setVisibility(View.VISIBLE);
                        co_bt_a00.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calZero();
                            }
                        });
                        break;
                    case 1:
                        clearOne();
                        co_ll_a1.setVisibility(View.VISIBLE);
                        co_bt_a10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calOne();
                            }
                        });
                        break;
                    case 2:
                        clearTwo();
                        co_ll_a2.setVisibility(View.VISIBLE);
                        co_bt_a20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calTwo();
                            }
                        });
                        break;
                    case 3:
                        clearThree();
                        co_ll_a3.setVisibility(View.VISIBLE);
                        co_bt_a30.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calThree();
                            }
                        });
                        break;
                    case 4:
                        clearFour();
                        co_ll_a4.setVisibility(View.VISIBLE);
                        co_bt_a40.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calFour();
                            }
                        });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void getComponents() {
        co_ipsp01 = (Spinner) findViewById(R.id.co_ipsp01);
        co_ll_a0 = (LinearLayout) findViewById(R.id.co_ll_a0);
        co_ll_a1 = (LinearLayout) findViewById(R.id.co_ll_a1);
        co_ll_a2 = (LinearLayout) findViewById(R.id.co_ll_a2);
        co_ll_a3 = (LinearLayout) findViewById(R.id.co_ll_a3);
        co_ll_a4 = (LinearLayout) findViewById(R.id.co_ll_a4);
        co_ll_b0 = (LinearLayout) findViewById(R.id.co_ll_b0);
        co_ll_b1 = (LinearLayout) findViewById(R.id.co_ll_b1);
        co_ll_b2 = (LinearLayout) findViewById(R.id.co_ll_b2);
        co_ll_b3 = (LinearLayout) findViewById(R.id.co_ll_b3);
        co_ll_b4 = (LinearLayout) findViewById(R.id.co_ll_b4);
        co_et_a00 = (EditText) findViewById(R.id.co_et_a00);
        co_et_a01 = (EditText) findViewById(R.id.co_et_a01);
        co_et_a02 = (EditText) findViewById(R.id.co_et_a02);
        co_et_a03 = (EditText) findViewById(R.id.co_et_a03);
        co_et_a04 = (EditText) findViewById(R.id.co_et_a04);
        co_et_a10 = (Spinner) findViewById(R.id.co_et_a10);
        co_et_a11 = (Spinner) findViewById(R.id.co_et_a11);
        co_et_a12 = (Spinner) findViewById(R.id.co_et_a12);
        co_et_a13 = (Spinner) findViewById(R.id.co_et_a13);
        co_et_a20 = (EditText) findViewById(R.id.co_et_a20);
        co_et_a30 = (EditText) findViewById(R.id.co_et_a30);
        co_et_a40 = (EditText) findViewById(R.id.co_et_a40);
        co_et_a41 = (EditText) findViewById(R.id.co_et_a41);
        co_et_a42 = (EditText) findViewById(R.id.co_et_a42);
        co_et_a43 = (EditText) findViewById(R.id.co_et_a43);
        co_et_a44 = (EditText) findViewById(R.id.co_et_a44);
        co_bt_a00 = (Button) findViewById(R.id.co_bt_a00);
        co_bt_b00 = (Button) findViewById(R.id.co_bt_b00);
        co_bt_a10 = (Button) findViewById(R.id.co_bt_a10);
        co_bt_b10 = (Button) findViewById(R.id.co_bt_b10);
        co_bt_a20 = (Button) findViewById(R.id.co_bt_a20);
        co_bt_b20 = (Button) findViewById(R.id.co_bt_b20);
        co_bt_a30 = (Button) findViewById(R.id.co_bt_a30);
        co_bt_b30 = (Button) findViewById(R.id.co_bt_b30);
        co_bt_a40 = (Button) findViewById(R.id.co_bt_a40);
        co_bt_b40 = (Button) findViewById(R.id.co_bt_b40);
        co_tv_b00 = (TextView) findViewById(R.id.co_tv_b00);
        co_tv_b01 = (TextView) findViewById(R.id.co_tv_b01);
        co_tv_b02 = (TextView) findViewById(R.id.co_tv_b02);
        co_tv_b03 = (TextView) findViewById(R.id.co_tv_b03);
        co_tv_b04 = (TextView) findViewById(R.id.co_tv_b04);
        co_tv_b05 = (TextView) findViewById(R.id.co_tv_b05);
        co_tv_b10 = (TextView) findViewById(R.id.co_tv_b10);
        co_tv_b20 = (TextView) findViewById(R.id.co_tv_b20);
        co_tv_b21 = (TextView) findViewById(R.id.co_tv_b21);
        co_tv_b30 = (TextView) findViewById(R.id.co_tv_b30);
        co_tv_b31 = (TextView) findViewById(R.id.co_tv_b31);
        co_tv_b32 = (TextView) findViewById(R.id.co_tv_b32);
        co_tv_b40 = (TextView) findViewById(R.id.co_tv_b40);
        co_tv_b41 = (TextView) findViewById(R.id.co_tv_b41);
        co_tv_b42 = (TextView) findViewById(R.id.co_tv_b42);
        co_tv_b43 = (TextView) findViewById(R.id.co_tv_b43);

        co_et_a10.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp02));
        co_et_a11.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp02));
        co_et_a12.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp02));
        co_et_a13.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, str_sp02));
        co_et_a11.setEnabled(false);
        co_et_a12.setEnabled(false);
        co_et_a13.setEnabled(false);
        co_et_a10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                co_et_a11.setEnabled(false);
                co_et_a12.setEnabled(false);
                co_et_a13.setEnabled(false);
                if (8 == position)
                    co_et_a11.setEnabled(true);
                pos0 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        co_et_a11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                co_et_a12.setEnabled(false);
                co_et_a13.setEnabled(false);
                if (8 == position)
                    co_et_a12.setEnabled(true);
                pos1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        co_et_a12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                co_et_a13.setEnabled(false);
                if (8 == position)
                    co_et_a13.setEnabled(true);
                pos2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        co_et_a13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos3 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void clear() {
        co_bt_b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearZero();
                co_ll_b0.setVisibility(View.GONE);
            }
        });
        co_bt_b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearOne();
                co_ll_b1.setVisibility(View.GONE);
            }
        });
        co_bt_b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTwo();
                co_ll_b2.setVisibility(View.GONE);
            }
        });
        co_bt_b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearThree();
                co_ll_b3.setVisibility(View.GONE);
            }
        });
        co_bt_b40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFour();
                co_ll_b4.setVisibility(View.GONE);
            }
        });
    }
    public void clearZero(){
        co_et_a00.setText("");
        co_et_a01.setText("");
        co_et_a02.setText("");
        co_et_a03.setText("");
        co_et_a04.setText("");
    }
    public void clearOne(){
        co_et_a10.setSelection(0);
        co_et_a11.setSelection(0);
        co_et_a12.setSelection(0);
        co_et_a13.setSelection(0);
        co_et_a11.setEnabled(false);
        co_et_a12.setEnabled(false);
        co_et_a13.setEnabled(false);
    }
    public void clearTwo() {
        co_et_a20.setText("");
    }
    public void clearThree() {
        co_et_a30.setText("");
    }
    public void clearFour(){
        co_et_a40.setText("");
        co_et_a41.setText("");
        co_et_a42.setText("");
        co_et_a43.setText("");
        co_et_a44.setText("");
    }
    public void hidden_a() {
        hidden_b();
        co_ll_a0.setVisibility(View.GONE);
        co_ll_a1.setVisibility(View.GONE);
        co_ll_a2.setVisibility(View.GONE);
        co_ll_a3.setVisibility(View.GONE);
        co_ll_a4.setVisibility(View.GONE);
    }

    public void hidden_b() {
        co_ll_b0.setVisibility(View.GONE);
        co_ll_b1.setVisibility(View.GONE);
        co_ll_b2.setVisibility(View.GONE);
        co_ll_b3.setVisibility(View.GONE);
        co_ll_b4.setVisibility(View.GONE);
    }

    public void calZero() {
        if (co_et_a00.getText().toString().isEmpty() || co_et_a01.getText().toString().isEmpty() || co_et_a02.getText().toString().isEmpty() || co_et_a03.getText().toString().isEmpty() || co_et_a04.getText().toString().isEmpty()) {
            toast.setText(R.string.isNull);
            toast.show();
        } else if (Integer.parseInt(co_et_a00.getText().toString()) < 0 || Integer.parseInt(co_et_a00.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a01.getText().toString()) < 0 || Integer.parseInt(co_et_a01.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a02.getText().toString()) < 0 || Integer.parseInt(co_et_a02.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a03.getText().toString()) < 0 || Integer.parseInt(co_et_a03.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a04.getText().toString()) < 0 || Integer.parseInt(co_et_a04.getText().toString()) > 32) {
            toast.setText(R.string.beyond);
            toast.show();
        } else {
            int quotient = Integer.parseInt(co_et_a04.getText().toString()) / 8;
            int remaind = Integer.parseInt(co_et_a04.getText().toString()) % 8;
            if (0 == remaind) {
                switch (quotient) {
                    case 0:
                        co_tv_b00.setText("4294967294-2");
                        co_tv_b01.setText("0.0.0.0");
                        co_tv_b02.setText("0.0.0.0");
                        co_tv_b03.setText("0.0.0.1");
                        co_tv_b04.setText("255.255.255.254");
                        co_tv_b05.setText("255.255.255.255");
                        break;
                    case 1:
                        co_tv_b00.setText("16777216-2");
                        co_tv_b01.setText("255.0.0.0");
                        co_tv_b02.setText(co_et_a00.getText().toString() + ".0.0.0");
                        co_tv_b03.setText(co_et_a00.getText().toString() + ".0.0.1");
                        co_tv_b04.setText(co_et_a00.getText().toString() + ".255.255.254");
                        co_tv_b05.setText(co_et_a00.getText().toString() + ".255.255.255");
                        break;
                    case 2:
                        co_tv_b00.setText("65536-2");
                        co_tv_b01.setText("255.255.0.0");
                        co_tv_b02.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + ".0.0");
                        co_tv_b03.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + ".0.1");
                        co_tv_b04.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + ".255.254");
                        co_tv_b05.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + ".255.255");
                        break;
                    case 3:
                        co_tv_b00.setText("256-2");
                        co_tv_b01.setText("255.255.255.0");
                        co_tv_b02.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + ".0");
                        co_tv_b03.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + ".1");
                        co_tv_b04.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + ".254");
                        co_tv_b05.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + ".255");
                        break;
                    case 4:
                        co_tv_b00.setText("one host");
                        co_tv_b01.setText("255.255.255.255");
                        co_tv_b02.setText("none");
                        co_tv_b03.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + "." + co_et_a03.getText().toString());
                        co_tv_b04.setText("none");
                        co_tv_b05.setText("none");
                }
            } else {
                switch (quotient) {
                    case 0:
                        handleZero0(remaind);
                        break;
                    case 1:
                        handleZero1(remaind);
                        break;
                    case 2:
                        handleZero2(remaind);
                        break;
                    case 3:
                        handleZero3(remaind);
                }
            }
            co_ll_b0.setVisibility(View.VISIBLE);
        }
    }

    public void calOne() {
        int pos = pos0 + pos1 + pos2 + pos3;
        if (0 == pos) {
            toast.setText(R.string.isNull);
            toast.show();
        } else {
            co_tv_b10.setText(""+pos);
            co_ll_b1.setVisibility(View.VISIBLE);
        }
    }

    public void calTwo() {
        if (co_et_a20.getText().toString().isEmpty()) {
            toast.setText(R.string.isNull);
            toast.show();
        } else if (Integer.parseInt(co_et_a20.getText().toString()) < 0 || Integer.parseInt(co_et_a20.getText().toString()) > 32) {
            toast.setText(R.string.beyond);
            toast.show();
        } else {
            int quotient = Integer.parseInt(co_et_a20.getText().toString()) / 8;
            int remaind = Integer.parseInt(co_et_a20.getText().toString()) % 8;
            if (0 == remaind) {
                switch (quotient) {
                    case 0:
                        co_tv_b20.setText("0.0.0.0");
                        co_tv_b21.setText("00.00.00.00");
                        break;
                    case 1:
                        co_tv_b20.setText("255.0.0.0");
                        co_tv_b21.setText("FF.00.00.00");
                        break;
                    case 2:
                        co_tv_b20.setText("255.255.0.0");
                        co_tv_b21.setText("FF.FF.00.00");
                        break;
                    case 3:
                        co_tv_b20.setText("255.255.255.0");
                        co_tv_b21.setText("FF.FF.FF.00");
                        break;
                    case 4:
                        co_tv_b20.setText("255.255.255.255");
                        co_tv_b21.setText("FF.FF.FF.FF");
                        break;
                }
            } else {
                handleTwo(remaind, quotient);
            }
            co_ll_b2.setVisibility(View.VISIBLE);
        }
    }

    public void calThree() {
        if (co_et_a30.getText().toString().isEmpty()) {
            toast.setText(R.string.isNull);
            toast.show();
        } else if (Integer.parseInt(co_et_a30.getText().toString()) < 1 || Integer.parseInt(co_et_a30.getText().toString()) > 4294967294L) {
            toast.setText(R.string.beyond);
            toast.show();
        } else {
            String[] arr_str = makeUpMask(Integer.parseInt(co_et_a30.getText().toString()));
            co_tv_b30.setText("/"+ arr_str[0]);
            co_tv_b31.setText(arr_str[2]);
            co_tv_b32.setText(arr_str[1]);
            co_ll_b3.setVisibility(View.VISIBLE);
        }
    }

    public void calFour() {
        if (co_et_a40.getText().toString().isEmpty() || co_et_a41.getText().toString().isEmpty() || co_et_a42.getText().toString().isEmpty() || co_et_a43.getText().toString().isEmpty() || co_et_a44.getText().toString().isEmpty()) {
            toast.setText(R.string.isNull);
            toast.show();
        } else if (Integer.parseInt(co_et_a40.getText().toString()) < 1 || Integer.parseInt(co_et_a40.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a41.getText().toString()) < 0 || Integer.parseInt(co_et_a41.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a42.getText().toString()) < 0 || Integer.parseInt(co_et_a42.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a43.getText().toString()) < 0 || Integer.parseInt(co_et_a43.getText().toString()) > 255 ||
                Integer.parseInt(co_et_a44.getText().toString()) < 0 || Long.parseLong(co_et_a44.getText().toString()) > 2147483648L) {
            toast.setText(R.string.beyond);
            toast.show();
        } else {
            int co1 = Integer.parseInt(co_et_a40.getText().toString());
            int co2 = Integer.parseInt(co_et_a44.getText().toString());
            if (0 < co1 && co1 < 127) {
                co_tv_b40.setText(R.string.type_a);
                String[] arr_str = makeUpSubnet(co2, 8);
                co_tv_b41.setText(arr_str[0]);
                co_tv_b43.setText(arr_str[1]);
                co_tv_b42.setText(arr_str[2]);
            } else if (co1 <= 191) {
                co_tv_b40.setText(R.string.type_b);
                String[] arr_str = makeUpSubnet(co2, 16);
                co_tv_b41.setText(arr_str[0]);
                co_tv_b43.setText(arr_str[1]);
                co_tv_b42.setText(arr_str[2]);
            } else if (co1 <= 223) {
                co_tv_b40.setText(R.string.type_c);
                String[] arr_str = makeUpSubnet(co2, 24);
                co_tv_b41.setText(arr_str[0]);
                co_tv_b43.setText(arr_str[1]);
                co_tv_b42.setText(arr_str[2]);
            } else if (co1 <= 139) {
                co_tv_b40.setText(R.string.type_d);
                co_tv_b41.setText("none");
                co_tv_b42.setText("none");
                co_tv_b43.setText("none");
            } else if (co1 <= 255) {
                co_tv_b40.setText(R.string.type_e);
                co_tv_b41.setText("none");
                co_tv_b42.setText("none");
                co_tv_b43.setText("none");
            }
            co_ll_b4.setVisibility(View.VISIBLE);
        }
    }

    public void handleZero0(int remaind) {//第一区间
        int co0 = (int) Math.pow(2, 8 - remaind);//该区间最多数量
        String co1 = handleEight(decToBin(co_et_a00.getText().toString()), 0, 0).substring(0, remaind + 1);//该区间网络位
        co_tv_b00.setText("" + (int) Math.pow(256, 3) * co0 + "-2");
        co_tv_b01.setText("" + (256 - co0) + ".0.0.0");
        co_tv_b02.setText("" + binToDec(handleEight(co1, 1, 0)) + ".0.0.0");
        co_tv_b03.setText("" + binToDec(handleEight(co1, 1, 0)) + ".0.0.1");
        co_tv_b04.setText("" + binToDec(handleEight(co1, 1, 1)) + ".255.255.254");
        co_tv_b05.setText("" + binToDec(handleEight(co1, 1, 1)) + ".255.255.255");
    }

    public void handleZero1(int remaind) {//第二区间
        int co0 = (int) Math.pow(2, 8 - remaind);
        String co1 = handleEight(decToBin(co_et_a01.getText().toString()), 0, 0).substring(0, remaind  + 1);//该区间网络位

        co_tv_b00.setText("" + (int) Math.pow(256, 2) * co0 + "-2");
        co_tv_b01.setText("255." + (256 - co0) + ".0.0");
        co_tv_b02.setText(co_et_a00.getText().toString() + "." + binToDec(handleEight(co1, 1, 0)) + ".0.0");
        co_tv_b03.setText(co_et_a00.getText().toString() + "." + binToDec(handleEight(co1, 1, 0)) + ".0.1");
        co_tv_b04.setText(co_et_a00.getText().toString() + "." + binToDec(handleEight(co1, 1, 1)) + ".255.254");
        co_tv_b05.setText(co_et_a00.getText().toString() + "." + binToDec(handleEight(co1, 1, 1)) + ".255.255");
    }

    public void handleZero2(int remaind) {//第三区间
        int co0 = (int) Math.pow(2, 8 - remaind);
        String co1 = handleEight(decToBin(co_et_a02.getText().toString()), 0, 0).substring(0, remaind + 1);//该区间网络位

        co_tv_b00.setText("" + 256 * co0 + "-2");
        co_tv_b01.setText("255.255." + (256 - co0) + ".0");
        co_tv_b02.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + binToDec(handleEight(co1, 1, 0)) + ".0");
        co_tv_b03.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "."+ binToDec(handleEight(co1, 1, 0)) + ".1");
        co_tv_b04.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "."+ binToDec(handleEight(co1, 1, 1)) + ".254");
        co_tv_b05.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "."+ binToDec(handleEight(co1, 1, 1)) + ".255");
    }

    public void handleZero3(int remaind) {//第四区间
        int co0 = (int) Math.pow(2, 8 - remaind);
        String co1 = handleEight(decToBin(co_et_a03.getText().toString()), 0, 0).substring(0, remaind + 1);//该区间网络位
        co_tv_b00.setText("" + co0 + "-2");
        co_tv_b01.setText("255.255.255." + (256 - co0));
        co_tv_b02.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + "." + binToDec(handleEight(co1, 1, 0)));
        co_tv_b03.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + "." + (binToDec(handleEight(co1, 1, 0)) + 1));
        co_tv_b04.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + "." + (binToDec(handleEight(co1, 1, 1)) - 1));
        co_tv_b05.setText(co_et_a00.getText().toString() + "." + co_et_a01.getText().toString() + "." + co_et_a02.getText().toString() + "." + binToDec(handleEight(co1, 1, 1)));
        if (7 == remaind) {//处理网络位31
            co_tv_b00.setText("two host");
            co_tv_b03.setText("none");
            co_tv_b04.setText("none");
        }
    }

    public void handleTwo(int remaind, int quotient) {
        switch (remaind){
            case 1:
                remaind=1;break;
            case 2:
                remaind=11;break;
            case 3:
                remaind=111;break;
            case 4:
                remaind=1111;break;
            case 5:
                remaind=11111;break;
            case 6:
                remaind=111111;break;
            case 7:
                remaind=1111111;break;
        }
        int co0 = binToDec(handleEight(""+remaind,1,0));
        String co1 = binToHex(handleEight(""+remaind,1,0));
        switch (quotient) {
            case 0://第一区间
                co_tv_b20.setText("" + co0 + ".0.0.0");
                co_tv_b21.setText("" + co1 + ".00.00.00");
                break;
            case 1:
                co_tv_b20.setText("255." + co0 + ".0.0");
                co_tv_b21.setText("FF." + co1 + ".00.00");
                break;
            case 2:
                co_tv_b20.setText("255.255." + co0 + ".0");
                co_tv_b21.setText("FF.FF." + co1 + ".00");
                break;
            case 3:
                co_tv_b20.setText("255.255.255." + co0);
                co_tv_b21.setText("FF.FF.FF." + co1);
                break;
        }

    }

    public int binToDec(String input_int) {
        int out_int = 0;
        int len = input_int.length();
        for (int i = len - 1; i >= 0; i--) {
            out_int += (Integer.parseInt("" + input_int.charAt(i))) * (int) (Math.pow(2, (len - i - 1)));
        }
        return out_int;
    }

    public String binToHex(String input_int) {
        String out_int = "";
        int mid = 0;
        input_int = makeUpDigits(input_int, 4, true);
        int len = input_int.length();
        for (int i = len - 1; i >= 0; i -= 4) {
            mid = Integer.parseInt("" + input_int.charAt(i)) * (int) Math.pow(2, 0) +
                    Integer.parseInt("" + input_int.charAt(i - 1)) * (int) Math.pow(2, 1) +
                    Integer.parseInt("" + input_int.charAt(i - 2)) * (int) Math.pow(2, 2) +
                    Integer.parseInt("" + input_int.charAt(i - 3)) * (int) Math.pow(2, 3);
            switch (mid) {
                case 10:
                    out_int = "A" + out_int;
                    break;
                case 11:
                    out_int = "B" + out_int;
                    break;
                case 12:
                    out_int = "C" + out_int;
                    break;
                case 13:
                    out_int = "D" + out_int;
                    break;
                case 14:
                    out_int = "E" + out_int;
                    break;
                case 15:
                    out_int = "F" + out_int;
                    break;
                default:
                    out_int = mid + out_int;
            }
        }
        return out_int;
    }

    public String decToBin(String input_int) {
        int ip_int = Integer.parseInt(input_int);
        String out_int = "";
        while (0 != ip_int) {
            out_int = ip_int % 2 + out_int;
            ip_int /= 2;
        }
        return out_int;
    }

    public String handleEight(String str, int i0, int i1) {//i0=0/1前后，i1=0/1补0/1
        if (0 == i0) {
            if (0 == i1)
                while (str.length() < 8) {
                    str = "0" + str;
                }
        } else {
            if (0 == i1)
                while (str.length() < 8) {
                    str += "0";
                }
            else
                while (str.length() < 8) {
                    str += "1";
                }
        }
        return str;
    }

    public String makeUpDigits(String str, int total_di, boolean boo) {
        int len = str.length();
        if (3 == total_di)
            if (boo)
                switch (len % total_di) {
                    case 0:
                        break;
                    case 1:
                        str = "00" + str;
                        break;
                    case 2:
                        str = "0" + str;
                }
            else
                switch (len % total_di) {
                    case 0:
                        break;
                    case 1:
                        str += "00";
                        break;
                    case 2:
                        str += "0";
                }
        else if (4 == total_di)
            if (boo)
                switch (len % total_di) {
                    case 0:
                        break;
                    case 1:
                        str = "000" + str;
                        break;
                    case 2:
                        str = "00" + str;
                        break;
                    case 3:
                        str = "0" + str;
                }
            else
                switch (len % total_di) {
                    case 0:
                        break;
                    case 1:
                        str += "000";
                        break;
                    case 2:
                        str += "00";
                        break;
                    case 3:
                        str += "0";
                }
        return str;
    }

    public String[] makeUpMask(int co) {
        int critical = 2, i = 1;
        String[] re_str = new String[3];
        while (co + 2 > critical) {
            critical = (int) Math.pow(2, i += 1);
        }
        re_str[0] = "" + (32 - i);//网络位
        re_str[1] = "" + (critical - 2);//实际可用数
        if (i < 9)
            re_str[2] = "255.255.255." + (256 - critical);
        else if (i < 17)
            re_str[2] = "255.255." + (256 - Math.pow(2, i - 8)) + ".0";
        else if (i < 25)
            re_str[2] = "255." + (256 - Math.pow(2, i - 16)) + ".0.0";
        else if (i < 33)
            re_str[2] = "" + (256 - critical) + ".0.0.0";
        return re_str;
    }

    public String[] makeUpSubnet(int co, int type_count) {//所需主机数，ABC类网络位
        String[] re_str = new String [3];
        String[] arr_str = makeUpMask(co);
        re_str[0] = arr_str[2] + "/" + arr_str[0];//掩码
        re_str[1] = arr_str[1];//实际可用数
        if (type_count > Integer.parseInt(arr_str[0]))
            re_str[2] = "1";
        else
            re_str[2] = "" + (int)Math.pow(2,Integer.parseInt(arr_str[0]) - type_count);
        return re_str;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Ip Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.ipshift/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Ip Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.ipshift/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
