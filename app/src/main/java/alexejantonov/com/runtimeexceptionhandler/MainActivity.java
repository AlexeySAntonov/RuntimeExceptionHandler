package alexejantonov.com.runtimeexceptionhandler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	private Thread.UncaughtExceptionHandler handler;
	private List<Integer> list;
	private int[] numbers = new int[1];

	private Button errorBtn1;
	private Button errorBtn2;
	private Button errorBtn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		errorBtn1 = (Button) findViewById(R.id.errorBtn1);
		errorBtn2 = (Button) findViewById(R.id.errorBtn2);
		errorBtn3 = (Button) findViewById(R.id.errorBtn3);

		handler = new RuntimeExceptionHandler(getSupportFragmentManager());
		Thread.setDefaultUncaughtExceptionHandler(handler);

		errorBtn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println(list.size());
					}
				}).start();
			}
		});

		errorBtn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println(1 / 0);
					}
				}).start();
			}
		});

		errorBtn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println(numbers[10]);
					}
				}).start();
			}
		});
	}
}
