package com.bytedance.sdk.openadsdk.We;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    private long ExN;
    private long We;
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27376sc;
    private long zY;

    public void ExN(long j11) {
        if (this.ExN <= 0) {
            this.ExN = j11;
        }
    }

    public void We(long j11) {
        if (this.We <= 0) {
            this.We = j11;
        }
    }

    public JSONObject pFF() {
        return sc((JSONObject) null);
    }

    public void pFF(long j11) {
        if (this.pFF <= 0) {
            this.pFF = j11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:12:0x0031 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x003c A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:6:0x0010 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001b A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    public JSONObject sc(JSONObject jSONObject) {
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                j11 = this.f27376sc;
                if (j11 > 0) {
                    jSONObject.put("show_start", j11);
                    j12 = this.pFF;
                    if (j12 > 0) {
                        jSONObject.put("show_firstQuartile", j12);
                        j13 = this.zY;
                        if (j13 > 0) {
                            jSONObject.put("show_mid", j13);
                            j14 = this.We;
                            if (j14 > 0) {
                                jSONObject.put("show_thirdQuartile", j14);
                                j15 = this.ExN;
                                if (j15 > 0) {
                                    jSONObject.put("show_full", j15);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            j11 = this.f27376sc;
            if (j11 > 0) {
                jSONObject.put("show_start", j11);
                j12 = this.pFF;
                if (j12 > 0) {
                    jSONObject.put("show_firstQuartile", j12);
                    j13 = this.zY;
                    if (j13 > 0) {
                        jSONObject.put("show_mid", j13);
                        j14 = this.We;
                        if (j14 > 0) {
                            jSONObject.put("show_thirdQuartile", j14);
                            j15 = this.ExN;
                            if (j15 > 0) {
                                jSONObject.put("show_full", j15);
                            }
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public void sc(long j11) {
        if (this.f27376sc <= 0) {
            this.f27376sc = j11;
        }
    }

    public void sc(long j11, float f11) {
        if (f11 > 0.0f) {
            sc(j11);
        }
        double d11 = f11;
        if (d11 >= 0.25d) {
            sc(j11);
            pFF(j11);
        }
        if (d11 >= 0.5d) {
            sc(j11);
            pFF(j11);
            zY(j11);
        }
        if (d11 >= 0.75d) {
            sc(j11);
            pFF(j11);
            zY(j11);
            We(j11);
        }
        if (f11 >= 1.0f) {
            sc(j11);
            pFF(j11);
            zY(j11);
            We(j11);
            ExN(j11);
        }
    }

    public boolean sc() {
        return this.f27376sc > 0;
    }

    public void zY(long j11) {
        if (this.zY <= 0) {
            this.zY = j11;
        }
    }
}
