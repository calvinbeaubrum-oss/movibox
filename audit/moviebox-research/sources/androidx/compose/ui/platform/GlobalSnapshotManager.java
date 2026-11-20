package androidx.compose.ui.platform;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class GlobalSnapshotManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlobalSnapshotManager f5332a = new GlobalSnapshotManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f5333b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f5334c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5335d = 8;

    public final void b() {
        if (f5333b.compareAndSet(false, true)) {
            final kotlinx.coroutines.channels.a aVarB = kotlinx.coroutines.channels.d.b(1, null, null, 6, null);
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(AndroidUiDispatcher.f5280l.b()), null, null, new GlobalSnapshotManager$ensureStarted$1(aVarB, null), 3, null);
            androidx.compose.runtime.snapshots.j.f3684e.k(new Function1<Object, Unit>() { // from class: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(obj);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    if (GlobalSnapshotManager.f5334c.compareAndSet(false, true)) {
                        aVarB.f(Unit.f68710a);
                    }
                }
            });
        }
    }
}
