package com.example.yc.trace;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText address;
    private EditText password;
    private Button login;
    String addr;
    String passwd;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.btn_login);
        login.setOnClickListener(this);

//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
     //   navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.btn_login){

            address = (EditText) findViewById(R.id.input_address);
            addr = address.getEditableText().toString();
            password = (EditText) findViewById(R.id.input_password);
            passwd = password.getEditableText().toString();


            if(addr.equals(this.getResources().getText(R.string.buy_address)) && passwd.equals(this.getResources().getText(R.string.buy_key))){
                Intent intent=new Intent(this,ValueActivity.class);
                intent.putExtra("address",addr);
                intent.putExtra("balance",passwd);
                startActivity(intent);
            }
            if(addr.equals(this.getResources().getText(R.string.sell_address)) && passwd.equals(this.getResources().getText(R.string.sell_key))){
                Intent intent=new Intent(this,ValueActivity.class);
                intent.putExtra("address",addr);
                intent.putExtra("balance",passwd);
                startActivity(intent);
            }
            else {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("登陆提示")
                        .setMessage("登陆失败！请重新登录！")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(builder.getContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog login = builder.create();
                login.show();
            }
        }
    }
    }
