package com.vungle.warren.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.utility.i;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class FilePreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f62245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f62246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f62247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f62248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<String> f62249e;

    public FilePreferences(Context context, Executor executor) throws Throwable {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.f62247c = concurrentHashMap;
        this.f62249e = new HashSet<>();
        this.f62246b = executor;
        File file = new File(context.getNoBackupFilesDir(), "vungle_settings");
        this.f62245a = file;
        File file2 = new File(context.getFilesDir(), "vungle_settings");
        if (file2.exists() && !file2.renameTo(file)) {
            VungleLogger.c("FilePreferences", "Can't move old FilePreferences");
        }
        Object objG = i.g(file);
        if (objG instanceof HashMap) {
            concurrentHashMap.putAll((HashMap) objG);
        }
        this.f62248d = context.getSharedPreferences("com.vungle.sdk", 0);
        h();
    }

    public FilePreferences b(@NonNull String... strArr) {
        this.f62249e.addAll(Arrays.asList(strArr));
        return this;
    }

    public void c() {
        final HashMap map = new HashMap(this.f62247c);
        this.f62246b.execute(new Runnable() { // from class: com.vungle.warren.persistence.FilePreferences.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                i.j(FilePreferences.this.f62245a, map);
            }
        });
    }

    public boolean d(String str, boolean z11) {
        Object obj = this.f62247c.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z11;
    }

    public int e(String str, int i11) {
        Object obj = this.f62247c.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i11;
    }

    public String f(String str, String str2) {
        Object obj = this.f62247c.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public HashSet<String> g(String str, HashSet<String> hashSet) {
        Object obj = this.f62247c.get(str);
        return obj instanceof HashSet ? com.vungle.warren.utility.c.b((HashSet) obj) : hashSet;
    }

    public final void h() {
        for (Map.Entry<String, ?> entry : this.f62248d.getAll().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Boolean) {
                l(entry.getKey(), ((Boolean) value).booleanValue());
            } else if (value instanceof String) {
                j(entry.getKey(), (String) value);
            } else if (value instanceof Integer) {
                i(entry.getKey(), ((Integer) value).intValue());
            } else if (value instanceof HashSet) {
                k(entry.getKey(), (HashSet) value);
            }
        }
        this.f62248d.edit().clear().apply();
        c();
    }

    public FilePreferences i(@NonNull String str, int i11) {
        this.f62247c.put(str, Integer.valueOf(i11));
        if (this.f62249e.contains(str)) {
            this.f62248d.edit().putInt(str, i11).apply();
        }
        return this;
    }

    public FilePreferences j(@NonNull String str, @NonNull String str2) {
        this.f62247c.put(str, str2);
        if (this.f62249e.contains(str)) {
            this.f62248d.edit().putString(str, str2).apply();
        }
        return this;
    }

    public FilePreferences k(@NonNull String str, @NonNull HashSet<String> hashSet) {
        this.f62247c.put(str, com.vungle.warren.utility.c.b(hashSet));
        if (this.f62249e.contains(str)) {
            this.f62248d.edit().putStringSet(str, com.vungle.warren.utility.c.b(hashSet)).apply();
        }
        return this;
    }

    public FilePreferences l(@NonNull String str, boolean z11) {
        this.f62247c.put(str, Boolean.valueOf(z11));
        if (this.f62249e.contains(str)) {
            this.f62248d.edit().putBoolean(str, z11).apply();
        }
        return this;
    }
}
