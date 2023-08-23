package com.example.ftp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.textView1);


        tv1.setText("  Start !!!");
        Log.i("Eric","Eric  AAA!!! 2023.08.23 ###　ｓｔａｒｔ　");
        new Thread(){
            @Override
            public void run()
            {
                FTPClient ftpclient=new FTPClient();
                try {
                    Log.i("Eric","Eric  AAA!!! 2023.08.23 ###");

                    ftpclient.connect("172.21.8.244");
                    ftpclient.login("viewsonic","2oaijxoL$");
                    ftpclient.changeWorkingDirectory("/");
                    ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
                    FTPFile[] fs = ftpclient.listDirectories();
                    FTPFile[] fs2= ftpclient.listFiles();
                    Log.i("Eric","!!! 2023.08.23 ###"+fs2.length);
                    
                    for(int i=0;i<fs2.length;i++)
                    {
                        //fs[i].getName();
                        Log.i("Eric","!!! 2023.08.23 i="+i+": name :" +fs2[i].getName());
                        Log.i("Eric","!!! 2023.08.23 i="+i+": name :" +fs2[i].getType());


                    }


                    ftpclient.makeDirectory("test");

                //  ftpclient.makeDirectory()


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }.start();


    }
}