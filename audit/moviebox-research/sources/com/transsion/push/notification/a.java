package com.transsion.push.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tn.lib.widget.R$drawable;
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
    public int f56934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f56935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f56936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f56939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f56942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f56943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f56944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f56945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f56946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f56947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f56948o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f56949p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f56950q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RemoteViews f56951r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RemoteViews f56952s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PendingIntent f56953t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PendingIntent f56954u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PendingIntent f56955v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PendingIntent f56956w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PendingIntent f56957x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f56958y;

    public a(Context context, int i11) {
        Intrinsics.g(context, "context");
        this.f56934a = i11;
        this.f56940g = true;
        this.f56941h = R$drawable.push_small_logo;
        this.f56958y = true;
    }

    public a A(PendingIntent pendingIntent) {
        this.f56953t = pendingIntent;
        return this;
    }

    public a B(String str) {
        this.f56945l = str;
        return this;
    }

    public a C(String str) {
        this.f56944k = str;
        return this;
    }

    public final void D(RemoteViews remoteViews) {
        this.f56952s = remoteViews;
    }

    public final void E(RemoteViews remoteViews) {
        this.f56951r = remoteViews;
    }

    public a F(PendingIntent pendingIntent) {
        this.f56954u = pendingIntent;
        return this;
    }

    public a G(String str) {
        this.f56949p = str;
        return this;
    }

    public a H(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f56946m = bitmap;
        }
        return this;
    }

    public final void I(PendingIntent pendingIntent) {
        this.f56956w = pendingIntent;
    }

    public final void J(PendingIntent pendingIntent) {
        this.f56957x = pendingIntent;
    }

    public final void K(boolean z11) {
        this.f56936c = z11;
    }

    public a L(int i11) {
        this.f56941h = i11;
        return this;
    }

    public final void M(int i11) {
        this.f56941h = i11;
    }

    public final void N(boolean z11) {
        this.f56958y = z11;
    }

    public a O(long j11) {
        this.f56943j = j11;
        return this;
    }

    public final Bitmap a() {
        return this.f56947n;
    }

    public final String b() {
        return this.f56948o;
    }

    public final PendingIntent c() {
        return this.f56955v;
    }

    public final String d() {
        String str = this.f56935b;
        if (str != null) {
            return str;
        }
        Intrinsics.y("channelId");
        return null;
    }

    public final int e() {
        return this.f56950q;
    }

    public final PendingIntent f() {
        return this.f56953t;
    }

    public final String g() {
        return this.f56945l;
    }

    public final String h() {
        return this.f56944k;
    }

    public final RemoteViews i() {
        return this.f56952s;
    }

    public final RemoteViews j() {
        return this.f56951r;
    }

    public final String k() {
        return this.f56949p;
    }

    public final Bitmap l() {
        return this.f56946m;
    }

    public final PendingIntent m() {
        return this.f56956w;
    }

    public final PendingIntent n() {
        return this.f56957x;
    }

    public final int o() {
        return this.f56941h;
    }

    public final boolean p() {
        return this.f56958y;
    }

    public final String q() {
        return this.f56942i;
    }

    public final long r() {
        return this.f56943j;
    }

    public final boolean s() {
        return this.f56940g;
    }

    public final boolean t() {
        return this.f56939f;
    }

    public final boolean u() {
        return this.f56936c;
    }

    public final boolean v() {
        return this.f56937d;
    }

    public final boolean w() {
        return this.f56938e;
    }

    public a x(PendingIntent pendingIntent) {
        this.f56955v = pendingIntent;
        return this;
    }

    public a y(String channelId) {
        Intrinsics.g(channelId, "channelId");
        z(channelId);
        return this;
    }

    public final void z(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f56935b = str;
    }
}
