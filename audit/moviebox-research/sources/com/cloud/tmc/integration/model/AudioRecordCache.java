package com.cloud.tmc.integration.model;

import bc.a;
import com.cloud.tmc.integration.audio.recording.d;
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
public final class AudioRecordCache extends b {
    private final HashMap<String, a> onErrors;
    private final HashMap<String, a> onPauses;
    private final HashMap<String, a> onResumes;
    private final HashMap<String, a> onStarts;
    private final HashMap<String, a> onStops;
    private final HashMap<String, d> recorderClientCache;

    public AudioRecordCache() {
        this(null, null, null, null, null, null, 63, null);
    }

    public AudioRecordCache(HashMap<String, d> recorderClientCache, HashMap<String, a> onStarts, HashMap<String, a> onStops, HashMap<String, a> onPauses, HashMap<String, a> onResumes, HashMap<String, a> onErrors) {
        Intrinsics.g(recorderClientCache, "recorderClientCache");
        Intrinsics.g(onStarts, "onStarts");
        Intrinsics.g(onStops, "onStops");
        Intrinsics.g(onPauses, "onPauses");
        Intrinsics.g(onResumes, "onResumes");
        Intrinsics.g(onErrors, "onErrors");
        this.recorderClientCache = recorderClientCache;
        this.onStarts = onStarts;
        this.onStops = onStops;
        this.onPauses = onPauses;
        this.onResumes = onResumes;
        this.onErrors = onErrors;
    }

    public /* synthetic */ AudioRecordCache(HashMap map, HashMap map2, HashMap map3, HashMap map4, HashMap map5, HashMap map6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : map, (i11 & 2) != 0 ? new HashMap() : map2, (i11 & 4) != 0 ? new HashMap() : map3, (i11 & 8) != 0 ? new HashMap() : map4, (i11 & 16) != 0 ? new HashMap() : map5, (i11 & 32) != 0 ? new HashMap() : map6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioRecordCache copy$default(AudioRecordCache audioRecordCache, HashMap map, HashMap map2, HashMap map3, HashMap map4, HashMap map5, HashMap map6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = audioRecordCache.recorderClientCache;
        }
        if ((i11 & 2) != 0) {
            map2 = audioRecordCache.onStarts;
        }
        HashMap map7 = map2;
        if ((i11 & 4) != 0) {
            map3 = audioRecordCache.onStops;
        }
        HashMap map8 = map3;
        if ((i11 & 8) != 0) {
            map4 = audioRecordCache.onPauses;
        }
        HashMap map9 = map4;
        if ((i11 & 16) != 0) {
            map5 = audioRecordCache.onResumes;
        }
        HashMap map10 = map5;
        if ((i11 & 32) != 0) {
            map6 = audioRecordCache.onErrors;
        }
        return audioRecordCache.copy(map, map7, map8, map9, map10, map6);
    }

    public final HashMap<String, d> component1() {
        return this.recorderClientCache;
    }

    public final HashMap<String, a> component2() {
        return this.onStarts;
    }

    public final HashMap<String, a> component3() {
        return this.onStops;
    }

    public final HashMap<String, a> component4() {
        return this.onPauses;
    }

    public final HashMap<String, a> component5() {
        return this.onResumes;
    }

    public final HashMap<String, a> component6() {
        return this.onErrors;
    }

    public final AudioRecordCache copy(HashMap<String, d> recorderClientCache, HashMap<String, a> onStarts, HashMap<String, a> onStops, HashMap<String, a> onPauses, HashMap<String, a> onResumes, HashMap<String, a> onErrors) {
        Intrinsics.g(recorderClientCache, "recorderClientCache");
        Intrinsics.g(onStarts, "onStarts");
        Intrinsics.g(onStops, "onStops");
        Intrinsics.g(onPauses, "onPauses");
        Intrinsics.g(onResumes, "onResumes");
        Intrinsics.g(onErrors, "onErrors");
        return new AudioRecordCache(recorderClientCache, onStarts, onStops, onPauses, onResumes, onErrors);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioRecordCache)) {
            return false;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) obj;
        return Intrinsics.b(this.recorderClientCache, audioRecordCache.recorderClientCache) && Intrinsics.b(this.onStarts, audioRecordCache.onStarts) && Intrinsics.b(this.onStops, audioRecordCache.onStops) && Intrinsics.b(this.onPauses, audioRecordCache.onPauses) && Intrinsics.b(this.onResumes, audioRecordCache.onResumes) && Intrinsics.b(this.onErrors, audioRecordCache.onErrors);
    }

    public final HashMap<String, a> getOnErrors() {
        return this.onErrors;
    }

    public final HashMap<String, a> getOnPauses() {
        return this.onPauses;
    }

    public final HashMap<String, a> getOnResumes() {
        return this.onResumes;
    }

    public final HashMap<String, a> getOnStarts() {
        return this.onStarts;
    }

    public final HashMap<String, a> getOnStops() {
        return this.onStops;
    }

    public final HashMap<String, d> getRecorderClientCache() {
        return this.recorderClientCache;
    }

    public int hashCode() {
        return (((((((((this.recorderClientCache.hashCode() * 31) + this.onStarts.hashCode()) * 31) + this.onStops.hashCode()) * 31) + this.onPauses.hashCode()) * 31) + this.onResumes.hashCode()) * 31) + this.onErrors.hashCode();
    }

    public String toString() {
        return "AudioRecordCache(recorderClientCache=" + this.recorderClientCache + ", onStarts=" + this.onStarts + ", onStops=" + this.onStops + ", onPauses=" + this.onPauses + ", onResumes=" + this.onResumes + ", onErrors=" + this.onErrors + ')';
    }
}
