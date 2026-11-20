package xq;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f80674a = new g();

    public static /* synthetic */ void b(g gVar, FragmentManager fragmentManager, int i11, Fragment fragment, boolean z11, String str, int i12, Object obj) {
        boolean z12 = (i12 & 8) != 0 ? false : z11;
        if ((i12 & 16) != 0) {
            str = fragment.getClass().getSimpleName();
        }
        gVar.a(fragmentManager, i11, fragment, z12, str);
    }

    public final void a(FragmentManager fragmentManager, int i11, Fragment fragment, boolean z11, String str) {
        Intrinsics.g(fragmentManager, "fragmentManager");
        Intrinsics.g(fragment, "fragment");
        if (fragmentManager.isStateSaved() || fragmentManager.isDestroyed()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = str != null ? fragmentManager.findFragmentByTag(str) : null;
        if (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isAdded()) {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
            fragmentTransactionBeginTransaction.replace(i11, fragment, str);
            if (z11) {
                fragmentTransactionBeginTransaction.addToBackStack(str);
            }
            c(fragmentManager, fragmentTransactionBeginTransaction);
        }
    }

    public final void c(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction) {
        if (fragmentManager.isStateSaved() || fragmentManager.isDestroyed()) {
            return;
        }
        try {
            fragmentTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        }
    }
}
