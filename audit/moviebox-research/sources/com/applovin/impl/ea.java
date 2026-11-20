package com.applovin.impl;

import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f18675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18676b;

    public ea(Map map, com.applovin.impl.sdk.j jVar) {
        this.f18675a = map == null ? Collections.emptyMap() : map;
        this.f18676b = jVar;
    }

    private boolean a(Object obj) {
        return (obj instanceof String) && StringUtils.isValidString((String) obj);
    }

    public Drawable a() {
        Object obj = this.f18675a.get("google_watermark");
        if (!a(obj)) {
            this.f18676b.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18676b.J().b("GoogleWatermarkGenerator", "Unable to render invalid watermark: " + obj);
            }
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode((String) obj, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.applovin.impl.sdk.j.l().getResources(), BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            return bitmapDrawable;
        } catch (Throwable th2) {
            this.f18676b.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18676b.J().a("GoogleWatermarkGenerator", "Failed to render watermark", th2);
            }
            return null;
        }
    }

    public String b() {
        return "google watermark";
    }

    public boolean c() {
        return a(this.f18675a.get("google_watermark"));
    }
}
