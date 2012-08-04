package com.etsy.example.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.etsy.etsyAndroid.SharedPreferencesStorage;
import com.etsy.etsyCore.EtsyRequestManager;
import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyModels.BaseModel;
import com.etsy.etsyModels.Listing;
import com.etsy.etsyModels.ListingImage;
import com.etsy.etsyRequests.EtsyRequest;

public class SearchResultsActivity extends Activity{
	private EtsyRequestManager requestManager;
	private LinearLayout searchResultsLayout;
	private LayoutInflater inflater;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_results);
		
		/*
		 * Instantiate new EtsyRequestManager and retrieve access token.
		 */
		requestManager = new EtsyRequestManager(EtsyAPIConstants.apiKey, EtsyAPIConstants.apiSecret, EtsyAPIConstants.callback, EtsyAPIConstants.scope);
		requestManager.setTokenStorage(new SharedPreferencesStorage(this));
		requestManager.retrieveAccessToken();
		
		Bundle bundle = this.getIntent().getExtras();
		inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
    	
		/*
		 * Retrieve request from previous activity and start thread to execute it.
		 */
		EtsyRequest searchRequest = (EtsyRequest)bundle.getSerializable("searchRequest");
		new FillList().execute(searchRequest);
		
	}
	
	/*
	 * Asynchronous task to fill list with listings.
	 */
	private class FillList extends AsyncTask<EtsyRequest, Void, EtsyResult>{
		protected EtsyResult doInBackground(EtsyRequest... requests){
			return requestManager.runRequest(requests[0]);
		}
		
		protected void onPostExecute(EtsyResult result){
			Iterator<BaseModel> listingIterator = result.getResults().iterator();
			searchResultsLayout = (LinearLayout) findViewById(R.id.search_results_layout);
			while(listingIterator.hasNext()){
				
				/*
				 * Inflate layout, fill in text, and start another asynchronous task to grab the image.
				 */
				Listing currentListing = ((Listing)listingIterator.next());
				
		    	RelativeLayout resultFrame = (RelativeLayout)(inflater.inflate(R.layout.search_result_pane, null));
				((TextView)(resultFrame.findViewById(R.id.search_result_title))).setText(currentListing.getTitle());
				((TextView)(resultFrame.findViewById(R.id.search_result_price))).setText(currentListing.getPrice());
				searchResultsLayout.addView(resultFrame);
				new DownloadImageTask().execute(currentListing, resultFrame);
			}
		}
	}
	
	/*
	 * Asynchronous task to grab and place listing images.
	 */
	private class DownloadImageTask extends AsyncTask<Object, Void, Bitmap> {
		RelativeLayout resultFrame;
		
		protected Bitmap doInBackground(Object... taskParams) {
	    	resultFrame = (RelativeLayout)taskParams[1];
	    	
	    	/*
	    	 * Grab the image url from Listing object's Images field that was included
	    	 * because of the Images Association we included with the request.
	    	 */
    		ListingImage[] listingImages = ((Listing)taskParams[0]).getImages();
    		String imageUrl = listingImages[0].getUrl570xN();
    	
    		/*
    		 * Crop the images if the images exist.
    		 */
    		if(imageUrl != null){
		       Bitmap uncropped = loadBitmap(imageUrl);
		       if(uncropped.getWidth() > uncropped.getHeight()){
		    	   return Bitmap.createScaledBitmap(Bitmap.createBitmap(
		    			   uncropped, 
		    			   uncropped.getWidth()/2 - uncropped.getHeight()/2,
		    			   0,
		    			   uncropped.getWidth()/2 + uncropped.getHeight()/2, 
		    			   uncropped.getHeight()
		    			   ), 570, 570, true);

		       }
		       else{
		    	   return Bitmap.createScaledBitmap(Bitmap.createBitmap(
		    			   uncropped,
		    			   0, 
		    			   uncropped.getHeight()/2 - uncropped.getWidth()/2,
		    			   uncropped.getWidth(),
		    			   uncropped.getHeight()/2 + uncropped.getWidth()/2 
		    			   ), 570, 570, true);
		       }
    		}
    		else{
    			return null;
    		}
		}

	     protected void onPostExecute(Bitmap result) {
	    	if(result != null){
				ImageView resultImageView = (ImageView)(resultFrame.findViewById(R.id.search_result_image));
				resultImageView.setImageBitmap(result);
	    	}
	     }

	}
	
	private Bitmap loadBitmap(String imageUrl) {
		Bitmap bitmap = null;
		try{
			bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
		}
		catch (MalformedURLException e) {
		  e.printStackTrace();
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		return bitmap;
	}

}
