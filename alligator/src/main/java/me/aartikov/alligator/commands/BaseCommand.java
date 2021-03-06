package me.aartikov.alligator.commands;

import androidx.annotation.NonNull;

import me.aartikov.alligator.NavigationContext;
import me.aartikov.alligator.Screen;
import me.aartikov.alligator.exceptions.NavigationException;
import me.aartikov.alligator.exceptions.ScreenRegistrationException;
import me.aartikov.alligator.navigationfactories.NavigationFactory;
import me.aartikov.alligator.screenimplementations.ActivityScreenImplementation;
import me.aartikov.alligator.screenimplementations.DialogFragmentScreenImplementation;
import me.aartikov.alligator.screenimplementations.FragmentScreenImplementation;
import me.aartikov.alligator.screenimplementations.ScreenImplementation;

/**
 * Date: 15.10.2017
 * Time: 12:39
 *
 * @author Artur Artikov
 */

abstract class BaseCommand implements Command {
	private Class<? extends Screen> mScreenClass;

	BaseCommand(@NonNull Class<? extends Screen> screenClass) {
		mScreenClass = screenClass;
	}

	abstract protected boolean execute(@NonNull ActivityScreenImplementation screenImplementation, @NonNull NavigationContext navigationContext, @NonNull NavigationFactory navigationFactory) throws NavigationException;

	abstract protected boolean execute(@NonNull FragmentScreenImplementation screenImplementation, @NonNull NavigationContext navigationContext, @NonNull NavigationFactory navigationFactory) throws NavigationException;

	abstract protected boolean execute(@NonNull DialogFragmentScreenImplementation screenImplementation, @NonNull NavigationContext navigationContext, @NonNull NavigationFactory navigationFactory) throws NavigationException;

	@Override
	final public boolean execute(@NonNull NavigationContext navigationContext, @NonNull NavigationFactory navigationFactory) throws NavigationException {
		ScreenImplementation screenImplementation = navigationFactory.getScreenImplementation(mScreenClass);
		if (screenImplementation == null) {
			throw new ScreenRegistrationException("Screen " + mScreenClass.getSimpleName() + " is not registered.");
		}

		if (screenImplementation instanceof ActivityScreenImplementation) {
			return execute((ActivityScreenImplementation) screenImplementation, navigationContext, navigationFactory);
		} else if (screenImplementation instanceof FragmentScreenImplementation) {
			return execute((FragmentScreenImplementation) screenImplementation, navigationContext, navigationFactory);
		} else if (screenImplementation instanceof DialogFragmentScreenImplementation) {
			return execute((DialogFragmentScreenImplementation) screenImplementation, navigationContext, navigationFactory);
		} else {
			throw new UnsupportedOperationException("Unsupported screen implementation type " + screenImplementation);
		}
	}
}
