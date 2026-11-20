package com.cloud.tmc.integration.model;

import bc.a;
import java.util.HashMap;
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
public final class AddToHomeScreenStore extends b {
    private final HashMap<String, a> store;

    /* JADX WARN: Multi-variable type inference failed */
    public AddToHomeScreenStore() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AddToHomeScreenStore(HashMap<String, a> store) {
        Intrinsics.g(store, "store");
        this.store = store;
    }

    public /* synthetic */ AddToHomeScreenStore(HashMap map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddToHomeScreenStore copy$default(AddToHomeScreenStore addToHomeScreenStore, HashMap map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = addToHomeScreenStore.store;
        }
        return addToHomeScreenStore.copy(map);
    }

    public final HashMap<String, a> component1() {
        return this.store;
    }

    public final AddToHomeScreenStore copy(HashMap<String, a> store) {
        Intrinsics.g(store, "store");
        return new AddToHomeScreenStore(store);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddToHomeScreenStore) && Intrinsics.b(this.store, ((AddToHomeScreenStore) obj).store);
    }

    public final HashMap<String, a> getStore() {
        return this.store;
    }

    public int hashCode() {
        return this.store.hashCode();
    }

    public String toString() {
        return "AddToHomeScreenStore(store=" + this.store + ')';
    }
}
