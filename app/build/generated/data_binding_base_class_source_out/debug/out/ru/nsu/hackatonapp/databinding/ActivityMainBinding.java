// Generated by view binder compiler. Do not edit!
package ru.nsu.hackatonapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.nsu.hackatonapp.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView errorEmailLogin;

  @NonNull
  public final TextView errorPswdLogin;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextView loginCreateAccount;

  @NonNull
  public final EditText loginEmail;

  @NonNull
  public final EditText loginPassword;

  @NonNull
  public final TextView registerButton;

  @NonNull
  public final TextView restorePswdLogin;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull TextView errorEmailLogin,
      @NonNull TextView errorPswdLogin, @NonNull Button loginButton,
      @NonNull TextView loginCreateAccount, @NonNull EditText loginEmail,
      @NonNull EditText loginPassword, @NonNull TextView registerButton,
      @NonNull TextView restorePswdLogin) {
    this.rootView = rootView;
    this.errorEmailLogin = errorEmailLogin;
    this.errorPswdLogin = errorPswdLogin;
    this.loginButton = loginButton;
    this.loginCreateAccount = loginCreateAccount;
    this.loginEmail = loginEmail;
    this.loginPassword = loginPassword;
    this.registerButton = registerButton;
    this.restorePswdLogin = restorePswdLogin;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.error_email_login;
      TextView errorEmailLogin = ViewBindings.findChildViewById(rootView, id);
      if (errorEmailLogin == null) {
        break missingId;
      }

      id = R.id.error_pswd_login;
      TextView errorPswdLogin = ViewBindings.findChildViewById(rootView, id);
      if (errorPswdLogin == null) {
        break missingId;
      }

      id = R.id.login_button;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.login_create_account;
      TextView loginCreateAccount = ViewBindings.findChildViewById(rootView, id);
      if (loginCreateAccount == null) {
        break missingId;
      }

      id = R.id.login_email;
      EditText loginEmail = ViewBindings.findChildViewById(rootView, id);
      if (loginEmail == null) {
        break missingId;
      }

      id = R.id.login_password;
      EditText loginPassword = ViewBindings.findChildViewById(rootView, id);
      if (loginPassword == null) {
        break missingId;
      }

      id = R.id.register_button;
      TextView registerButton = ViewBindings.findChildViewById(rootView, id);
      if (registerButton == null) {
        break missingId;
      }

      id = R.id.restore_pswd_login;
      TextView restorePswdLogin = ViewBindings.findChildViewById(rootView, id);
      if (restorePswdLogin == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, errorEmailLogin, errorPswdLogin,
          loginButton, loginCreateAccount, loginEmail, loginPassword, registerButton,
          restorePswdLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}