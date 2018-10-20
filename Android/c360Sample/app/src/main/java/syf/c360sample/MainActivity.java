package syf.c360sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    C360APIs c360APIs;

    static String customerId;

    final Random random = new Random();
    @BindView(R.id.main_text)
    TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        c360APIs = new C360APIs();
    }

    /**
     * Calls oauth API request and the customer credit profile request
     * Randomizes which customer we get back from 1 - 5 (Since those are all of our mock customers)
     */
    @OnClick(R.id.main_button)
    public void buttonClicked() {
        customerId = Integer.toString(random.nextInt(5) + 1);
        c360APIs.callC360Apis();
        String newText = c360APIs.displayCustomerData();
        mainText.setText(newText);
    }


}
