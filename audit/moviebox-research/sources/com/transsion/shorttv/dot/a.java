package com.transsion.shorttv.dot;

import androidx.fragment.app.Fragment;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f57844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PostSubjectItem f57846d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ORPlayerView f57847f;

    public a(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f57843a = getClass().getSimpleName();
    }

    public final f a() {
        return this.f57844b;
    }

    public final PostSubjectItem b() {
        return this.f57846d;
    }

    public final void c(f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(orPlayerView, "orPlayerView");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f57843a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setPlayer----->", false, 4, null);
        this.f57844b = orPlayer;
        this.f57847f = orPlayerView;
    }

    public final void d(String postId, PostSubjectItem postSubjectItem) {
        Intrinsics.g(postId, "postId");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f57843a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setPostData----->", false, 4, null);
        this.f57845c = postId;
        this.f57846d = postSubjectItem;
    }
}
