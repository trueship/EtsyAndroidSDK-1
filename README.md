### About

A Java library to allows developers to easily create Java or Android applications that utilize the Etsy API.

### Details

Currently uses the Scribe library for Java to deal with the OAuth business.

### Structure

There is a central EtsyRequestManager class that will store the necessary tokens and deal with OAuth authentication. Classes that inherit from the EtsyRequest abstract class have factory methods that produce EtsyRequest objects that can be passed to the EtsyRequestManager to run. The run method from EtsyRequest returns a Result object that contains the parsed response from the Etsy server. If the request was successful, the Result object should contain a list of Model objects (e.g. User, Listing, Shop, etc.).

### Getting Started

* Clone the repo into your workspace.
* In Eclipse, File \-> Import... \-> General \-> Existing Projects into Workspace and hit Next.
* Use "Select root directory:" and point it to the root directory of the project you want to import (your_directory/etsy-android/Etsy API Android Library for the library and your_directory/etsy-android/Etsy API Android Library Example for the example app)
* Click Finish.

### Example Code


#### EtsyRequestManager

The EtsyRequestManager class deals with authenticating the application with OAuth, and storing the access token. It runs requests passed to it using the access token for private requests.

#### Instantiating/Authenticating EtsyRequestManager

The EtsyRequestManager needs to be instantiated to be used and needs to be authenticated the first time a new user wants to use the application or the application requires additional permission scopes.

Here is an example of instantiating the EtsyRequestManager using a WebView in Android using Asynchronous Tasks.

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

#### Retrieving an Access Token

If you had already authenticated a EtsyRequestManager object and would like to use the same credentials/access token, you can create a new EtsyRequestManager and retrieve the access token stored the Android SharedPreferences by the finishAuthentication method.

    EtsyRequestManager requestManager = new EtsyRequestManager(apiKey, apiSecret, callback, scope);
    requestManager.retrieveAccessToken(new SharedPreferencesStorage());

#### Requests

Requests are grouped by common datatypes/models. For example, the ListingsRequest class has factory methods to produce requests that deal with listings and UsersRequest deals with users, etc. They all inherit from the EtsyRequest class.

#### Creating and Running Requests

Creating and running requests only requires calling the appropriate factory method and passing the resulting EtsyRequest object to the RequestManager object instantiated with the proper permissions.

Here is an example that involves requesting a user by id/name.

    EtsyRequest request = UsersRequest.getUser("etsystore");
    Result result = requestManager.runRequest(request);

#### Request Results

Running a request returns a Result object that has parsed the JSON request. If there is an error, you can retrieve it with getError(), or if the request went through successfully, you can retrieve the List of Models using getResults().

    EtsyRequest request = UsersRequest.getUser("etsystore");
    Result result = requestManager.runRequest(result);
    List<BaseModel> models = result.getResults();
    User user;
    
    
    if(models != null && !models.isEmpty()){
    	user = (User)models.get(0);
    }

#### Models

There is a Java model object that corresponds to every model in the API. (e.g. User, Feedback, Cart, Coupon, Shop, etc.) They all inherit from the BaseModel abstract class. The getResults() method in the Result class should return a List of BaseModel objects that are initially instantiated as the appropriate model class based on the JSON response. You can retrieve all the fields from each model using the appropriate get___() method.

Here we make a list with all the titles and descriptions from the result of a listing request.

    List<BaseModel> resultList = result.getResults();
    if(resultList != null){
    	for(int i = 0; i < resultList.size(); i++){
    		Listing currentListing = (Listing)(resultList.get(i));
    		LinearLayout listingLayout = (LinearLayout) findViewById(R.id.listingslist);
    		String listingString = "Title: " + currentListing.getTitle() + "\nDescription: " + currentListing.getDescription();
    		TextView listingView = new TextView(CurrentActivity.this);
    		listingView.setText(listingString);
    		listingLayout.addView(listingView);
    	}
    }

#### Note about Example Android App

Make sure to replace the Consumer Key, Consumer Secret, and Callback constants with your own in EtsyAPIConstants.java or else it won't work!

#### Note about using with Android versions 2.2 and below

Android versions 2.2 and below have documented issues with SSL certificates. If you wish to use this library with those versions, see [here](http://code.google.com/p/android/issues/detail?id=17680).