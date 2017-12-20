package dexterdatul.com.firebaseappretrieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase myfirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView myTextView = findViewById(R.id.textView);

        Firebase.setAndroidContext(getApplicationContext());

        myfirebase = new Firebase("https://fir-app-5a630.firebaseio.com/Text");

        myfirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String myChildText = dataSnapshot.getValue(String.class);
                myTextView.setText(myChildText);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                myTextView.setText("error found'");
            }
        });
    }
}
