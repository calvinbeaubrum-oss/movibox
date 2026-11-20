package ke;

import android.content.Context;
import com.tencent.mmkv.MMKV;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a implements le.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MMKV f68541a;

    public a(Context context, String fileName, boolean z11, String str) {
        Intrinsics.g(context, "context");
        Intrinsics.g(fileName, "fileName");
        MMKV mmkvB = MMKV.B(fileName, z11 ? 2 : 1, str);
        Intrinsics.f(mmkvB, "mmkvWithID(\n            …       cryptKey\n        )");
        this.f68541a = mmkvB;
    }

    public /* synthetic */ a(Context context, String str, boolean z11, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? "global_Z2xvYmFs" : str, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : str2);
    }

    public void a() {
        this.f68541a.clearAll();
    }

    public boolean b(String key, boolean z11) {
        Intrinsics.g(key, "key");
        return this.f68541a.c(key, z11);
    }

    public MMKV c() {
        return this.f68541a;
    }

    public boolean d(String key, boolean z11) {
        Intrinsics.g(key, "key");
        return this.f68541a.r(key, z11);
    }

    public boolean e(String key, int i11) {
        Intrinsics.g(key, "key");
        return this.f68541a.n(key, i11);
    }

    public boolean f(String key, long j11) {
        Intrinsics.g(key, "key");
        return this.f68541a.o(key, j11);
    }

    public boolean g(String key, String value) {
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        return this.f68541a.p(key, value);
    }

    @Override // le.a
    public int getInt(String key, int i11) {
        Intrinsics.g(key, "key");
        return this.f68541a.d(key, i11);
    }

    @Override // le.a
    public long getLong(String key, long j11) {
        Intrinsics.g(key, "key");
        return this.f68541a.e(key, j11);
    }

    @Override // le.a
    public String getString(String key, String str) {
        Intrinsics.g(key, "key");
        return this.f68541a.g(key, str);
    }

    public void h(String key) {
        Intrinsics.g(key, "key");
        this.f68541a.D(key);
    }
}
