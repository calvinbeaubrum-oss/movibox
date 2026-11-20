package com.pgl.ssdk.ces.out;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class PglSSConfig {
    public static final int COLLECT_MODE_DEFAULT = 0;
    public static final int COLLECT_MODE_ML_MINIMIZE = 1;
    public static final String CUSTOMINFO_KEY_CHECKCLAZZ = "check_clz";
    public static final int OVREGION_TYPE_CN = 2;
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f48754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f48755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f48756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f48757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Object> f48758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f48759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f48760g;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f48761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f48762b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f48763c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f48764d;

        public PglSSConfig build() {
            if (TextUtils.isEmpty(this.f48761a)) {
                return null;
            }
            int i11 = this.f48762b;
            if (i11 != 2 && i11 != 1 && i11 != 0) {
                return null;
            }
            int i12 = this.f48763c;
            if (i12 == 0 || i12 == 1) {
                return new PglSSConfig(this.f48761a, i11, i12, this.f48764d);
            }
            return null;
        }

        public Builder setAdsdkVersion(String str) {
            this.f48764d = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.f48761a = str;
            return this;
        }

        public Builder setCollectMode(int i11) {
            this.f48763c = i11;
            return this;
        }

        public Builder setOVRegionType(int i11) {
            this.f48762b = i11;
            return this;
        }
    }

    private PglSSConfig(String str, int i11, int i12, String str2) {
        this.f48756c = str;
        this.f48754a = i11;
        this.f48755b = i12;
        this.f48757d = str2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAdSdkVersion() {
        return this.f48757d;
    }

    public String getAppId() {
        return this.f48756c;
    }

    public String getCnReportUrl() {
        return this.f48759f;
    }

    public String getCnTokenUrl() {
        return this.f48760g;
    }

    public int getCollectMode() {
        return this.f48755b;
    }

    public Map<String, Object> getCustomInfo() {
        return this.f48758e;
    }

    public int getOVRegionType() {
        return this.f48754a;
    }

    public void setCnReportUrl(String str) {
        this.f48759f = str;
    }

    public void setCnTokenUrl(String str) {
        this.f48760g = str;
    }

    public void setCustomInfo(Map<String, Object> map) {
        this.f48758e = map;
    }
}
