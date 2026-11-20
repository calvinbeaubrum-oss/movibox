package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.layout.m;
import androidx.compose.ui.text.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f2995c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2996d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f2997e = new i(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f2998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f2999b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return i.f2997e;
        }
    }

    public i(m mVar, a0 a0Var) {
        this.f2998a = mVar;
        this.f2999b = a0Var;
    }

    public static /* synthetic */ i c(i iVar, m mVar, a0 a0Var, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i11 & 1) != 0) {
            mVar = iVar.f2998a;
        }
        if ((i11 & 2) != 0) {
            a0Var = iVar.f2999b;
        }
        return iVar.b(mVar, a0Var);
    }

    public final i b(m mVar, a0 a0Var) {
        return new i(mVar, a0Var);
    }

    public final m d() {
        return this.f2998a;
    }

    public final a0 e() {
        return this.f2999b;
    }
}
