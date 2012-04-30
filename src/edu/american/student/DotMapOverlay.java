package edu.american.student;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.OverlayItem;

/**
 * This class allows the user to add an icon to a map which is clickable and displays a message
 * @author Cam Cook
 *
 */
public class DotMapOverlay extends com.google.android.maps.ItemizedOverlay
{

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();//holds the icons
	private Context context; // application context
	
	/**
	 * Init the object, pass it the app context and the resource for the icon
	 * @param aContext the app context
	 * @param marker the resource for the icon
	 */
	public DotMapOverlay(Context aContext, Drawable marker)
	{
		super(boundCenterBottom(marker));
		context=aContext;
	}

	/**
	 * defines what to do if the icon is clicked
	 */
	@Override
    protected boolean onTap(int index)
	{
      OverlayItem item = mOverlays.get(index);
      AlertDialog.Builder dialog = new AlertDialog.Builder(context);
      dialog.setTitle(item.getTitle());
      dialog.setMessage(item.getSnippet());
      dialog.show();

      return true;
    }
	
	/**
	 * adds the overlay to the list and tells it to draw
	 * @param overlay the overlay to add
	 */
	public void addOverlay(OverlayItem overlay) 
	{
	    mOverlays.add(overlay);
	    populate();
	}

	@Override
	/**
	 * I'm not sure what this does >.>
	 */
	protected OverlayItem createItem(int i) 
	{
	  return mOverlays.get(i);
	}
	
	@Override
	/**
	 * returns the amount of overlays held
	 */
	public int size()
	{
		return mOverlays.size();
	}
	
}