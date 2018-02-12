package ga.nikhilkumar.molaritycalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
TextView web,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        web=(TextView) findViewById(R.id.web);
        email=(TextView) findViewById(R.id.email);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://molcalc.nikhilkumar.ga";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "admin@nikhilkumar.cf");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Molarity Calculator");
                intent.putExtra(Intent.EXTRA_TEXT, "Type your feedback here and send it");
                startActivity(Intent.createChooser(intent, "Select an email client"));
            }
        });
    }
}
