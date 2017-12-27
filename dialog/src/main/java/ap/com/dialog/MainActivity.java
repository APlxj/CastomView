package ap.com.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialog1(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, final int i) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        switch (i) {
                            case 0:
                                Toast.makeText(MainActivity.this, "选项一", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "选项二", Toast.LENGTH_SHORT).show();
                                break;
                            case -1:
                                Toast.makeText(MainActivity.this, "确认", Toast.LENGTH_SHORT).show();
                                break;
                            case -2:
                                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                                break;
                            case -3:
                                Toast.makeText(MainActivity.this, "了解详情 >", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(MainActivity.this, "default: " + i, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        };
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, final int i, final boolean b) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, i + " : " + b, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        View v = LayoutInflater.from(this).inflate(R.layout.castom_view, null);
        builder
                .setTitle("提示")
//                .setMessage("是否退出?")
//                .setView(v)
                .setMultiChoiceItems(new String[]{"选项一", "选项二"}, new boolean[]{true, false}, onMultiChoiceClickListener)
//                .setSingleChoiceItems(new String[]{"选项一", "选项二"}, 0, onClickListener)
//                .setItems(new String[]{"选项一", "选项二"}, onClickListener)
                .setPositiveButton("确认", onClickListener)
                .setNegativeButton("取消", onClickListener)
                .setNeutralButton("了解详情 >", onClickListener)
//                .setIcon(R.mipmap.ic_launcher)
                .create().show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            dialog1(null);
        }
        return false;
    }
}
