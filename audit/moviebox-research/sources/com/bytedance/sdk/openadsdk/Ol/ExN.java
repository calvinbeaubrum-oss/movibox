package com.bytedance.sdk.openadsdk.Ol;

import com.bytedance.sdk.component.ExN.Ol;
import com.bytedance.sdk.component.ExN.YIK;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements YIK {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static int f27103sc;
    private final String ExN;
    private boolean We;
    private long pFF = 0;
    private long zY;

    public ExN() {
        f27103sc++;
        this.ExN = "image_request_" + f27103sc;
    }

    private String zY(String str, Ol ol2) {
        com.bytedance.sdk.component.ExN.zY.sc scVarWjp;
        if (str != null) {
            switch (str) {
                case "success":
                    return "success";
                case "raw_cache":
                    return "raw cache";
                case "image_type":
                    return "image type：";
                case "disk_cache":
                    return "disk cache";
                case "decode":
                    return "decode";
                case "failed":
                    if (!(ol2 instanceof com.bytedance.sdk.component.ExN.zY.zY) || (scVarWjp = ((com.bytedance.sdk.component.ExN.zY.zY) ol2).wjp()) == null) {
                        return "fail";
                    }
                    Throwable thZY = scVarWjp.zY();
                    StringBuilder sb2 = new StringBuilder("fail：code:");
                    sb2.append(scVarWjp.sc());
                    sb2.append(", msg:");
                    sb2.append(scVarWjp.pFF());
                    sb2.append(", exception:");
                    sb2.append(thZY != null ? thZY.getMessage() : "null \r\n");
                    return sb2.toString();
                case "check_duplicate":
                    return "duplicate request";
                case "memory_cache":
                    return "memory cache";
                case "net_request":
                    return "net request";
                case "generate_key":
                    return "generate key:" + ol2.ExN();
                case "cache_policy":
                    return "cache policy";
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.ExN.YIK
    public void pFF(String str, Ol ol2) {
        this.zY += System.currentTimeMillis() - this.pFF;
        zY(str, ol2);
    }

    @Override // com.bytedance.sdk.component.ExN.YIK
    public void sc(String str, Ol ol2) {
        if (!this.We) {
            ol2.sc();
            ol2.pFF();
            ol2.zY();
            this.We = true;
        }
        this.pFF = System.currentTimeMillis();
        zY(str, ol2);
    }
}
