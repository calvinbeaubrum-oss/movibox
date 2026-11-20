package com.google.android.gms.internal.ads;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdoc implements GestureDetector.OnGestureListener {
    private final zzdmv zza;
    private final zzdnw zzb;

    public zzdoc(zzdmv zzdmvVar, zzdnw zzdnwVar) {
        this.zza = zzdmvVar;
        this.zzb = zzdnwVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0040  */
    @Override // android.view.GestureDetector.OnGestureListener
    public final synchronized boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        int y11;
        try {
            if (this.zza != null) {
                int i11 = -1;
                if (Math.abs(f11) > Math.abs(f12)) {
                    if (f11 > 0.0f) {
                        y11 = (int) (((motionEvent2.getX() - motionEvent.getX()) / f11) * 1000.0f);
                        i11 = 1;
                    } else if (f11 < 0.0f) {
                        y11 = (int) (((motionEvent2.getX() - motionEvent.getX()) / f11) * 1000.0f);
                        i11 = 2;
                    } else {
                        y11 = 0;
                    }
                } else if (f12 > 0.0f) {
                    y11 = (int) (((motionEvent2.getY() - motionEvent.getY()) / f12) * 1000.0f);
                    i11 = 8;
                } else if (f12 < 0.0f) {
                    y11 = (int) (((motionEvent2.getY() - motionEvent.getY()) / f12) * 1000.0f);
                    i11 = 4;
                } else {
                    y11 = 0;
                }
                if (i11 == this.zza.zza()) {
                    this.zza.zzD(this.zzb.zzr(), y11);
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final synchronized boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
