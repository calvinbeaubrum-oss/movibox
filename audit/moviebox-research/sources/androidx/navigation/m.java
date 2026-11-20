package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12308c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12312g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l.a f12306a = new l.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12309d = -1;

    public final void a(Function1<? super a, Unit> animBuilder) {
        Intrinsics.g(animBuilder, "animBuilder");
        a aVar = new a();
        animBuilder.invoke(aVar);
        this.f12306a.b(aVar.a()).c(aVar.b()).e(aVar.c()).f(aVar.d());
    }

    public final l b() {
        l.a aVar = this.f12306a;
        aVar.d(c());
        aVar.j(f());
        if (e() != null) {
            aVar.h(e(), this.f12311f, this.f12312g);
        } else {
            aVar.g(d(), this.f12311f, this.f12312g);
        }
        return aVar.a();
    }

    public final boolean c() {
        return this.f12307b;
    }

    public final int d() {
        return this.f12309d;
    }

    public final String e() {
        return this.f12310e;
    }

    public final boolean f() {
        return this.f12308c;
    }

    public final void g(int i11, Function1<? super s, Unit> popUpToBuilder) {
        Intrinsics.g(popUpToBuilder, "popUpToBuilder");
        i(i11);
        j(null);
        s sVar = new s();
        popUpToBuilder.invoke(sVar);
        this.f12311f = sVar.a();
        this.f12312g = sVar.b();
    }

    public final void h(boolean z11) {
        this.f12307b = z11;
    }

    public final void i(int i11) {
        this.f12309d = i11;
        this.f12311f = false;
    }

    public final void j(String str) {
        if (str != null) {
            if (!(!kotlin.text.l.y(str))) {
                throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
            }
            this.f12310e = str;
            this.f12311f = false;
        }
    }
}
