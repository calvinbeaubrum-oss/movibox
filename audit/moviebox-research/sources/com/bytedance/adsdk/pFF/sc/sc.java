package com.bytedance.adsdk.pFF.sc;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.pFF.TRI.ExN;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends Paint {
    public sc() {
    }

    public sc(int i11) {
        super(i11);
    }

    public sc(int i11, PorterDuff.Mode mode) {
        super(i11);
        setXfermode(new PorterDuffXfermode(mode));
    }

    public sc(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            super.setAlpha(ExN.sc(i11, 0, 255));
        } else {
            setColor((ExN.sc(i11, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
