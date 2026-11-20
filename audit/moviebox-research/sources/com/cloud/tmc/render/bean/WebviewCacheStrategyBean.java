package com.cloud.tmc.render.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class WebviewCacheStrategyBean extends b {
    private boolean shellWebView;
    private boolean systemWebView;

    /* JADX WARN: Illegal instructions before constructor call */
    public WebviewCacheStrategyBean() {
        boolean z11 = false;
        this(z11, z11, 3, null);
    }

    public WebviewCacheStrategyBean(boolean z11, boolean z12) {
        this.systemWebView = z11;
        this.shellWebView = z12;
    }

    public /* synthetic */ WebviewCacheStrategyBean(boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12);
    }

    public static /* synthetic */ WebviewCacheStrategyBean copy$default(WebviewCacheStrategyBean webviewCacheStrategyBean, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = webviewCacheStrategyBean.systemWebView;
        }
        if ((i11 & 2) != 0) {
            z12 = webviewCacheStrategyBean.shellWebView;
        }
        return webviewCacheStrategyBean.copy(z11, z12);
    }

    public final boolean component1() {
        return this.systemWebView;
    }

    public final boolean component2() {
        return this.shellWebView;
    }

    public final WebviewCacheStrategyBean copy(boolean z11, boolean z12) {
        return new WebviewCacheStrategyBean(z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebviewCacheStrategyBean)) {
            return false;
        }
        WebviewCacheStrategyBean webviewCacheStrategyBean = (WebviewCacheStrategyBean) obj;
        return this.systemWebView == webviewCacheStrategyBean.systemWebView && this.shellWebView == webviewCacheStrategyBean.shellWebView;
    }

    public final boolean getShellWebView() {
        return this.shellWebView;
    }

    public final boolean getSystemWebView() {
        return this.systemWebView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z11 = this.systemWebView;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.shellWebView;
        return i11 + (z12 ? 1 : z12);
    }

    public final void setShellWebView(boolean z11) {
        this.shellWebView = z11;
    }

    public final void setSystemWebView(boolean z11) {
        this.systemWebView = z11;
    }

    public String toString() {
        return "WebviewCacheStrategyBean(systemWebView=" + this.systemWebView + ", shellWebView=" + this.shellWebView + ')';
    }
}
