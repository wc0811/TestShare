package com.chaowang.testshare;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView tvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        tvShare = findView(R.id.tv_Share);
    }

    public void onClickShare(View vie) {


        Intent i = new Intent().setAction(Intent.ACTION_SEND).setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, tvShare.getText().toString());
        startActivity(Intent.createChooser(i, "Share To"));
        copyToClipboard();
    }

    private void copyToClipboard() {
        ClipboardManager manager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", tvShare.getText().toString());
        manager.setPrimaryClip(clipData);
        Toast.makeText(context, "Copied To Clipboard", Toast.LENGTH_SHORT).show();
    }

    private <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

}
