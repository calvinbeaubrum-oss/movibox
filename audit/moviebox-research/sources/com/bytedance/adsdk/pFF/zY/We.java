package com.bytedance.adsdk.pFF.zY;

import com.bytedance.adsdk.pFF.zY.pFF.dE;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class We {
    private final String ExN;
    private final String TRI;
    private final double We;
    private final char pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<dE> f26228sc;
    private final double zY;

    public We(List<dE> list, char c11, double d11, double d12, String str, String str2) {
        this.f26228sc = list;
        this.pFF = c11;
        this.zY = d11;
        this.We = d12;
        this.ExN = str;
        this.TRI = str2;
    }

    public static int sc(char c11, String str, String str2) {
        return (((c11 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public int hashCode() {
        return sc(this.pFF, this.TRI, this.ExN);
    }

    public double pFF() {
        return this.We;
    }

    public List<dE> sc() {
        return this.f26228sc;
    }
}
