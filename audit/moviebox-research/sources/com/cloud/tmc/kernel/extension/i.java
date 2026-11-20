package com.cloud.tmc.kernel.extension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<? extends BridgeExtension> f31195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<? extends com.cloud.tmc.kernel.node.d> f31196b;

    public static i a(Class<? extends BridgeExtension> cls) {
        return b(cls, null);
    }

    public static i b(Class<? extends BridgeExtension> cls, Class<? extends com.cloud.tmc.kernel.node.d> cls2) {
        i iVar = new i();
        iVar.f31195a = cls;
        iVar.f31196b = cls2;
        return iVar;
    }

    public String toString() {
        return "BridgeExtensionManifest{target=" + this.f31195a + ", scope=" + this.f31196b + '}';
    }
}
