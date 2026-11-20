package com.applovin.mediation.nativeAds.adPlacer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.n;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f25018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f25019c = new TreeSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25020d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25021e = 256;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25022f = 4;

    public MaxAdPlacerSettings(String str) {
        this.f25017a = str;
    }

    public void addFixedPosition(int i11) {
        this.f25019c.add(Integer.valueOf(i11));
    }

    public String getAdUnitId() {
        return this.f25017a;
    }

    public Set<Integer> getFixedPositions() {
        return this.f25019c;
    }

    public int getMaxAdCount() {
        return this.f25021e;
    }

    public int getMaxPreloadedAdCount() {
        return this.f25022f;
    }

    @Nullable
    public String getPlacement() {
        return this.f25018b;
    }

    public int getRepeatingInterval() {
        return this.f25020d;
    }

    public boolean hasValidPositioning() {
        return !this.f25019c.isEmpty() || isRepeatingEnabled();
    }

    public boolean isRepeatingEnabled() {
        return this.f25020d >= 2;
    }

    public void resetFixedPositions() {
        this.f25019c.clear();
    }

    public void setMaxAdCount(int i11) {
        this.f25021e = i11;
    }

    public void setMaxPreloadedAdCount(int i11) {
        this.f25022f = i11;
    }

    public void setPlacement(@Nullable String str) {
        this.f25018b = str;
    }

    public void setRepeatingInterval(int i11) {
        if (i11 >= 2) {
            this.f25020d = i11;
            n.g("MaxAdPlacerSettings", "Repeating interval set to " + i11);
            return;
        }
        this.f25020d = 0;
        n.j("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i11 + ", which is less than minimum value of 2");
    }

    @NonNull
    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.f25017a + "', fixedPositions=" + this.f25019c + ", repeatingInterval=" + this.f25020d + ", maxAdCount=" + this.f25021e + ", maxPreloadedAdCount=" + this.f25022f + '}';
    }
}
