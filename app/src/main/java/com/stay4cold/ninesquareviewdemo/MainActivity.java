package com.stay4cold.ninesquareviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.stay4cold.ninesquareview.SquareViewInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView mRv;

    ArrayList<SquareViewInfo> mInfos = new ArrayList<>();

    RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRv = (RecyclerView)findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(adapter = new RvAdapter());
        initImg();
        initData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            int count = (int) (Math.random() * 9) + 1;
            ArrayList<SquareViewInfo> info = new ArrayList<>();
            for (int j =0; j < count; j++){
                info.add(mInfos.get(j));
            }
            adapter.addInfo(info);
        }
    }

    private void initImg() {
        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://www.bz55.com/uploads/allimg/140805/1-140P5162300-50.jpg";
            }

            @Override
            public int obtainWidth() {
                return 1920;
            }

            @Override
            public int obtainHeight() {
                return 1200;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://img4.imgtn.bdimg.com/it/u=2570382117,4151167895&fm=21&gp=0.jpg";
            }

            @Override
            public int obtainWidth() {
                return 1012;
            }

            @Override
            public int obtainHeight() {
                return 715;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://img3.imgtn.bdimg.com/it/u=1133315034,1740830955&fm=21&gp=0.jpg";
            }

            @Override
            public int obtainWidth() {
                return 1280;
            }

            @Override
            public int obtainHeight() {
                return 800;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://www.taopic.com/uploads/allimg/120628/201776-12062Q4295216.jpg";
            }

            @Override
            public int obtainWidth() {
                return 1000;
            }

            @Override
            public int obtainHeight() {
                return 667;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://image6.huangye88.com/2013/03/28/2a569ac6dbab1216.jpg";
            }

            @Override
            public int obtainWidth() {
                return 710;
            }

            @Override
            public int obtainHeight() {
                return 507;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://pic7.nipic.com/20100528/4749303_091305085433_2.jpg";
            }

            @Override
            public int obtainWidth() {
                return 1024;
            }

            @Override
            public int obtainHeight() {
                return 819;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://s1.lashouimg.com/cms/M00/76/A6/CqgBVFQ7hOeAMcBPAACpNMz4-jM804.jpg";
            }

            @Override
            public int obtainWidth() {
                return 440;
            }

            @Override
            public int obtainHeight() {
                return 280;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://img4.duitang.com/uploads/item/201212/19/20121219172711_y5Pk5.thumb.700_0.jpeg";
            }

            @Override
            public int obtainWidth() {
                return 700;
            }

            @Override
            public int obtainHeight() {
                return 450;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://img0.imgtn.bdimg.com/it/u=1106977794,2619552468&fm=21&gp=0.jpg";
            }

            @Override
            public int obtainWidth() {
                return 506;
            }

            @Override
            public int obtainHeight() {
                return 750;
            }
        });

        mInfos.add(new SquareViewInfo() {
            @Override
            public String getImageUrl() {
                return "http://t1.niutuku.com/960/10/10-202370.jpg";
            }

            @Override
            public int obtainWidth() {
                return 960;
            }

            @Override
            public int obtainHeight() {
                return 720;
            }
        });
    }
}
