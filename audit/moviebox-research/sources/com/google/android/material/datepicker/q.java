package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class q<S> extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<p<S>> f36777a = new LinkedHashSet<>();

    public boolean g0(p<S> pVar) {
        return this.f36777a.add(pVar);
    }

    public void h0() {
        this.f36777a.clear();
    }
}
