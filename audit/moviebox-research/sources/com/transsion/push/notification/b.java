package com.transsion.push.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tn.lib.widget.R$drawable;
import com.transsion.baseui.R$string;
import com.transsion.push.R$id;
import com.transsion.push.notification.a;
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
public abstract class b<T extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f56959a;

    public b(T parentBuilder) {
        Intrinsics.g(parentBuilder, "parentBuilder");
        this.f56959a = parentBuilder;
    }

    public final NotificationCompat.m a(Context context) {
        RemoteViews remoteViewsI;
        RemoteViews remoteViewsI2;
        RemoteViews remoteViewsI3;
        RemoteViews remoteViewsJ;
        Intrinsics.g(context, "context");
        if (this.f56959a.o() <= 0) {
            this.f56959a.M(R$drawable.push_small_logo);
        }
        NotificationCompat.m mVarM = new NotificationCompat.m(context, this.f56959a.d()).Q(this.f56959a.r()).J(false).K(this.f56959a.o()).l(this.f56959a.s()).r(this.f56959a.h()).q(this.f56959a.g()).m(1);
        Intrinsics.f(mVarM, "Builder(context, parentB…nCompat.BADGE_ICON_SMALL)");
        if (this.f56959a.e() > 0) {
            mVarM.o(this.f56959a.e());
        }
        if (this.f56959a.j() != null) {
            PendingIntent pendingIntentC = this.f56959a.c();
            if (pendingIntentC != null && (remoteViewsJ = this.f56959a.j()) != null) {
                remoteViewsJ.setOnClickPendingIntent(R$id.ll_download, pendingIntentC);
            }
            mVarM.t(this.f56959a.j());
        } else if (this.f56959a.l() != null) {
            mVarM.B(this.f56959a.l());
        }
        if (this.f56959a.i() != null) {
            PendingIntent pendingIntentC2 = this.f56959a.c();
            if (pendingIntentC2 != null && (remoteViewsI3 = this.f56959a.i()) != null) {
                remoteViewsI3.setOnClickPendingIntent(R$id.ll_download, pendingIntentC2);
            }
            PendingIntent pendingIntentM = this.f56959a.m();
            if (pendingIntentM != null && (remoteViewsI2 = this.f56959a.i()) != null) {
                remoteViewsI2.setOnClickPendingIntent(R$id.notification_last, pendingIntentM);
            }
            PendingIntent pendingIntentN = this.f56959a.n();
            if (pendingIntentN != null && (remoteViewsI = this.f56959a.i()) != null) {
                remoteViewsI.setOnClickPendingIntent(R$id.notification_next, pendingIntentN);
            }
            mVarM.s(this.f56959a.i());
            if (this.f56959a.p()) {
                mVarM.M(new NotificationCompat.o());
            }
        }
        if (this.f56959a.a() != null) {
            NotificationCompat.j jVarT = new NotificationCompat.j().s(this.f56959a.h()).r(this.f56959a.a()).t(this.f56959a.g());
            Intrinsics.f(jVarT, "BigPictureStyle()\n      …arentBuilder.contentText)");
            mVarM.M(jVarT);
        }
        if (!TextUtils.isEmpty(this.f56959a.b())) {
            NotificationCompat.k kVarS = new NotificationCompat.k().r(this.f56959a.h()).q(this.f56959a.b()).s(context.getString(R$string.base_app_name));
            Intrinsics.f(kVarS, "BigTextStyle()\n         ….R.string.base_app_name))");
            mVarM.M(kVarS);
        }
        mVarM.p(this.f56959a.f());
        String strQ = this.f56959a.q();
        if (strQ == null) {
            strQ = context.getString(R$string.base_app_name);
            Intrinsics.f(strQ, "context.getString(com.tr…i.R.string.base_app_name)");
        }
        mVarM.N(strQ);
        mVarM.n(this.f56959a.d());
        mVarM.u(this.f56959a.v() ? 1 : -1);
        if (this.f56959a.w()) {
            mVarM.P(1);
        }
        if (this.f56959a.u()) {
            mVarM.F(true).l(false).G(true);
            if (this.f56959a.t()) {
                mVarM.H(2);
                if (Build.VERSION.SDK_INT >= 26) {
                    mVarM.u(0);
                }
            }
        } else {
            mVarM.F(false).l(this.f56959a.s()).G(true);
            if (this.f56959a.t()) {
                mVarM.H(2);
                mVarM.u(1);
            } else {
                mVarM.H(1);
            }
        }
        if (!TextUtils.isEmpty(this.f56959a.k())) {
            mVarM.A(false);
            mVarM.z(this.f56959a.k());
        }
        return mVarM;
    }
}
