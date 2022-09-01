package com.example.tools.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.tools.Fragment.MyPaperFragment;
import com.example.tools.Fragment.NewsFragment;
import com.example.tools.Fragment.UserFragment;
import com.example.tools.MyData;
import com.example.tools.R;
import com.example.tools.SQLite.MessageDate;
import com.example.tools.Utils;
import com.facebook.stetho.Stetho;

import org.json.JSONObject;

import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    public MessageDate messageDate = new MessageDate(this);
    private RelativeLayout news;
    private RelativeLayout paper;
    private RelativeLayout user;
    private String email;
    private ImageView mes;
    private NewsFragment newsFragment = new NewsFragment();
    private MyPaperFragment myPaperFragment = new MyPaperFragment();
    private String new_version ;
    private String downloadUrl;
    private Button upgrade;
    private UserFragment userFragment = new UserFragment();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

        private void hideFragment(FragmentTransaction transaction){
            if(newsFragment != null){
                transaction.hide(newsFragment);
            }
            if(myPaperFragment != null){
                transaction.hide(myPaperFragment);
            }
            if(userFragment != null){
                transaction.hide(userFragment);
            }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyData data=new MyData(MainActivity.this);
        email=data.load_email();
        String token =data.load_token();
        Stetho.initializeWithDefaults(this);
        mes = findViewById(R.id.message);
        news = findViewById(R.id.news_layout);
        paper = findViewById(R.id.paper_layout);
        user = findViewById(R.id.user_layout);
        news.setSelected(true);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!newsFragment.isAdded())
        {
            transaction.add(R.id.fragment,newsFragment).show(newsFragment).commit();
        }

        try {
            Utils.get_token("http://101.43.145.51:10002/itnews/api/self/info", token, new Utils.OkhttpCallBack() {
                @Override
                public void onSuccess(Response response) {
                    try {
                        JSONObject jsonObject=new JSONObject(response.body().string());
                        String msg=jsonObject.getString("msg");
                        JSONObject jsonObject1=jsonObject.getJSONObject("data");
                        Log.i("asd",jsonObject1.toString());
                        data.save_name(jsonObject1.getString("nickname"));
                        data.save_pic_url(jsonObject1.getString("avatar"));
                        data.save_info(jsonObject1.getString("info"));
                        data.save_id(jsonObject1.getInt("selfid"));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFail(String error) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }



        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news.setSelected(true);
                paper.setSelected(false);
                user.setSelected(false);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if(!newsFragment.isAdded())
                {
                    transaction.add(R.id.fragment,newsFragment);
                }
                hideFragment(transaction);
                transaction.show(newsFragment);
                transaction.commit();
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news.setSelected(false);
                paper.setSelected(true);
                user.setSelected(false);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if(!myPaperFragment.isAdded())
                {
                    transaction.add(R.id.fragment,myPaperFragment);
                }
                hideFragment(transaction);
                transaction.show(myPaperFragment);
                transaction.commit();
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news.setSelected(false);
                paper.setSelected(false);
                user.setSelected(true);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if(!userFragment.isAdded())
                {
                    transaction.add(R.id.fragment,userFragment);
                }
                hideFragment(transaction);
                transaction.show(userFragment);
                transaction.commit();
            }
        });
//        HideKeyboard();

    }
    public void HideKeyboard(View v)
    {
        InputMethodManager imm = ( InputMethodManager ) v.getContext( ).getSystemService( MainActivity.this.INPUT_METHOD_SERVICE );
        if ( imm.isActive( ) ) {
            imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );

        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}