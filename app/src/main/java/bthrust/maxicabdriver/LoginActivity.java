package bthrust.maxicabdriver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText driverEmail  , driverPass;
    private ImageView logo_layout;
    Animation animRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


         driverEmail = (EditText) findViewById(R.id.driver_email_edit);
         driverPass = (EditText) findViewById(R.id.driver_pass_edit);
        logo_layout = (ImageView) findViewById(R.id.logo_layout);

        TextView loginButton = (TextView) findViewById(R.id.loginButton);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo_layout.setAnimation(animRotate);
                Log.e("dsafdsf==" , "sdfkjdfjdksf====");

              //  Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
              //  startActivity(intent);
               // loadDriverData(driverEmail.getText().toString() , driverPass.getText().toString());
            }
        });




    }


    private void loadDriverData(final String driver_Email, final String driver_Pass) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "URL", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            public Map<String , String> getParams() throws AuthFailureError{

                Map<String , String> params = new HashMap<String  , String>();
                params.put("" , driver_Email);
                params.put("" ,driver_Pass);
                return params;
            }
        };

        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 40000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 40000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

                Toast.makeText(getApplicationContext() , "Slow Network Process..!" , Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }



}
