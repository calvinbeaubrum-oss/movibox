package com.bytedance.sdk.component.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static WH f26553sc = new WH() { // from class: com.bytedance.sdk.component.Qj.ExN.1
        @Override // com.bytedance.sdk.component.Qj.WH
        public Ol createThreadFactory(int i11, String str) {
            return new Ol(i11, str);
        }
    };

    public static WH sc() {
        return f26553sc;
    }

    public static void sc(WH wh2) {
        f26553sc = wh2;
    }
}
