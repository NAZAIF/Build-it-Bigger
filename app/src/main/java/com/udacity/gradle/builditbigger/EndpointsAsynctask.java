package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsynctask extends AsyncTask<Void,Void,String> {

    private static MyApi myApiService = null;
    private EndpointsTaskListener taskListener;

    public EndpointsAsynctask setListener(EndpointsTaskListener listener){
        this.taskListener = listener;
        return this;
    }

    public EndpointsAsynctask(){}

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if (this.taskListener != null)
            this.taskListener.onComplete(s);
    }

    @Override
    protected void onCancelled() {
        if (this.taskListener != null)
            this.taskListener.onComplete(null);
    }

    public interface EndpointsTaskListener {
        void onComplete(String joke);
    }
}
