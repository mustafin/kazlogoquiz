package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.domain.DataParser;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 30.03.2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private TextView total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentView());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        total = (TextView) findViewById(R.id.total_tenge);

        if(toolbar != null)
            setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setCustomView(R.layout.custom_toolbar);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @LayoutRes
    protected abstract int contentView();


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onResume() {
        super.onResume();
        total.setText(String.format(Locale.getDefault(), "%d", getTotal()));
    }

    protected List<Level> getLevels(){
        DataParser parser = DataParser.getInstance(this);
        return parser.getCachedLevels();
    }

    protected int getTotal(){
        DataStateHandler dsh = DataStateHandler.getInstance(this);
        return dsh.getTotal();
    }

}
