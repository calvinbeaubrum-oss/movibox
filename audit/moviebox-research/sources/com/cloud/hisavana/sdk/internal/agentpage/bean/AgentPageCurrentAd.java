package com.cloud.hisavana.sdk.internal.agentpage.bean;

import aa.a;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class AgentPageCurrentAd {
    private String appId;
    private String codeSeatId;
    private String gaid;
    private int height;
    private boolean isMonkey;
    private String triggerId;
    private String url;
    private int width;

    public AgentPageCurrentAd(String url, String codeSeatId, String triggerId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(triggerId, "triggerId");
        this.url = url;
        this.codeSeatId = codeSeatId;
        this.triggerId = triggerId;
        String strE = DeviceUtil.e();
        this.gaid = strE == null ? "" : strE;
        String str = AdManager.f29117b;
        this.appId = str != null ? str : "";
        this.isMonkey = a.j();
    }

    public static /* synthetic */ AgentPageCurrentAd copy$default(AgentPageCurrentAd agentPageCurrentAd, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = agentPageCurrentAd.url;
        }
        if ((i11 & 2) != 0) {
            str2 = agentPageCurrentAd.codeSeatId;
        }
        if ((i11 & 4) != 0) {
            str3 = agentPageCurrentAd.triggerId;
        }
        return agentPageCurrentAd.copy(str, str2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.codeSeatId;
    }

    public final String component3() {
        return this.triggerId;
    }

    public final AgentPageCurrentAd copy(String url, String codeSeatId, String triggerId) {
        Intrinsics.g(url, "url");
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(triggerId, "triggerId");
        return new AgentPageCurrentAd(url, codeSeatId, triggerId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentPageCurrentAd)) {
            return false;
        }
        AgentPageCurrentAd agentPageCurrentAd = (AgentPageCurrentAd) obj;
        return Intrinsics.b(this.url, agentPageCurrentAd.url) && Intrinsics.b(this.codeSeatId, agentPageCurrentAd.codeSeatId) && Intrinsics.b(this.triggerId, agentPageCurrentAd.triggerId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getCodeSeatId() {
        return this.codeSeatId;
    }

    public final String getGaid() {
        return this.gaid;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.codeSeatId.hashCode()) * 31) + this.triggerId.hashCode();
    }

    public final boolean isMonkey() {
        return this.isMonkey;
    }

    public final void setAppId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setCodeSeatId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.codeSeatId = str;
    }

    public final void setGaid(String str) {
        Intrinsics.g(str, "<set-?>");
        this.gaid = str;
    }

    public final void setHeight(int i11) {
        this.height = i11;
    }

    public final void setMonkey(boolean z11) {
        this.isMonkey = z11;
    }

    public final void setTriggerId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.triggerId = str;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public final void setWidth(int i11) {
        this.width = i11;
    }

    public String toString() {
        return "AgentPageCurrentAd(url=" + this.url + ", codeSeatId=" + this.codeSeatId + ", triggerId=" + this.triggerId + ')';
    }
}
