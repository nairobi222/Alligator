package me.aartikov.alligator.listeners;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import me.aartikov.alligator.Screen;
import me.aartikov.alligator.TransitionType;

/**
 * Date: 09.05.2017
 * Time: 16:06
 *
 * @author Artur Artikov
 */

/**
 * Interface for listening of screen transition.
 */
public interface TransitionListener {
	/**
	 * Is called when an usual screen transition (not screen switching and not dialog showing) has been executed.
	 *
	 * @param transitionType  type of a transition
	 * @param screenClassFrom class of the screen that disappears during a transition or {@code null} if there was no current screen before transition
	 * @param screenClassTo   class of the screen that appears during a transition or {@code null} if there was no previous screen before transition
	 * @param isActivity      true if the screens involved in the transition are represented by activities
	 */
	void onScreenTransition(@NonNull TransitionType transitionType, @Nullable Class<? extends Screen> screenClassFrom, @Nullable Class<? extends Screen> screenClassTo, boolean isActivity);
}
