package me.aartikov.alligator.exceptions;

/**
 * Date: 01.02.2017
 * Time: 11:44
 *
 * @author Artur Artikov
 */

import androidx.annotation.NonNull;

import me.aartikov.alligator.Screen;

/**
 * Exception thrown when a screen is not found in {@link me.aartikov.alligator.helpers.FragmentStack}.
 */
public class ScreenNotFoundException extends NavigationException {
	private Class<? extends Screen> mScreenClass;

	public ScreenNotFoundException(@NonNull Class<? extends Screen> screenClass) {
		super("Screen " + screenClass.getSimpleName() + " is not found.");
		mScreenClass = screenClass;
	}

	@NonNull
	public Class<? extends Screen> getScreenClass() {
		return mScreenClass;
	}
}
