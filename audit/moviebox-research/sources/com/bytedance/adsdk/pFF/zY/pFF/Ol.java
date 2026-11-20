package com.bytedance.adsdk.pFF.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol implements zY {
    private final sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26235sc;
    private final boolean zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static sc sc(int i11) {
            if (i11 == 1) {
                return MERGE;
            }
            if (i11 == 2) {
                return ADD;
            }
            if (i11 == 3) {
                return SUBTRACT;
            }
            if (i11 != 4) {
                return i11 != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public Ol(String str, sc scVar, boolean z11) {
        this.f26235sc = str;
        this.pFF = scVar;
        this.zY = z11;
    }

    public sc pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.Tf(this);
    }

    public String sc() {
        return this.f26235sc;
    }

    public String toString() {
        return "MergePaths{mode=" + this.pFF + '}';
    }

    public boolean zY() {
        return this.zY;
    }
}
