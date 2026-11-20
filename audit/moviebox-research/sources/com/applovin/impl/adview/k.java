package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.applovin.impl.ea;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ea f17614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17615b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void onFailure();
    }

    public k(ea eaVar, Context context) {
        super(context);
        this.f17614a = eaVar;
        setClickable(false);
        setFocusable(false);
    }

    public void a(a aVar) {
        if (this.f17615b) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        Drawable drawableA = this.f17614a.a();
        if (drawableA == null) {
            if (aVar != null) {
                aVar.onFailure();
            }
        } else {
            setBackground(drawableA);
            this.f17615b = true;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public boolean a() {
        return this.f17615b;
    }

    public void b() {
        a(null);
    }

    public String getIdentifier() {
        return this.f17614a.b();
    }
}
