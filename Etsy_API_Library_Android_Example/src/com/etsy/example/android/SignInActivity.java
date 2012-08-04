package com.etsy.example.android;


import com.etsy.etsyAndroid.SharedPreferencesStorage;
import com.etsy.etsyCore.EtsyRequestManager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SignInActivity extends Activity {
	private EtsyRequestManager requestManager;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        
        /*
         * Create the EtsyRequestManager.
         */
        requestManager = new EtsyRequestManager(EtsyAPIConstants.apiKey, EtsyAPIConstants.apiSecret, EtsyAPIConstants.callback, EtsyAPIConstants.scope);
        WebView oAuthWebView = (WebView)findViewById(R.id.oauth_webview);
        
        /*
         * Override the WebView UrlLoading so that it starts the next activity after the user signs in.
         */
        oAuthWebView.setWebViewClient(new WebViewClient(){
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url){
        		if(url.startsWith(EtsyAPIConstants.callback)){
        			new FinishAuthTask().execute(url);
        			view.setVisibility(View.INVISIBLE);
            		return super.shouldOverrideUrlLoading(view, url);
        		}

        		return super.shouldOverrideUrlLoading(view, url);
        	}
        	
        });
        
        /*
         *  Start the OAuth authentication process.
         */
        new StartAuthTask().execute();
    }
    
    private class StartAuthTask extends AsyncTask<Void, Void, String>{
    	protected String doInBackground(Void... noParams){
    		return requestManager.startAuthentication();
    	}
    	
    	protected void onPostExecute(String oAuthUrl){
    		WebView oAuthWebView = (WebView)findViewById(R.id.oauth_webview);
    		oAuthWebView.loadUrl(oAuthUrl);
    	}
    }
    
    private class FinishAuthTask extends AsyncTask<String, Void, Void>{
    	protected Void doInBackground(String... urls){
    		/*
			 * Extract the verifier value and get access token.
			 */
			Uri verifierUrl = Uri.parse(urls[0]);
			String verifier = verifierUrl.getQueryParameter("oauth_verifier");
			requestManager.finishAuthentication(verifier, new SharedPreferencesStorage(SignInActivity.this));
			return null;
    	}
    	
    	protected void onPostExecute(Void noParam){
    		Intent searchListingsIntent = new Intent(SignInActivity.this, SearchListingsActivity.class);
            startActivity(searchListingsIntent);
    	}
    }
    
}