package draw.statusbar.drawstatusbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Button btnChangeFragment;

    private boolean isSecondScreenDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.fl_container);
        btnChangeFragment = (Button) findViewById(R.id.btn_change);

        getFragmentManager().beginTransaction()
                .add(R.id.fl_container, FirstFragment.newInstance())
                .commit();

        btnChangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSecondScreenDisplayed = true;

                getFragmentManager().beginTransaction()
                        .replace(R.id.fl_container, SecondFragment.newInstance())
                        .commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (isSecondScreenDisplayed) {
            isSecondScreenDisplayed = false;
            getFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, FirstFragment.newInstance())
                    .commit();
        } else {
            super.onBackPressed();
        }

    }
}
