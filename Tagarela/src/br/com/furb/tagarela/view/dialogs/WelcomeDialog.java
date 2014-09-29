package br.com.furb.tagarela.view.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.DialogFragment;
import br.com.furb.tagarela.interfaces.UserLoginListener;

public class WelcomeDialog extends DialogFragment {
	public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Bem vindo ao Tagarela");
		builder.setMessage("Voc� j� possui um usu�rio no Tagarela?");
		builder.setPositiveButton("Sim", getLoginListener());
		builder.setNegativeButton("N�o", getCreateUserListener());
		return builder.create();
	}

	private OnClickListener getCreateUserListener() {
		return new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				UserLoginListener userLoginListener = (UserLoginListener) getActivity();
				userLoginListener.onLoginReturnValue(false);
			}
		};
	}

	private OnClickListener getLoginListener() {
		return new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				UserLoginListener userLoginListener = (UserLoginListener) getActivity();
				userLoginListener.onLoginReturnValue(true);
			}
		};
	};
}