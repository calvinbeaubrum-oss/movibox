package yt;

import android.content.Context;
import au.d;
import com.transsion.http.request.HttpMethod;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends c<a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f81632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f81633m;

    public a(Context context) {
        this.f81633m = context;
    }

    public vt.b g() {
        return new d(this.f81633m, this.f81636a, this.f81632l, this.f81637b, HttpMethod.GET, this.f81638c, this.f81639d, this.f81640e, this.f81641f, this.f81642g, this.f81643h, this.f81644i, this.f81645j, this.f81646k).a();
    }

    public a h(boolean z11) {
        this.f81632l = z11;
        return this;
    }
}
