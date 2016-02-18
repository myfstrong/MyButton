package com.example.administrator.mybutton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView_Click;
    private TextView textView_LongClick;

    private Button btn_Submit;
    private Button btn_Reset;
    private Button btn_ImgAndTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_Click = (TextView)findViewById(R.id.textView_Click);
        textView_LongClick = (TextView)findViewById(R.id.textView_LongClick);

        btn_Reset = (Button)findViewById(R.id.btn_Reset);
        btn_Submit = (Button)findViewById(R.id.btn_Submit);
        btn_ImgAndTxt = (Button)findViewById(R.id.btn_ImgAndTxt);

        //实例1：测试OnClick和OnLongClick不同的按钮点击方式所产生的结果
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_Click.setText("1111111111");
            }
        });

        btn_Submit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView_LongClick.setText("22222222");
                return false;
            }
        });

        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_Click.setText("");
                textView_LongClick.setText("");
            }
        });

        //实例2：在按钮的内容显示中实现图文混排
        Bitmap bitmap_face1 = BitmapFactory.decodeResource(getResources(),R.mipmap.face1);
        Bitmap bitmap_face2 = BitmapFactory.decodeResource(getResources(),R.mipmap.face2);

        ImageSpan imageSpan_face1 = new ImageSpan(MainActivity.this,bitmap_face1);
        ImageSpan imageSpan_face2 = new ImageSpan(MainActivity.this,bitmap_face2);

        SpannableString spannableStr_face1 = new SpannableString("face1");
        SpannableString spannableStr_face2 = new SpannableString("face2");
        SpannableString spannableStr_txt = new SpannableString("图文混排");

        btn_ImgAndTxt.setText("");
        btn_ImgAndTxt.append(spannableStr_face1);
        btn_ImgAndTxt.append(spannableStr_txt);
        btn_ImgAndTxt.append(spannableStr_txt);
    }
}
