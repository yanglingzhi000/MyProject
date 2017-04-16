package com.example.acer.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

	private LuckyPan luckyPan;
	private ImageView startBtn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        luckyPan = (LuckyPan) this.findViewById(R.id.luckypan);
        
        startBtn = (ImageView) this.findViewById(R.id.start_btn);
        startBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!luckyPan.isRuning()){
					luckyPan.luckyStart(3);
					startBtn.setImageResource(R.drawable.stop);
				}else{
					if (!luckyPan.isShoundEnd()) {
						luckyPan.luckyEnd();
						startBtn.setImageResource(R.drawable.start);
					}
				}
			}
		});
    }

}
