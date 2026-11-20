package androidx.compose.runtime.snapshots;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class GlobalSnapshot extends b {
    /* JADX WARN: Illegal instructions before constructor call */
    public GlobalSnapshot(int i11, SnapshotIdSet snapshotIdSet) {
        Function1<Object, Unit> function1;
        synchronized (SnapshotKt.I()) {
            final List list = SnapshotKt.f3610i;
            function1 = (Function1) CollectionsKt___CollectionsKt.C0(list);
            function1 = function1 == null ? new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    List<Function1<Object, Unit>> list2 = list;
                    int size = list2.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        list2.get(i12).invoke(obj);
                    }
                }
            } : function1;
        }
        super(i11, snapshotIdSet, null, function1);
    }

    @Override // androidx.compose.runtime.snapshots.b
    public k C() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.b
    public b Q(final Function1<Object, Unit> function1, final Function1<Object, Unit> function2) {
        return (b) SnapshotKt.b0(new Function1<SnapshotIdSet, b>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final b invoke(SnapshotIdSet snapshotIdSet) {
                int i11;
                synchronized (SnapshotKt.I()) {
                    i11 = SnapshotKt.f3606e;
                    SnapshotKt.f3606e = i11 + 1;
                }
                return new b(i11, snapshotIdSet, function1, function2);
            }
        });
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void d() {
        synchronized (SnapshotKt.I()) {
            q();
            Unit unit = Unit.f68710a;
        }
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void o() {
        SnapshotKt.B();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public j x(final Function1<Object, Unit> function1) {
        return SnapshotKt.b0(new Function1<SnapshotIdSet, g>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final g invoke(SnapshotIdSet snapshotIdSet) {
                int i11;
                synchronized (SnapshotKt.I()) {
                    i11 = SnapshotKt.f3606e;
                    SnapshotKt.f3606e = i11 + 1;
                }
                return new g(i11, snapshotIdSet, function1);
            }
        });
    }
}
