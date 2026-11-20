package com.bytedance.adsdk.pFF.pFF;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.pFF.zY;
import com.bytedance.adsdk.pFF.zY.qr;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private zY ExN;
    private final AssetManager We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final qr<String> f26171sc = new qr<>();
    private final Map<qr<String>, Typeface> pFF = new HashMap();
    private final Map<String, Typeface> zY = new HashMap();
    private String TRI = ".ttf";

    public sc(Drawable.Callback callback, zY zYVar) {
        this.ExN = zYVar;
        if (callback instanceof View) {
            this.We = ((View) callback).getContext().getAssets();
        } else {
            this.We = null;
        }
    }

    private Typeface pFF(com.bytedance.adsdk.pFF.zY.zY zYVar) {
        Typeface typefaceCreateFromAsset;
        String strSc = zYVar.sc();
        Typeface typeface = this.zY.get(strSc);
        if (typeface != null) {
            return typeface;
        }
        String strZY = zYVar.zY();
        String strPFF = zYVar.pFF();
        zY zYVar2 = this.ExN;
        if (zYVar2 != null) {
            typefaceCreateFromAsset = zYVar2.sc(strSc, strZY, strPFF);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.ExN.sc(strSc);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        zY zYVar3 = this.ExN;
        if (zYVar3 != null && typefaceCreateFromAsset == null) {
            String strPFF2 = zYVar3.pFF(strSc, strZY, strPFF);
            if (strPFF2 == null) {
                strPFF2 = this.ExN.pFF(strSc);
            }
            if (strPFF2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.We, strPFF2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (zYVar.We() != null) {
            return zYVar.We();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.We, "fonts/" + strSc + this.TRI);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.zY.put(strSc, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface sc(Typeface typeface, String str) {
        int i11;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i11 = 3;
        } else if (zContains) {
            i11 = 2;
        } else {
            i11 = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i11 ? typeface : Typeface.create(typeface, i11);
    }

    public Typeface sc(com.bytedance.adsdk.pFF.zY.zY zYVar) {
        this.f26171sc.sc(zYVar.sc(), zYVar.zY());
        Typeface typeface = this.pFF.get(this.f26171sc);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceSc = sc(pFF(zYVar), zYVar.zY());
        this.pFF.put(this.f26171sc, typefaceSc);
        return typefaceSc;
    }

    public void sc(zY zYVar) {
        this.ExN = zYVar;
    }

    public void sc(String str) {
        this.TRI = str;
    }
}
