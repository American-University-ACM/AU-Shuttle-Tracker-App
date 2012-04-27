package edu.american.student;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.OverlayItem;

public class DotMapOverlay extends com.google.android.maps.ItemizedOverlay
{

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context context;
	
	public DotMapOverlay(Context aContext, Drawable marker)
	{
		super(boundCenterBottom(marker));
		context=aContext;
	}

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
	public void addOverlay(OverlayItem overlay) 
	{
	    mOverlays.add(overlay);
	    populate();
	}

	@Override
	protected OverlayItem createItem(int i) 
	{
	  return mOverlays.get(i);
	}
	
	@Override
	public int size()
	{
		return mOverlays.size();
	}
	
}