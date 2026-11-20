package com.transsion.room.fragment;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RoomListFragment$checkGPS$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RoomListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomListFragment$checkGPS$1$1(RoomListFragment roomListFragment) {
        super(1);
        this.this$0 = roomListFragment;
    }

    public static final void b(RoomListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.K1();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(boolean z11) {
        SwipeRefreshLayout root;
        uo.b.a.f(uo.b.f78622a, "RoomLocation", "openGPS result:" + z11, false, 4, null);
        sw.m mVar = (sw.m) this.this$0.getMViewBinding();
        if (mVar != null && (root = mVar.getRoot()) != null) {
            final RoomListFragment roomListFragment = this.this$0;
            root.post(new Runnable() { // from class: com.transsion.room.fragment.k0
                @Override // java.lang.Runnable
                public final void run() {
                    RoomListFragment$checkGPS$1$1.b(roomListFragment);
                }
            });
        }
        this.this$0.K0();
        RoomListBaseFragment.r1(this.this$0, false, 1, null);
    }
}
