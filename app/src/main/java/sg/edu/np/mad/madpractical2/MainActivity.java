package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User("John Doe", "Android Developer", 1, false);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        Button followButton = findViewById(R.id.followButton);

        nameTextView.setText(user.name);
        descriptionTextView.setText(user.description);

        updateFollowButton(followButton);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.followed = !user.followed;
                updateFollowButton(followButton);
            }
        });
    }

    private void updateFollowButton(Button followButton) {
        if (user.followed) {
            followButton.setText("Unfollow");
        } else {
            followButton.setText("Follow");
        }
    }
}
