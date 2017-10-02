package alexejantonov.com.runtimeexceptionhandler;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExceptionDialog extends AppCompatDialogFragment {

	private static final String BUNDLE_ERROR = ExceptionDialog.class.getSimpleName() + ".error";

	private String errorMessage;

	private TextView errorText;
	private EditText reportMessage;

	public static ExceptionDialog newInstance(String message) {
		Bundle args = new Bundle();
		args.putString(BUNDLE_ERROR, message);
		ExceptionDialog exceptionDialog = new ExceptionDialog();
		exceptionDialog.setArguments(args);
		return exceptionDialog;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		errorMessage = getArguments().getString(BUNDLE_ERROR);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_exception, null);
		errorText = view.findViewById(R.id.errorText);
		reportMessage = view.findViewById(R.id.reportMessage);

		errorText.setText(errorMessage);

		return new AlertDialog.Builder(getContext())
				.setView(view)
				.setPositiveButton(R.string.report_buttont_text, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						Toast.makeText(getContext(), reportMessage.getText() + ": has been sent.", Toast.LENGTH_LONG).show();
						dialogInterface.dismiss();
					}
				})
				.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						dialogInterface.dismiss();
					}
				})
				.create();
	}
}
