package overheardsite.myapplication;

/**
 * Created by Adrian on 6/13/2017.
 */

public class Count {

    private int _id;
    private long _count;

    public Count() {

    }

    public Count(long count) {
        this._count = count;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_count(long count) {
        this._count = count;
    }

    public int get_id() {
        return _id;
    }

    public long get_count() {
        return _count;
    }
}
