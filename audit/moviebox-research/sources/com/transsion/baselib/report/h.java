package com.transsion.baselib.report;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f51252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f51253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f51254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f51255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f51256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f51257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f51258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f51259j;

    public h(String pageName, boolean z11) {
        Intrinsics.g(pageName, "pageName");
        this.f51250a = pageName;
        this.f51251b = z11;
        this.f51252c = new HashMap<>();
        this.f51254e = "";
        this.f51256g = true;
        this.f51257h = -1L;
    }

    public /* synthetic */ h(String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? true : z11);
    }

    public final String a() {
        return this.f51253d;
    }

    public final boolean b() {
        return this.f51251b;
    }

    public final boolean c() {
        return this.f51255f;
    }

    public final boolean d() {
        return this.f51256g;
    }

    public final String e() {
        return this.f51259j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.b(this.f51250a, hVar.f51250a) && this.f51251b == hVar.f51251b;
    }

    public final String f() {
        return this.f51250a;
    }

    public final HashMap<String, String> g() {
        return this.f51252c;
    }

    public final long h() {
        return this.f51257h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f51250a.hashCode() * 31;
        boolean z11 = this.f51251b;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final boolean i() {
        return this.f51258i;
    }

    public final void j(boolean z11) {
        this.f51258i = z11;
    }

    public final void k(boolean z11) {
        this.f51255f = z11;
    }

    public final void l(boolean z11) {
        this.f51256g = z11;
    }

    public final void m(String str) {
        this.f51259j = str;
    }

    public final void n(long j11) {
        this.f51257h = j11;
    }

    public String toString() {
        return "LogViewConfig(pageName=" + this.f51250a + ", needAddToPageFrom=" + this.f51251b + ")";
    }
}
