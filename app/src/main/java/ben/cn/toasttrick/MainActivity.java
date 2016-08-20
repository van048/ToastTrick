package ben.cn.toasttrick;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Toast有两种显示布局方式
 * Toast.makeText(MainActivity.this, "some message", Toast.LENGTH_SHORT).show();
 * 另外一种显示模式就是自定义布局显示
 * new一个Toast对象，然后调用setView()方法
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastUtil toastUtil = new ToastUtil();

        toastUtil.Short(MainActivity.this, "自定义message字体、背景色").setToastColor(Color.WHITE, ContextCompat.getColor(MainActivity.this, R.color.colorAccent)).show();

        toastUtil.Short(MainActivity.this, "自定义message字体颜色和背景").setToastBackground(Color.WHITE, R.drawable.toast_radius).show();

        ImageView toastImage = new ImageView(getApplicationContext());
        toastImage.setImageResource(R.mipmap.ic_launcher);
        toastUtil.Short(MainActivity.this, "向Toast添加了一个ImageView").setToastBackground(Color.WHITE, R.drawable.toast_radius).addView(toastImage, 0).show();

        @SuppressLint("InflateParams") View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.image, null);
        new ToastUtil(MainActivity.this, view, Toast.LENGTH_SHORT).show();
    }
}
