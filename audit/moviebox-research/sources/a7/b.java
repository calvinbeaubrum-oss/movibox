package a7;

import android.graphics.Typeface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Typeface f423e;

    public b(String str, String str2, String str3, float f11) {
        this.f419a = str;
        this.f420b = str2;
        this.f421c = str3;
        this.f422d = f11;
    }

    public String a() {
        return this.f419a;
    }

    public String b() {
        return this.f420b;
    }

    public String c() {
        return this.f421c;
    }

    @Nullable
    public Typeface d() {
        return this.f423e;
    }

    public void e(@Nullable Typeface typeface) {
        this.f423e = typeface;
    }
}
