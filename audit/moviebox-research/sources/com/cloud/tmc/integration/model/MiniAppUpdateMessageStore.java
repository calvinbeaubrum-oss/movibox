package com.cloud.tmc.integration.model;

import bc.a;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class MiniAppUpdateMessageStore extends b {
    private final WeakHashMap<String, a> onCheckForUpdate;
    private final WeakHashMap<String, a> onUpdateFailed;
    private final WeakHashMap<String, a> onUpdateReady;

    public MiniAppUpdateMessageStore() {
        this(null, null, null, 7, null);
    }

    public MiniAppUpdateMessageStore(WeakHashMap<String, a> onCheckForUpdate, WeakHashMap<String, a> onUpdateFailed, WeakHashMap<String, a> onUpdateReady) {
        Intrinsics.g(onCheckForUpdate, "onCheckForUpdate");
        Intrinsics.g(onUpdateFailed, "onUpdateFailed");
        Intrinsics.g(onUpdateReady, "onUpdateReady");
        this.onCheckForUpdate = onCheckForUpdate;
        this.onUpdateFailed = onUpdateFailed;
        this.onUpdateReady = onUpdateReady;
    }

    public /* synthetic */ MiniAppUpdateMessageStore(WeakHashMap weakHashMap, WeakHashMap weakHashMap2, WeakHashMap weakHashMap3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new WeakHashMap() : weakHashMap, (i11 & 2) != 0 ? new WeakHashMap() : weakHashMap2, (i11 & 4) != 0 ? new WeakHashMap() : weakHashMap3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniAppUpdateMessageStore copy$default(MiniAppUpdateMessageStore miniAppUpdateMessageStore, WeakHashMap weakHashMap, WeakHashMap weakHashMap2, WeakHashMap weakHashMap3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            weakHashMap = miniAppUpdateMessageStore.onCheckForUpdate;
        }
        if ((i11 & 2) != 0) {
            weakHashMap2 = miniAppUpdateMessageStore.onUpdateFailed;
        }
        if ((i11 & 4) != 0) {
            weakHashMap3 = miniAppUpdateMessageStore.onUpdateReady;
        }
        return miniAppUpdateMessageStore.copy(weakHashMap, weakHashMap2, weakHashMap3);
    }

    public final WeakHashMap<String, a> component1() {
        return this.onCheckForUpdate;
    }

    public final WeakHashMap<String, a> component2() {
        return this.onUpdateFailed;
    }

    public final WeakHashMap<String, a> component3() {
        return this.onUpdateReady;
    }

    public final MiniAppUpdateMessageStore copy(WeakHashMap<String, a> onCheckForUpdate, WeakHashMap<String, a> onUpdateFailed, WeakHashMap<String, a> onUpdateReady) {
        Intrinsics.g(onCheckForUpdate, "onCheckForUpdate");
        Intrinsics.g(onUpdateFailed, "onUpdateFailed");
        Intrinsics.g(onUpdateReady, "onUpdateReady");
        return new MiniAppUpdateMessageStore(onCheckForUpdate, onUpdateFailed, onUpdateReady);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppUpdateMessageStore)) {
            return false;
        }
        MiniAppUpdateMessageStore miniAppUpdateMessageStore = (MiniAppUpdateMessageStore) obj;
        return Intrinsics.b(this.onCheckForUpdate, miniAppUpdateMessageStore.onCheckForUpdate) && Intrinsics.b(this.onUpdateFailed, miniAppUpdateMessageStore.onUpdateFailed) && Intrinsics.b(this.onUpdateReady, miniAppUpdateMessageStore.onUpdateReady);
    }

    public final WeakHashMap<String, a> getOnCheckForUpdate() {
        return this.onCheckForUpdate;
    }

    public final WeakHashMap<String, a> getOnUpdateFailed() {
        return this.onUpdateFailed;
    }

    public final WeakHashMap<String, a> getOnUpdateReady() {
        return this.onUpdateReady;
    }

    public int hashCode() {
        return (((this.onCheckForUpdate.hashCode() * 31) + this.onUpdateFailed.hashCode()) * 31) + this.onUpdateReady.hashCode();
    }

    public String toString() {
        return "MiniAppUpdateMessageStore(onCheckForUpdate=" + this.onCheckForUpdate + ", onUpdateFailed=" + this.onUpdateFailed + ", onUpdateReady=" + this.onUpdateReady + ')';
    }
}
