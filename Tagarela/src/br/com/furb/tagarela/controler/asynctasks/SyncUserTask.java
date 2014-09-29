package br.com.furb.tagarela.controler.asynctasks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.furb.tagarela.R;
import br.com.furb.tagarela.interfaces.UserLoginListener;
import br.com.furb.tagarela.model.DaoProvider;
import br.com.furb.tagarela.model.User;
import br.com.furb.tagarela.model.UserDao;
import br.com.furb.tagarela.utils.JsonUtils;
import br.com.furb.tagarela.view.activities.MainActivity;
import br.com.furb.tagarela.view.dialogs.UserLoginDialog;

class SyncUserTask extends AsyncTask<String, Void, Void> {
	private ProgressDialog progress;
	private Context mContext;
	private Activity activity;
	private boolean error = false;

	public SyncUserTask(Activity activity) {
		this.mContext = activity;
		this.activity = activity;
	}

	@Override
	protected void onPreExecute() {
		// Cria novo um ProgressDialogo e exibe
		progress = new ProgressDialog(mContext);
		progress.setMessage("Aguarde...");
		progress.show();
	}

	@Override
	protected Void doInBackground(String... params) {
		try {
			String id = params[0];
			String results = JsonUtils.getUserJsonResponse(id);
			JSONArray users = new JSONArray(JsonUtils.validaJson(results));
			JSONObject jsonUser = users.getJSONObject(0);
			final User user = JsonUtils.getUser(jsonUser);
			UserDao userDao = DaoProvider.getInstance(null).getUserDao();
			userDao.insert(user);
			MainActivity.setUsuarioLogado(user);
			activity.runOnUiThread(new Runnable() {
				public void run() {
					ImageView userPhoto = (ImageView) activity.findViewById(R.id.userPhoto);
					userPhoto.setImageBitmap(BitmapFactory.decodeByteArray(user.getPatientPicture(), 0, user.getPatientPicture().length));
					TextView welcomeMessage = (TextView) activity.findViewById(R.id.welcomeMessage);
					welcomeMessage.setText("Ol� " + user.getName() + " bem vindo ao Tagarela!");
				}
			});

			((UserLoginListener) activity).syncInformations();
		} catch (JSONException e) {
			error = true;
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void unused) {
		progress.dismiss();
		if (error) {
			activity.runOnUiThread(new Runnable() {
				public void run() {
					AlertDialog dialog = new AlertDialog.Builder(activity).setTitle("Erro").setPositiveButton("Ok", showLoginDialogListener()).setMessage("Usu�rio inv�lido").create();
					dialog.show();

				}

				private OnClickListener showLoginDialogListener() {
					return new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							UserLoginDialog userLoginDialog = new UserLoginDialog();
							userLoginDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "");
						}
					};
				}

			});

		}
	}
}