package me.aartikov.alligator.converters;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import me.aartikov.alligator.Screen;

/**
 * Date: 21.10.2017
 * Time: 12:56
 *
 * @author Artur Artikov
 */

/**
 * Converts a screen to a dialog fragment and vice versa.
 *
 * @param <ScreenT> screen type
 */
public interface DialogFragmentConverter<ScreenT extends Screen> {

	@NonNull
	DialogFragment createDialogFragment(@NonNull ScreenT screen);

	@NonNull
	ScreenT getScreen(@NonNull DialogFragment fragment);
}
