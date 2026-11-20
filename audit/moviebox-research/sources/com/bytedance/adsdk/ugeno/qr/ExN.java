package com.bytedance.adsdk.ugeno.qr;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    private static boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static Field f26440sc;

    public static Drawable sc(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!pFF) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f26440sc = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            pFF = true;
        }
        Field field = f26440sc;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                f26440sc = null;
            }
        }
        return null;
    }
}
