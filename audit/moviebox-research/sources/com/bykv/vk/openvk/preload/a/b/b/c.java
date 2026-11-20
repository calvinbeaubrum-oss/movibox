package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.i;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f25505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f25506b = b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Field f25507c = c();

    private static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f25505a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean b(AccessibleObject accessibleObject) {
        if (this.f25506b != null && this.f25507c != null) {
            try {
                f25505a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f25506b, accessibleObject, Long.valueOf(((Long) f25505a.getMethod("objectFieldOffset", Field.class).invoke(this.f25506b, this.f25507c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.b.b.b
    public final void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e11) {
            throw new i("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e11);
        }
    }
}
