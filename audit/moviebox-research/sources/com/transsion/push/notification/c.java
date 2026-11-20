package com.transsion.push.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.transsion.push.R$id;
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
public final class c extends com.transsion.push.notification.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f56960b = new b(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends com.transsion.push.notification.a {

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Context f56961z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i11, int i12, int i13) {
            super(context, i11);
            Intrinsics.g(context, "context");
            this.f56961z = context;
            E(Q(i12));
            if (i13 > 0) {
                D(Q(i13));
            }
        }

        @Override // com.transsion.push.notification.a
        public com.transsion.push.notification.a O(long j11) {
            long jCurrentTimeMillis = j11 <= 0 ? System.currentTimeMillis() : j11;
            super.O(j11);
            try {
                RemoteViews remoteViewsJ = j();
                if (remoteViewsJ != null) {
                    remoteViewsJ.setLong(R$id.time, "setTime", jCurrentTimeMillis);
                }
            } catch (Exception e11) {
                uo.b.a.e(uo.b.f78622a, "CustomNotification", "setTime error:", e11, false, 8, null);
            }
            return this;
        }

        public final c P() {
            if (r() <= 0) {
                O(0L);
            }
            return new c(this);
        }

        public final RemoteViews Q(int i11) {
            return new RemoteViews(this.f56961z.getPackageName(), i11);
        }

        public final a R(int i11, Bitmap bitmap) {
            if (bitmap == null) {
                return this;
            }
            RemoteViews remoteViewsI = i();
            if (remoteViewsI != null) {
                remoteViewsI.setViewVisibility(i11, 0);
            }
            RemoteViews remoteViewsI2 = i();
            if (remoteViewsI2 != null) {
                remoteViewsI2.setImageViewBitmap(i11, bitmap);
            }
            return this;
        }

        public final a S(int i11, CharSequence charSequence) {
            RemoteViews remoteViewsI = i();
            if (remoteViewsI != null) {
                remoteViewsI.setTextViewText(i11, charSequence);
            }
            return this;
        }

        public final a T(int i11, int i12) {
            if (i() != null) {
                RemoteViews remoteViewsI = i();
                Intrinsics.d(remoteViewsI);
                remoteViewsI.setViewVisibility(i11, i12);
            }
            return this;
        }

        public final a U(int i11, String str) {
            C(str);
            W(i11, str);
            return this;
        }

        public a V(int i11, Bitmap bitmap) {
            if (j() == null) {
                return this;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                RemoteViews remoteViewsJ = j();
                if (remoteViewsJ != null) {
                    remoteViewsJ.setViewVisibility(i11, 8);
                }
                return this;
            }
            H(bitmap);
            RemoteViews remoteViewsJ2 = j();
            if (remoteViewsJ2 != null) {
                remoteViewsJ2.setImageViewBitmap(i11, bitmap);
            }
            RemoteViews remoteViewsJ3 = j();
            if (remoteViewsJ3 != null) {
                remoteViewsJ3.setViewVisibility(i11, 0);
            }
            return this;
        }

        public final a W(int i11, String str) {
            RemoteViews remoteViewsJ = j();
            if (remoteViewsJ != null) {
                remoteViewsJ.setTextViewText(i11, str);
            }
            return this;
        }

        public final a X(int i11, int i12) {
            if (j() != null) {
                RemoteViews remoteViewsJ = j();
                Intrinsics.d(remoteViewsJ);
                remoteViewsJ.setViewVisibility(i11, i12);
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a builder) {
        super(builder);
        Intrinsics.g(builder, "builder");
    }
}
