package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f17586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f17587b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2),
        TRANSPARENT_SKIP(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17593a;

        a(int i11) {
            this.f17593a = i11;
        }

        public int b() {
            return this.f17593a;
        }
    }

    public e(Context context) {
        super(context);
        this.f17586a = 1.0f;
        this.f17587b = context;
    }

    public static e a(a aVar, Context context) {
        if (aVar.equals(a.INVISIBLE)) {
            return new h(context);
        }
        if (aVar.equals(a.WHITE_ON_TRANSPARENT)) {
            return new i(context);
        }
        return aVar.equals(a.TRANSPARENT_SKIP) ? new j(context) : new n(context);
    }

    public void a(int i11) {
        setViewScale(i11 / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public float getSize() {
        return this.f17586a * 30.0f;
    }

    public abstract a getStyle();

    public void setViewScale(float f11) {
        this.f17586a = f11;
    }
}
