package com.mohammedfahadkaleem.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;
import com.mohammedfahadkaleem.dialogs.adapter.MyRecyclerViewAdapter;
import java.util.ArrayList;

public class MainActivity extends Activity implements MyRecyclerViewAdapter.ItemClickListener {
  private Toolbar toolbar;
  private  MyRecyclerViewAdapter adapter;
  private static final String[] LANGUAGE_CHOICES = new String[]{"English","French","Russian","Spanish","Chinese"};
  private boolean[] chosenLanguages = new boolean[5];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = findViewById(R.id.toolbar);
    toolbar.setNavigationIcon(R.drawable.ic_hamburger);
    setActionBar(toolbar);
    getActionBar().setDisplayShowHomeEnabled(true);
    getActionBar().setHomeButtonEnabled(true);

    // data to populate the RecyclerView with
    ArrayList<String> dialogTypes = new ArrayList<>();
    dialogTypes.add("Confirmation");
    dialogTypes.add("Alert");
    dialogTypes.add("Single Choice");
    dialogTypes.add("Multiple Choice");
    dialogTypes.add("Info");
    dialogTypes.add("Warning");
    dialogTypes.add("Light");
    dialogTypes.add("Dark");
    dialogTypes.add("Facebook Post");
    dialogTypes.add("Review");

    // set up the RecyclerView
    RecyclerView recyclerView = findViewById(R.id.rv_dialog);
    recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    adapter = new MyRecyclerViewAdapter(this, dialogTypes);
    adapter.setClickListener(this);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onItemClick(View view, int position) {
    //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position,Toast.LENGTH_SHORT).show();
    if (position == 0) {
      displayConfirmDialog();
    }
    else if(position == 1){
      displayAlertDialog();
    }
    else if(position == 2){
      displaySingleChoiceDialog();
    }
    else if(position == 3){
      displayMultipleChoiceDialog();
    }
    else if(position == 4){
      displayInfoDialog();
    }
    else if(position == 5){
      diaplayWarningDialog();
    }
    else if(position == 6){
      displayLightDialog();
    }
    else if(position == 7){
      displayDarkDialog();
    }
    else if(position == 8){
      displayFacebookPostDialog();
    }
    else if(position == 9){
      displayReviewDialog();
    }
  }

  private void displayConfirmDialog() {
    AlertDialog.Builder builder = new Builder(this);
    builder.setTitle("Are you sure?")
        .setMessage("Going back will close the app. Are you sure you don't want to stick around?")
        .setPositiveButton("CONFIRM", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "Feedback button Clicked", Toast.LENGTH_SHORT).show();
          }
        })
        .setNegativeButton("CANCEL", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "Later button Clicked", Toast.LENGTH_SHORT).show();
          }
        }).show();
  }

  private void displayAlertDialog() {
    AlertDialog.Builder builder = new Builder(this);
    builder.setTitle("Discard Changes?")
        .setPositiveButton("DISCARD", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "Discarding Changes", Toast.LENGTH_SHORT).show();
          }
        })
        .setNegativeButton("CANCEL", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "Cancel Clicked", Toast.LENGTH_SHORT).show();
          }
        })
        .show();
  }

  private void displaySingleChoiceDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Choose your language:")
           .setSingleChoiceItems(LANGUAGE_CHOICES, 0, new OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(MainActivity.this, LANGUAGE_CHOICES[i]+" Selected", Toast.LENGTH_SHORT).show();
             }
           })
           .setPositiveButton("CONFIRM",null)
           .setNegativeButton("CANCEL",null)
           .show();
  }

  private void displayMultipleChoiceDialog() {
    chosenLanguages = new boolean[5];
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Choose your language:")
        .setMultiChoiceItems(LANGUAGE_CHOICES, chosenLanguages, null)
        .setPositiveButton("CONFIRM", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "Languages Selected", Toast.LENGTH_SHORT).show();
          }
        })
        .setNegativeButton("CANCEL",null)
        .show();
  }

  private void displayInfoDialog() {
  }

  private void diaplayWarningDialog() {
  }

  private void displayLightDialog() {
  }

  private void displayDarkDialog() {
  }

  private void displayFacebookPostDialog() {
  }

  private void displayReviewDialog() {
  }
}