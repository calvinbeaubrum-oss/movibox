package com.cloud.tmc.render.bean;

import java.util.ArrayList;
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
public final class JSConfig extends b {
    private ArrayList<String> appIdBlackList;
    private ArrayList<String> appIdWhiteList;
    private ArrayList<String> injectStrategy;
    private String jsName;
    private String jsPath;

    public JSConfig(String jsName, ArrayList<String> appIdWhiteList, ArrayList<String> appIdBlackList, String jsPath, ArrayList<String> injectStrategy) {
        Intrinsics.g(jsName, "jsName");
        Intrinsics.g(appIdWhiteList, "appIdWhiteList");
        Intrinsics.g(appIdBlackList, "appIdBlackList");
        Intrinsics.g(jsPath, "jsPath");
        Intrinsics.g(injectStrategy, "injectStrategy");
        this.jsName = jsName;
        this.appIdWhiteList = appIdWhiteList;
        this.appIdBlackList = appIdBlackList;
        this.jsPath = jsPath;
        this.injectStrategy = injectStrategy;
    }

    public /* synthetic */ JSConfig(String str, ArrayList arrayList, ArrayList arrayList2, String str2, ArrayList arrayList3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? new ArrayList() : arrayList, (i11 & 4) != 0 ? new ArrayList() : arrayList2, str2, (i11 & 16) != 0 ? new ArrayList() : arrayList3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSConfig copy$default(JSConfig jSConfig, String str, ArrayList arrayList, ArrayList arrayList2, String str2, ArrayList arrayList3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = jSConfig.jsName;
        }
        if ((i11 & 2) != 0) {
            arrayList = jSConfig.appIdWhiteList;
        }
        ArrayList arrayList4 = arrayList;
        if ((i11 & 4) != 0) {
            arrayList2 = jSConfig.appIdBlackList;
        }
        ArrayList arrayList5 = arrayList2;
        if ((i11 & 8) != 0) {
            str2 = jSConfig.jsPath;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            arrayList3 = jSConfig.injectStrategy;
        }
        return jSConfig.copy(str, arrayList4, arrayList5, str3, arrayList3);
    }

    public final String component1() {
        return this.jsName;
    }

    public final ArrayList<String> component2() {
        return this.appIdWhiteList;
    }

    public final ArrayList<String> component3() {
        return this.appIdBlackList;
    }

    public final String component4() {
        return this.jsPath;
    }

    public final ArrayList<String> component5() {
        return this.injectStrategy;
    }

    public final JSConfig copy(String jsName, ArrayList<String> appIdWhiteList, ArrayList<String> appIdBlackList, String jsPath, ArrayList<String> injectStrategy) {
        Intrinsics.g(jsName, "jsName");
        Intrinsics.g(appIdWhiteList, "appIdWhiteList");
        Intrinsics.g(appIdBlackList, "appIdBlackList");
        Intrinsics.g(jsPath, "jsPath");
        Intrinsics.g(injectStrategy, "injectStrategy");
        return new JSConfig(jsName, appIdWhiteList, appIdBlackList, jsPath, injectStrategy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JSConfig)) {
            return false;
        }
        JSConfig jSConfig = (JSConfig) obj;
        return Intrinsics.b(this.jsName, jSConfig.jsName) && Intrinsics.b(this.appIdWhiteList, jSConfig.appIdWhiteList) && Intrinsics.b(this.appIdBlackList, jSConfig.appIdBlackList) && Intrinsics.b(this.jsPath, jSConfig.jsPath) && Intrinsics.b(this.injectStrategy, jSConfig.injectStrategy);
    }

    public final ArrayList<String> getAppIdBlackList() {
        return this.appIdBlackList;
    }

    public final ArrayList<String> getAppIdWhiteList() {
        return this.appIdWhiteList;
    }

    public final ArrayList<String> getInjectStrategy() {
        return this.injectStrategy;
    }

    public final String getJsName() {
        return this.jsName;
    }

    public final String getJsPath() {
        return this.jsPath;
    }

    public int hashCode() {
        return (((((((this.jsName.hashCode() * 31) + this.appIdWhiteList.hashCode()) * 31) + this.appIdBlackList.hashCode()) * 31) + this.jsPath.hashCode()) * 31) + this.injectStrategy.hashCode();
    }

    public final void setAppIdBlackList(ArrayList<String> arrayList) {
        Intrinsics.g(arrayList, "<set-?>");
        this.appIdBlackList = arrayList;
    }

    public final void setAppIdWhiteList(ArrayList<String> arrayList) {
        Intrinsics.g(arrayList, "<set-?>");
        this.appIdWhiteList = arrayList;
    }

    public final void setInjectStrategy(ArrayList<String> arrayList) {
        Intrinsics.g(arrayList, "<set-?>");
        this.injectStrategy = arrayList;
    }

    public final void setJsName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.jsName = str;
    }

    public final void setJsPath(String str) {
        Intrinsics.g(str, "<set-?>");
        this.jsPath = str;
    }

    public String toString() {
        return "JSConfig(jsName=" + this.jsName + ", appIdWhiteList=" + this.appIdWhiteList + ", appIdBlackList=" + this.appIdBlackList + ", jsPath=" + this.jsPath + ", injectStrategy=" + this.injectStrategy + ')';
    }
}
