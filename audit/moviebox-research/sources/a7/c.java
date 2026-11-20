package a7;

import c7.k;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f429f;

    public c(List<k> list, char c11, double d11, double d12, String str, String str2) {
        this.f424a = list;
        this.f425b = c11;
        this.f426c = d11;
        this.f427d = d12;
        this.f428e = str;
        this.f429f = str2;
    }

    public static int c(char c11, String str, String str2) {
        return (((c11 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<k> a() {
        return this.f424a;
    }

    public double b() {
        return this.f427d;
    }

    public int hashCode() {
        return c(this.f425b, this.f429f, this.f428e);
    }
}
