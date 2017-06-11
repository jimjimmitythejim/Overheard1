package overheardsite.myapplication;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 5/16/2017.
 */

public class CompositeOnClickListener implements View.OnClickListener{
    private List<View.OnClickListener> listeners;

    public CompositeOnClickListener(){
        listeners = new ArrayList<View.OnClickListener>();
    }

    public void addOnClickListener(View.OnClickListener listener){
        listeners.add(listener);
    }

    public void removeOnClickListener(View.OnClickListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void onClick(View v){
        for(View.OnClickListener listener : listeners){
            listener.onClick(v);
        }
    }
}