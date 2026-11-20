package c1;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class i extends a<String, Boolean> {
    @Override // c1.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String input) {
        Intrinsics.g(context, "context");
        Intrinsics.g(input, "input");
        return h.f14547a.a(new String[]{input});
    }

    @Override // c1.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0152a<Boolean> b(Context context, String input) {
        Intrinsics.g(context, "context");
        Intrinsics.g(input, "input");
        if (z2.a.checkSelfPermission(context, input) == 0) {
            return new a.C0152a<>(Boolean.TRUE);
        }
        return null;
    }

    @Override // c1.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i11, Intent intent) {
        if (intent == null || i11 != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z11 = false;
        if (intArrayExtra != null) {
            for (int i12 : intArrayExtra) {
                if (i12 == 0) {
                    z11 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z11);
    }
}
