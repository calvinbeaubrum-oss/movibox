package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class vj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.applovin.impl.sdk.j f23915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SharedPreferences f23916c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f23917a;

    public vj(com.applovin.impl.sdk.j jVar) {
        this.f23917a = com.applovin.impl.sdk.j.l().getSharedPreferences("com.applovin.sdk.preferences." + jVar.b0(), 0);
        f23915b = jVar;
    }

    private static SharedPreferences a(Context context) {
        if (f23916c == null) {
            f23916c = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f23916c;
    }

    public static Object a(uj ujVar, Object obj, Context context) {
        return a(ujVar.a(), obj, ujVar.b(), a(context));
    }

    public static Object a(uj ujVar, Object obj, SharedPreferences sharedPreferences, boolean z11) {
        return a(ujVar.a(), obj, ujVar.b(), sharedPreferences, z11);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return a(str, obj, cls, sharedPreferences, true);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences, boolean z11) {
        Object stringSet;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!sharedPreferences.contains(str)) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return obj;
            }
            if (Boolean.class.equals(cls)) {
                stringSet = obj != null ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : Boolean.valueOf(sharedPreferences.getBoolean(str, false));
            } else if (Float.class.equals(cls)) {
                stringSet = obj != null ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
            } else if (Integer.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, obj.getClass().equals(Long.class) ? ((Long) obj).intValue() : ((Integer) obj).intValue()));
                } else {
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, 0));
                }
            } else if (Long.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, obj.getClass().equals(Integer.class) ? ((Integer) obj).longValue() : ((Long) obj).longValue()));
                } else {
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, 0L));
                }
            } else if (Double.class.equals(cls)) {
                stringSet = obj != null ? Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue())))) : Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, 0L)));
            } else if (String.class.equals(cls)) {
                stringSet = sharedPreferences.getString(str, (String) obj);
            } else {
                stringSet = Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) obj) : obj;
            }
            if (stringSet == null) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return obj;
            }
            Object objCast = cls.cast(stringSet);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return objCast;
        } catch (Throwable th2) {
            if (z11) {
                try {
                    com.applovin.impl.sdk.n.c("SharedPreferencesManager", "Error getting value for key: " + str, th2);
                } finally {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                }
            }
            return obj;
        }
    }

    private static void a(final SharedPreferences.Editor editor) {
        try {
            if (yp.h()) {
                com.applovin.impl.sdk.j jVar = f23915b;
                if (jVar == null || jVar.j0() == null) {
                    editor.apply();
                } else {
                    tm tmVarJ0 = f23915b.j0();
                    com.applovin.impl.sdk.j jVar2 = f23915b;
                    Objects.requireNonNull(editor);
                    tmVarJ0.a((yl) new jn(jVar2, true, "commitSharedPreferencesChanges", new Runnable() { // from class: com.applovin.impl.w70
                        @Override // java.lang.Runnable
                        public final void run() {
                            editor.commit();
                        }
                    }), tm.b.OTHER);
                }
            } else {
                editor.commit();
            }
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("SharedPreferencesManager", "Unable to apply changes", th2);
        }
    }

    public static void a(String str, Object obj, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z11 = editor != null;
        if (!z11) {
            editor = sharedPreferences.edit();
        }
        if (obj == null) {
            editor.remove(str);
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            editor.putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
        } else if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else {
            if (!(obj instanceof Set)) {
                com.applovin.impl.sdk.n.h("SharedPreferencesManager", "Unable to put default value of invalid type: " + obj);
                return;
            }
            editor.putStringSet(str, (Set) obj);
        }
        if (z11) {
            return;
        }
        a(editor);
    }

    public static void b(uj ujVar, Object obj, Context context) {
        a(ujVar.a(), obj, a(context), (SharedPreferences.Editor) null);
    }

    public Object a(uj ujVar) {
        Object objA = a(ujVar, null);
        b(ujVar);
        return objA;
    }

    public Object a(uj ujVar, Object obj) {
        return a(ujVar, obj, this.f23917a);
    }

    public Object a(uj ujVar, Object obj, SharedPreferences sharedPreferences) {
        return a(ujVar.a(), obj, ujVar.b(), sharedPreferences);
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        a(str, obj, (SharedPreferences) null, editor);
    }

    public void a(String str, Object obj, SharedPreferences sharedPreferences) {
        a(str, obj, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public void b(uj ujVar) {
        a(this.f23917a.edit().remove(ujVar.a()));
    }

    public void b(uj ujVar, Object obj) {
        b(ujVar, obj, this.f23917a);
    }

    public void b(uj ujVar, Object obj, SharedPreferences sharedPreferences) {
        a(ujVar.a(), obj, sharedPreferences);
    }
}
