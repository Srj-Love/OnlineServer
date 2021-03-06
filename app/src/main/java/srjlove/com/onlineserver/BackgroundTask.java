package srjlove.com.onlineserver;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Suraj on 6/11/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {


    Context ctx;

    BackgroundTask(Context ctx) {


        this.ctx = ctx;
    }

    protected String doInBackground(String... params) {


        String reg_url = "https://your_site.com/add.php";
        String method = params[0];

        if (method.equals("register")) {


            String name = params[1];
            String email = params[2];

            String contact = params[3];

            String password = params[4];


            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();


                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));


                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +

                        URLEncoder.encode("contact", "UTF-8") + "=" + URLEncoder.encode(contact, "UTF-8") + "&" +

                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(data);

                bufferedWriter.flush();

                bufferedWriter.close();

                os.close();

                InputStream IS = httpURLConnection.getInputStream();

                IS.close();

                return "Registration success";




                /**
                 * $mysql_host = "sql106.iran-rank.ir";
                    $mysql_user = "aanak_19287104";
                    $db_name = "aanak_19287104_demo";
                    $mysql_password = "9004345716";
                 **/


            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }


        }
        return null;

    }


    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onPreExecute() {

        super.onPreExecute();

    }


    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);

    }

}
