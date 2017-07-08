package abhaykv04.quotemachine;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private int themeId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.mainDark));

        /**
         * Intent ID Guide
         * 1 - Programming
         * 2 - Motivational
         * 3 - Famous
         * 4 - Funny
         * 5 - Start-Up
         */

        final Intent intent = new Intent(getApplicationContext(), QuoteActivity.class);

        ImageButton progButton = (ImageButton) findViewById(R.id.progButton);
        progButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("id", 1);
                intent.putExtra("themeId", themeId);
                intent.putExtra("url", "http://quotes.stormconsultancy.co.uk/random.json");
                startActivity(intent);
            }
        });

        ImageButton motiButton = (ImageButton) findViewById(R.id.motiButton);
        motiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("id", 2);
                intent.putExtra("themeId", themeId);
                intent.putExtra("url", "https://apimk.com/motivationalquotes?get_quote=yes");
                startActivity(intent);
            }
        });

        ImageButton randButton = (ImageButton) findViewById(R.id.randButton);
        randButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("id", 3);
                intent.putExtra("themeId", themeId);
                intent.putExtra("url", "https://talaikis.com/api/quotes/random");
                startActivity(intent);
            }
        });

        ImageButton funnyButton = (ImageButton) findViewById(R.id.funnyButton);
        funnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("id", 4);
                intent.putExtra("themeId", themeId);
                intent.putExtra("url", "http://api.icndb.com/jokes/random?firstName=Chuck&lastName=Norris&limitTo=[nerdy]&escape=javascript");
                startActivity(intent);
            }
        });

        ImageButton startButton = (ImageButton) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("id", 5);
                intent.putExtra("themeId", themeId);
                intent.putExtra("url", "https://wisdomapi.herokuapp.com/v1/random");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.lightTheme:
                themeId = 0;
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.mainLight));
                return true;

            case R.id.darkTheme:
                themeId = 1;
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.mainDark));
                return true;

            case R.id.exit:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }
}
