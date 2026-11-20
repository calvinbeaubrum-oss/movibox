package com.transsion.postdetail.util;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.web.api.WebConstants;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0590a f56202e = new C0590a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f56204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Integer> f56205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<String> f56206d;

    /* JADX INFO: renamed from: com.transsion.postdetail.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0590a {
        public C0590a() {
        }

        public /* synthetic */ C0590a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String pageName) {
        Intrinsics.g(pageName, "pageName");
        this.f56203a = pageName;
        this.f56204b = new HashSet<>();
        this.f56205c = new HashSet<>();
        this.f56206d = new HashSet<>();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006f A[RETURN] */
    public final void a(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, Integer num, String str8, long j11, Boolean bool2, String str9) {
        boolean zContains;
        String str10 = str4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        if (Intrinsics.b(str3, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
            if (str10 != null) {
                zContains = this.f56204b.contains(str4);
                this.f56204b.add(str4);
                if (zContains) {
                    return;
                }
            }
        } else if (Intrinsics.b(str3, PostItemType.BANNER.getValue())) {
            if (num != null) {
                zContains = this.f56205c.contains(num);
                this.f56205c.add(num);
                if (zContains) {
                    return;
                }
            }
        } else if (Intrinsics.b(str3, PostItemType.OP_RANKING.getValue()) && str10 != null) {
            zContains = this.f56206d.contains(str4);
            this.f56206d.add(str4);
            if (zContains) {
                return;
            }
        }
        if (str10 == null) {
            str10 = "";
        }
        linkedHashMap.put("subject_id", str10);
        linkedHashMap.put("group_id", str5 == null ? "" : str5);
        linkedHashMap.put("ops", str6 == null ? "" : str6);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        linkedHashMap.put("builtin", Intrinsics.b(bool2, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        com.transsion.baselib.helper.a.f51183a.d(str != null ? str : "", linkedHashMap);
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, String str8, Boolean bool3, String str9) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", str2 == null ? "" : str2);
        linkedHashMap.put("opt_type", str3 == null ? "" : str3);
        linkedHashMap.put("subject_id", str4 == null ? "" : str4);
        linkedHashMap.put("group_id", str5 == null ? "" : str5);
        linkedHashMap.put("ops", str6 == null ? "" : str6);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("check_in", String.valueOf(bool2));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        linkedHashMap.put(RequestParameters.POSITION, sb2.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("builtin", Intrinsics.b(bool3, Boolean.TRUE) ? "1" : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        com.transsion.baselib.helper.a.f51183a.e(str != null ? str : "", linkedHashMap);
    }
}
