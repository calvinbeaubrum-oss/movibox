package j3;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends BaseAdapter implements Filterable, j3.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f67819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f67820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f67821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f67822d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f67823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C0721a f67824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DataSetObserver f67825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j3.b f67826i;

    /* JADX INFO: renamed from: j3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0721a extends ContentObserver {
        public C0721a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z11) {
            a.this.i();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f67819a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f67819a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z11) {
        f(context, cursor, z11 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    public abstract CharSequence b(Cursor cursor);

    @Override // j3.b.a
    public Cursor d() {
        return this.f67821c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    public void f(Context context, Cursor cursor, int i11) {
        if ((i11 & 1) == 1) {
            i11 |= 2;
            this.f67820b = true;
        } else {
            this.f67820b = false;
        }
        boolean z11 = cursor != null;
        this.f67821c = cursor;
        this.f67819a = z11;
        this.f67822d = context;
        this.f67823f = z11 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i11 & 2) == 2) {
            this.f67824g = new C0721a();
            this.f67825h = new b();
        } else {
            this.f67824g = null;
            this.f67825h = null;
        }
        if (z11) {
            C0721a c0721a = this.f67824g;
            if (c0721a != null) {
                cursor.registerContentObserver(c0721a);
            }
            DataSetObserver dataSetObserver = this.f67825h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f67819a || (cursor = this.f67821c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f67819a) {
            return null;
        }
        this.f67821c.moveToPosition(i11);
        if (view == null) {
            view = g(this.f67822d, this.f67821c, viewGroup);
        }
        e(view, this.f67822d, this.f67821c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f67826i == null) {
            this.f67826i = new j3.b(this);
        }
        return this.f67826i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i11) {
        Cursor cursor;
        if (!this.f67819a || (cursor = this.f67821c) == null) {
            return null;
        }
        cursor.moveToPosition(i11);
        return this.f67821c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        Cursor cursor;
        if (this.f67819a && (cursor = this.f67821c) != null && cursor.moveToPosition(i11)) {
            return this.f67821c.getLong(this.f67823f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f67819a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f67821c.moveToPosition(i11)) {
            if (view == null) {
                view = h(this.f67822d, this.f67821c, viewGroup);
            }
            e(view, this.f67822d, this.f67821c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i11);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    public void i() {
        Cursor cursor;
        if (!this.f67820b || (cursor = this.f67821c) == null || cursor.isClosed()) {
            return;
        }
        this.f67819a = this.f67821c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f67821c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0721a c0721a = this.f67824g;
            if (c0721a != null) {
                cursor2.unregisterContentObserver(c0721a);
            }
            DataSetObserver dataSetObserver = this.f67825h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f67821c = cursor;
        if (cursor != null) {
            C0721a c0721a2 = this.f67824g;
            if (c0721a2 != null) {
                cursor.registerContentObserver(c0721a2);
            }
            DataSetObserver dataSetObserver2 = this.f67825h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f67823f = cursor.getColumnIndexOrThrow("_id");
            this.f67819a = true;
            notifyDataSetChanged();
        } else {
            this.f67823f = -1;
            this.f67819a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
