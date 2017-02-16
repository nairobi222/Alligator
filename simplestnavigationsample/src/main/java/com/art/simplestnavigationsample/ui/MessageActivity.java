package com.art.simplestnavigationsample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.art.alligator.NavigationContext;
import com.art.alligator.NavigationContextBinder;
import com.art.alligator.Navigator;
import com.art.alligator.implementation.ScreenUtils;
import com.art.simplestnavigationsample.R;
import com.art.simplestnavigationsample.SampleApplication;
import com.art.simplestnavigationsample.screens.MessageScreen;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Date: 22.01.2016
 * Time: 15:53
 *
 * @author Artur Artikov
 */
public class MessageActivity extends AppCompatActivity {
	private Navigator mNavigator;
	private NavigationContextBinder mNavigationContextBinder;

	@BindView(R.id.activity_message_text_view_message)
	TextView mMessageTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		ButterKnife.bind(this);

		mNavigator = SampleApplication.getNavigator();
		mNavigationContextBinder = SampleApplication.getNavigationContextBinder();

		MessageScreen screen = ScreenUtils.getScreen(this);
		mMessageTextView.setText(screen.getMessage());
	}

	@Override
	protected void onResume() {
		super.onResume();
		mNavigationContextBinder.bind(new NavigationContext(this));
	}

	@Override
	protected void onPause() {
		mNavigationContextBinder.unbind();
		super.onPause();
	}

	@Override
	public void onBackPressed() {
		mNavigator.goBack();
	}
}