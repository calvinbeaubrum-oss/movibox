package com.bytedance.adsdk.ugeno.Qj;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pFF {
    private DataSetObserver pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final DataSetObservable f26349sc = new DataSetObservable();

    public Parcelable pFF() {
        return null;
    }

    public float sc(int i11) {
        return 1.0f;
    }

    public abstract int sc();

    public int sc(Object obj) {
        return -1;
    }

    @Deprecated
    public Object sc(View view, int i11) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object sc(ViewGroup viewGroup, int i11) {
        return sc((View) viewGroup, i11);
    }

    public void sc(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.pFF = dataSetObserver;
        }
    }

    @Deprecated
    public void sc(View view, int i11, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void sc(ViewGroup viewGroup, int i11, Object obj) {
        sc((View) viewGroup, i11, obj);
    }

    public abstract boolean sc(View view, Object obj);

    public void zY() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.pFF;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f26349sc.notifyChanged();
    }
}
