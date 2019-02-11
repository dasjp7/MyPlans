package com.example.myplans.Helper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.myplans.Home;
import com.example.myplans.MainActivity;
import com.example.myplans.ProfileAcivity;
import com.example.myplans.R;
import com.example.myplans.TodoActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationHelper
{
    public static void setUpNavigationIcon(BottomNavigationViewEx bottomNavigationViewEx)
    {
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.setTextVisibility(true);
    }
    public static void enableNavigationClick(final Context context, BottomNavigationViewEx viewEx)
    {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationViewEx.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        context.startActivity(new Intent(context, Home.class));
                        break;
                    case R.id.todo:
                        context.startActivity(new Intent(context, TodoActivity.class));
                        break;
                    case R.id.profile:
                        context.startActivity(new Intent(context, ProfileAcivity.class));
                        break;
                }

                return false;
            }
        });
    }
}
