package me.aartikov.simplescreenswitchersample.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import me.aartikov.alligator.annotations.RegisterScreen;
import me.aartikov.simplescreenswitchersample.R;
import me.aartikov.simplescreenswitchersample.screens.TabScreen;

/**
 * Date: 21.01.2016
 * Time: 23:30
 *
 * @author Artur Artikov
 */
@RegisterScreen(TabScreen.Dog.class)
public class DogFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_dog, container, false);
	}
}
