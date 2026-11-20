package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class gq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19290a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f19291b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f19292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f19293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19295f;

    public static ImageView a(Uri uri, Context context, com.applovin.impl.sdk.j jVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        ImageViewUtils.setImageUri(imageView, uri, jVar);
        return imageView;
    }

    public static gq a(es esVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        es esVarC = esVar.c("StaticResource");
        if (esVarC == null || !URLUtil.isValidUrl(esVarC.d())) {
            jVar.J();
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            jVar.J().b("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
            return null;
        }
        gq gqVar = new gq();
        gqVar.f19292c = Uri.parse(esVarC.d());
        es esVarB = esVar.b("IconClickThrough");
        if (esVarB != null && URLUtil.isValidUrl(esVarB.d())) {
            gqVar.f19293d = Uri.parse(esVarB.d());
        }
        String str = (String) esVar.a().get("width");
        int i11 = 0;
        int i12 = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
        String str2 = (String) esVar.a().get("height");
        if (str2 != null && Integer.parseInt(str2) > 0) {
            i11 = Integer.parseInt(str2);
        }
        int iIntValue = ((Integer) jVar.a(sj.T4)).intValue();
        if (i12 <= 0 || i11 <= 0) {
            gqVar.f19295f = iIntValue;
            gqVar.f19294e = iIntValue;
        } else {
            double d11 = i12 / i11;
            int iMin = Math.min(Math.max(i12, i11), iIntValue);
            if (i12 >= i11) {
                gqVar.f19294e = iMin;
                gqVar.f19295f = (int) (((double) iMin) / d11);
            } else {
                gqVar.f19295f = iMin;
                gqVar.f19294e = (int) (((double) iMin) * d11);
            }
        }
        return gqVar;
    }

    public Set a() {
        return this.f19290a;
    }

    public Uri b() {
        return this.f19293d;
    }

    public int c() {
        return this.f19295f;
    }

    public Uri d() {
        return this.f19292c;
    }

    public Set e() {
        return this.f19291b;
    }

    public int f() {
        return this.f19294e;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + d() + "', clickUri='" + b() + "', width=" + f() + ", height=" + c() + "}";
    }
}
