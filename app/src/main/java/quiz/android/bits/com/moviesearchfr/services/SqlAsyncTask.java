package quiz.android.bits.com.moviesearchfr.services;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import quiz.android.bits.com.moviesearchfr.database.MovieDatabaseHelper;
import quiz.android.bits.com.moviesearchfr.models.MovieItem;

public class SqlAsyncTask extends AsyncTask<MovieItem, Void, Boolean> {
    private MovieDatabaseHelper movieDB;

    Context context;

    public SqlAsyncTask(Context context)
    {
        this.context=context;
        movieDB = new MovieDatabaseHelper(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(MovieItem... params) {
        boolean isAdded = false;
        for (MovieItem movie : params) {
            isAdded = movieDB.addMovie(movie);

            if(!isAdded) break;
        }

        return isAdded;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if(result.booleanValue()) {
            Toast.makeText(context,"Loading movies in Database successfully",Toast.LENGTH_LONG).show();
        }
    }
}
