package alexejantonov.com.runtimeexceptionhandler;

import android.support.v4.app.FragmentManager;
import android.util.Log;

public class RuntimeExceptionHandler implements Thread.UncaughtExceptionHandler {

	private ExceptionDialog exceptionDialog;
	private FragmentManager fragmentManager;

	public RuntimeExceptionHandler(FragmentManager fragmentManager) {
		this.fragmentManager = fragmentManager;
	}

	@Override
	public void uncaughtException(Thread thread, Throwable e) {

		if (e instanceof NullPointerException) {
			Log.e("NPE error", thread.getName() + " " + e.getMessage());
		}
		if (e instanceof ArithmeticException) {
			Log.e("Arithmetic error", thread.getName() + " " + e.getMessage());
		}
		if (e instanceof ArrayIndexOutOfBoundsException) {
			Log.e("IndexOutOfBounds error", thread.getName() + " " + e.getMessage());
		}

		exceptionDialog = ExceptionDialog.newInstance(e.toString());
		exceptionDialog.show(fragmentManager, null);
	}
}
