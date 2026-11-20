package com.vungle.warren;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.gson.annotations.SerializedName;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AdConfig extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("ordinal")
    private int f61698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("adOrientation")
    private int f61699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f61700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f61701g;

    /* JADX INFO: compiled from: source.java */
    @Keep
    public enum AdSize {
        VUNGLE_MREC("mrec", LogSeverity.NOTICE_VALUE, 250),
        VUNGLE_DEFAULT(TmcEngineFactory.ENGINE_TYPE_DEFAULT, -1, -1),
        BANNER("banner", 320, 50),
        BANNER_SHORT("banner_short", LogSeverity.NOTICE_VALUE, 50),
        BANNER_LEADERBOARD("banner_leaderboard", 728, 90);

        private final int height;
        private final String name;
        private final int width;

        AdSize(String str, int i11, int i12) {
            this.width = i11;
            this.height = i12;
            this.name = str;
        }

        public static AdSize fromName(String str) {
            for (AdSize adSize : values()) {
                if (adSize.name.equals(str)) {
                    return adSize;
                }
            }
            return VUNGLE_DEFAULT;
        }

        public static boolean isBannerAdSize(@NonNull AdSize adSize) {
            return adSize == BANNER || adSize == BANNER_LEADERBOARD || adSize == BANNER_SHORT || adSize == VUNGLE_MREC;
        }

        public static boolean isDefaultAdSize(@NonNull AdSize adSize) {
            return adSize == VUNGLE_DEFAULT || adSize == VUNGLE_MREC;
        }

        public static boolean isNonMrecBannerAdSize(@NonNull AdSize adSize) {
            return adSize != VUNGLE_MREC && isBannerAdSize(adSize);
        }

        public int getHeight() {
            return this.height;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public AdConfig() {
        this.f61699e = 2;
        this.f61701g = 1;
    }

    public AdConfig(e eVar) {
        super(eVar);
        this.f61699e = 2;
        this.f61701g = 1;
    }

    @Override // com.vungle.warren.e
    public /* bridge */ /* synthetic */ AdSize a() {
        return super.a();
    }

    @Override // com.vungle.warren.e
    public /* bridge */ /* synthetic */ int b() {
        return super.b();
    }

    @Override // com.vungle.warren.e
    public /* bridge */ /* synthetic */ void c(AdSize adSize) {
        super.c(adSize);
    }

    @Override // com.vungle.warren.e
    public /* bridge */ /* synthetic */ void d(boolean z11) {
        super.d(z11);
    }

    public int e() {
        return this.f61699e;
    }

    public int f() {
        return this.f61698d;
    }
}
