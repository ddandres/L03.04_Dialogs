/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0304_dialogs;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        This method will be executed when the button is clicked.
        It will display a Dialog.
     */
    public void clearAllContacts(View view) {
        // AlertDialog.Builder to help create a custom dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set the title of the dialog
        builder.setTitle(R.string.clear_all);
        // Set an icon to be displayed
        final Drawable icon = ContextCompat.getDrawable(MainActivity.this, android.R.drawable.stat_sys_warning);
        icon.setTint(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
        builder.setIcon(icon);
        // Set the message to be displayed
        builder.setMessage(R.string.are_you_sure);
        // Set a button for a positive action
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Display a message when clicked
                Toast.makeText(MainActivity.this, R.string.answer_no, Toast.LENGTH_SHORT).show();
            }
        });
        // Set a button for a negative action
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Display a message when clicked
                Toast.makeText(MainActivity.this, R.string.answer_yes, Toast.LENGTH_SHORT).show();
            }
        });
        // Prevent the dialog from being cancelled
        builder.setCancelable(false);
        // Create the dialog
        final AlertDialog dialog = builder.create();
        // SHow the dialog
        dialog.show();
    }
}
