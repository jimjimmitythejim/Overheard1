import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Adrian on 5/21/2017.
 */

public class MyFirebaseApp extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
    /* Enable disk persistence  */
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
