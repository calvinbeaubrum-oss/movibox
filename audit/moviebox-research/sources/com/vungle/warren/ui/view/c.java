package com.vungle.warren.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends com.vungle.warren.ui.view.a<b10.g> implements b10.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b10.g f62539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f62540j;

    /* JADX INFO: compiled from: source.java */
    public class a implements e {
        public a() {
        }

        @Override // com.vungle.warren.ui.view.e
        public boolean a(MotionEvent motionEvent) {
            if (c.this.f62539i == null) {
                return false;
            }
            c.this.f62539i.e(motionEvent);
            return false;
        }
    }

    public c(@NonNull Context context, @NonNull FullAdWidget fullAdWidget, @NonNull a10.e eVar, @NonNull a10.a aVar) {
        super(context, fullAdWidget, eVar, aVar);
        this.f62540j = new a();
        i();
    }

    private void i() {
        this.f62530f.setOnViewTouchListener(this.f62540j);
    }

    @Override // b10.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void setPresenter(@NonNull b10.g gVar) {
        this.f62539i = gVar;
    }

    @Override // b10.h
    public void setVisibility(boolean z11) {
        this.f62530f.setVisibility(z11 ? 0 : 8);
    }

    @Override // b10.a
    public void showWebsite(@NonNull String str) {
        this.f62530f.showWebsite(str);
    }

    @Override // b10.h
    public void updateWindow() {
        this.f62530f.updateWindow();
    }
}
