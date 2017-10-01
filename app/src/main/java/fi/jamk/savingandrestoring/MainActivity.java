package fi.jamk.savingandrestoring;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
        TextEntryDialog.TextEntryDialogListener {
    private final String TEXTVIEW_STATEKEY = "TEXTVIEW_STATEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(TEXTVIEW_STATEKEY)) {
                String text = savedInstanceState.getString(TEXTVIEW_STATEKEY);
                textView.setText(text);
            }

        }

    }
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        TextView textView = (TextView) findViewById(R.id.textView);
        saveInstanceState.putString(TEXTVIEW_STATEKEY, textView.getText().toString());
    }
    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), "Cancel",
                Toast.LENGTH_SHORT).show();
    }

    public void buttonClicked(View view) {
        TextEntryDialog eDialog = new TextEntryDialog();
        eDialog.show(getFragmentManager(), "Text Dialog");
    }

}