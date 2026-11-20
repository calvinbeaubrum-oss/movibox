package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<Object> f12239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12242d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o<Object> f12243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f12245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12246d;

        public final d a() {
            o<Object> oVarC = this.f12243a;
            if (oVarC == null) {
                oVarC = o.f12313c.c(this.f12245c);
            }
            return new d(oVarC, this.f12244b, this.f12245c, this.f12246d);
        }

        public final a b(Object obj) {
            this.f12245c = obj;
            this.f12246d = true;
            return this;
        }

        public final a c(boolean z11) {
            this.f12244b = z11;
            return this;
        }

        public final <T> a d(o<T> type) {
            Intrinsics.g(type, "type");
            this.f12243a = type;
            return this;
        }
    }

    public d(o<Object> type, boolean z11, Object obj, boolean z12) {
        Intrinsics.g(type, "type");
        if (!type.c() && z11) {
            throw new IllegalArgumentException(Intrinsics.p(type.b(), " does not allow nullable values").toString());
        }
        if (!z11 && z12 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + type.b() + " has null value but is not nullable.").toString());
        }
        this.f12239a = type;
        this.f12240b = z11;
        this.f12242d = obj;
        this.f12241c = z12;
    }

    public final o<Object> a() {
        return this.f12239a;
    }

    public final boolean b() {
        return this.f12241c;
    }

    public final boolean c() {
        return this.f12240b;
    }

    public final void d(String name, Bundle bundle) {
        Intrinsics.g(name, "name");
        Intrinsics.g(bundle, "bundle");
        if (this.f12241c) {
            this.f12239a.f(bundle, name, this.f12242d);
        }
    }

    public final boolean e(String name, Bundle bundle) {
        Intrinsics.g(name, "name");
        Intrinsics.g(bundle, "bundle");
        if (!this.f12240b && bundle.containsKey(name) && bundle.get(name) == null) {
            return false;
        }
        try {
            this.f12239a.a(bundle, name);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(d.class, obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f12240b != dVar.f12240b || this.f12241c != dVar.f12241c || !Intrinsics.b(this.f12239a, dVar.f12239a)) {
            return false;
        }
        Object obj2 = this.f12242d;
        if (obj2 != null) {
            return Intrinsics.b(obj2, dVar.f12242d);
        }
        return dVar.f12242d == null;
    }

    public int hashCode() {
        int iHashCode = ((((this.f12239a.hashCode() * 31) + (this.f12240b ? 1 : 0)) * 31) + (this.f12241c ? 1 : 0)) * 31;
        Object obj = this.f12242d;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }
}
