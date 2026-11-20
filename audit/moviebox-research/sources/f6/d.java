package f6;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f64645d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f64646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f64647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f64648c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final d a(e owner) {
            Intrinsics.g(owner, "owner");
            return new d(owner, null);
        }
    }

    public d(e eVar) {
        this.f64646a = eVar;
        this.f64647b = new c();
    }

    public /* synthetic */ d(e eVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar);
    }

    @JvmStatic
    public static final d a(e eVar) {
        return f64645d.a(eVar);
    }

    public final c b() {
        return this.f64647b;
    }

    public final void c() {
        Lifecycle lifecycle = this.f64646a.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new f6.a(this.f64646a));
        this.f64647b.e(lifecycle);
        this.f64648c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f64648c) {
            c();
        }
        Lifecycle lifecycle = this.f64646a.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f64647b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        Intrinsics.g(outBundle, "outBundle");
        this.f64647b.g(outBundle);
    }
}
