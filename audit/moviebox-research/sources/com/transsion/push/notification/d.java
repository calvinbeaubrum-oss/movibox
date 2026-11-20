package com.transsion.push.notification;

import com.transsion.push.bean.MsgType;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f56962d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Void f56963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Void f56964f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f56965g = new d((String) f56963e, -1, (String) f56964f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f56966h = new d("oneroom.group.tag.cms", 1202, "oneroom.group.key.cms");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f56967i = new d("oneroom.group.tag.permanent", 1204, "oneroom.group.key.permanent");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f56968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f56970c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return d.f56966h;
        }

        public final d b() {
            return d.f56967i;
        }

        public final d c(String str) {
            return Intrinsics.b(str, MsgType.PERMANENT.getType()) ? b() : a();
        }
    }

    public d(String str, int i11, String str2) {
        this.f56968a = str;
        this.f56969b = i11;
        this.f56970c = str2;
    }

    public final String c() {
        return this.f56970c;
    }

    public final String d() {
        return this.f56968a;
    }
}
