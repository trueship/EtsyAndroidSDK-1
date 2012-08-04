package com.etsy.example.android;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.etsy.etsyAndroid.SharedPreferencesStorage;
import com.etsy.etsyCore.EtsyRequestManager;
import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyModels.BaseModel;
import com.etsy.etsyModels.Category;
import com.etsy.etsyRequests.EtsyRequest;
import com.etsy.etsyRequests.ListingsRequest;
import com.etsy.etsyRequests.TaxonomyRequest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchListingsActivity extends Activity{
	private EtsyRequestManager requestManager;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_listings);
		
		/*
		 * Instantiate new requestManager, but retrieve access token we received in the last activity.
		 */
		requestManager = new EtsyRequestManager(EtsyAPIConstants.apiKey, EtsyAPIConstants.apiSecret, EtsyAPIConstants.callback, EtsyAPIConstants.scope);
		requestManager.setTokenStorage(new SharedPreferencesStorage(this));
		requestManager.retrieveAccessToken();
		
		new GetCategoriesTask().execute();
		
		/*
		 * Set up search textbox.
		 */
		EditText searchTextBox = (EditText)findViewById(R.id.search_listings_textbox);
		searchTextBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				EtsyRequest searchRequest = ListingsRequest.findAllListingActive();
				HashMap<String, String> params = new HashMap<String, String>();
				/*
				 * Create and add search parameters.
				 */
				params.put("keywords", v.getText() + "");
				params.put("includes", "Images");
				searchRequest.addParams(params);
				
				Intent searchResultsIntent = new Intent(SearchListingsActivity.this, SearchResultsActivity.class);
				searchResultsIntent.putExtra("searchRequest", searchRequest);
				startActivity(searchResultsIntent);
				
				return true;
			}
		});
	}
	
	private class GetCategoriesTask extends AsyncTask<Void, Void, EtsyResult>{

		@Override
		protected EtsyResult doInBackground(Void... params) {
			/*
			 * Get the categories.
			 */
			EtsyRequest categoriesRequest = TaxonomyRequest.findAllTopCategory();
			return requestManager.runRequest(categoriesRequest);
		}
		
		@Override
		protected void onPostExecute(EtsyResult categoriesResult){
			List<BaseModel> categories = categoriesResult.getResults();
			LinearLayout categoriesLayout = (LinearLayout) findViewById(R.id.categories_layout);
			Iterator<BaseModel> categoriesIterator = categories.iterator();
			
			/*
			 * Set up buttons.
			 */
			while(categoriesIterator.hasNext()){
				Button categoryButton = new Button(SearchListingsActivity.this);
				final String categoryString = ((Category)(categoriesIterator.next())).getName();
				String categoryName = categoryString.replace('_', ' ');
				categoryButton.setText(categoryName);
				
				//On click, start new activty with search.
				categoryButton.setOnClickListener(new Button.OnClickListener(){
					public void onClick(View v){
						EtsyRequest searchRequest = ListingsRequest.findAllListingActive();
						HashMap<String, String> params = new HashMap<String, String>();
						
						/*
						 * Create and add search parameters.
						 */
						params.put("category", categoryString);
						params.put("includes", "Images");
						searchRequest.addParams(params);
						
						Intent searchResultsIntent = new Intent(SearchListingsActivity.this, SearchResultsActivity.class);
						searchResultsIntent.putExtra("searchRequest", searchRequest);
						startActivity(searchResultsIntent);
					}
				});
				
				categoriesLayout.addView(categoryButton);
			}
		}
	}
}
