package y00;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f81040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f81042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f81043d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f81044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f81045g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f81046h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f81047i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f81048j = 0;

    public g(@NonNull String str) {
        this.f81040a = str;
    }

    public g a() {
        try {
            return (g) super.clone();
        } catch (CloneNotSupportedException e11) {
            Log.e("JobInfo", Log.getStackTraceString(e11));
            return null;
        }
    }

    public long b() {
        return this.f81042c;
    }

    public Bundle c() {
        return this.f81045g;
    }

    public String d() {
        return this.f81040a;
    }

    public int f() {
        return this.f81047i;
    }

    public int g() {
        return this.f81048j;
    }

    public boolean h() {
        return this.f81041b;
    }

    public long j() {
        long j11 = this.f81043d;
        if (j11 == 0) {
            return 0L;
        }
        long j12 = this.f81044f;
        if (j12 == 0) {
            this.f81044f = j11;
        } else if (this.f81046h == 1) {
            this.f81044f = j12 * 2;
        }
        return this.f81044f;
    }

    public g k(long j11) {
        this.f81042c = j11;
        return this;
    }

    public g l(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.f81045g = bundle;
        }
        return this;
    }

    public g m(int i11) {
        this.f81047i = i11;
        return this;
    }

    public g n(int i11) {
        this.f81048j = i11;
        return this;
    }

    public g o(long j11, int i11) {
        this.f81043d = j11;
        this.f81046h = i11;
        return this;
    }

    public g p(boolean z11) {
        this.f81041b = z11;
        return this;
    }
}
