package com.cloud.tmc.render;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface IPageChainCallback {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class OnPageFinishedData extends b {
        private long fcpCurrentTimeMillis;
        private String url;

        public OnPageFinishedData() {
            this(null, 0L, 3, null);
        }

        public OnPageFinishedData(String url, long j11) {
            Intrinsics.g(url, "url");
            this.url = url;
            this.fcpCurrentTimeMillis = j11;
        }

        public /* synthetic */ OnPageFinishedData(String str, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? System.currentTimeMillis() : j11);
        }

        public static /* synthetic */ OnPageFinishedData copy$default(OnPageFinishedData onPageFinishedData, String str, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = onPageFinishedData.url;
            }
            if ((i11 & 2) != 0) {
                j11 = onPageFinishedData.fcpCurrentTimeMillis;
            }
            return onPageFinishedData.copy(str, j11);
        }

        public final String component1() {
            return this.url;
        }

        public final long component2() {
            return this.fcpCurrentTimeMillis;
        }

        public final OnPageFinishedData copy(String url, long j11) {
            Intrinsics.g(url, "url");
            return new OnPageFinishedData(url, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnPageFinishedData)) {
                return false;
            }
            OnPageFinishedData onPageFinishedData = (OnPageFinishedData) obj;
            return Intrinsics.b(this.url, onPageFinishedData.url) && this.fcpCurrentTimeMillis == onPageFinishedData.fcpCurrentTimeMillis;
        }

        public final long getFcpCurrentTimeMillis() {
            return this.fcpCurrentTimeMillis;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + p.a(this.fcpCurrentTimeMillis);
        }

        public final void setFcpCurrentTimeMillis(long j11) {
            this.fcpCurrentTimeMillis = j11;
        }

        public final void setUrl(String str) {
            Intrinsics.g(str, "<set-?>");
            this.url = str;
        }

        public String toString() {
            return "OnPageFinishedData(url=" + this.url + ", fcpCurrentTimeMillis=" + this.fcpCurrentTimeMillis + ')';
        }
    }

    void onConsoleMessage(String str);

    void onPageFinished(String str);
}
