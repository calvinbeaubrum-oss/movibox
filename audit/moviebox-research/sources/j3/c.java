package j3;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f67830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f67831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayoutInflater f67832l;

    @Deprecated
    public c(Context context, int i11, Cursor cursor, boolean z11) {
        super(context, cursor, z11);
        this.f67831k = i11;
        this.f67830j = i11;
        this.f67832l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // j3.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f67832l.inflate(this.f67831k, viewGroup, false);
    }

    @Override // j3.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f67832l.inflate(this.f67830j, viewGroup, false);
    }
}
