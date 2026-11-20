package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public class g extends Handler implements aq.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f50029f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f50030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.tn.lib.widget.toast.core.a f50031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<aq.a> f50032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public aq.c<?> f50033d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g() {
        super(Looper.getMainLooper());
    }

    @Override // aq.b
    public void a(CharSequence charSequence) {
        removeMessages(1);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = charSequence;
        sendMessageDelayed(messageObtain, 200L);
    }

    @Override // aq.b
    public void b(Application application) {
        this.f50030a = application;
        com.tn.lib.widget.toast.core.a.C0541a c0541a = com.tn.lib.widget.toast.core.a.f50015b;
        Intrinsics.d(application);
        this.f50031b = c0541a.a(application);
    }

    @Override // aq.b
    public void c(aq.c<?> cVar) {
        this.f50033d = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    public aq.a d(Application application) {
        aq.a dVar;
        com.tn.lib.widget.toast.core.a aVar = this.f50031b;
        Intrinsics.d(aVar);
        Activity activityA = aVar.a();
        if (activityA != null) {
            dVar = new b(activityA);
        } else {
            dVar = Build.VERSION.SDK_INT == 25 ? new d(application) : new e(application);
        }
        if ((dVar instanceof b) || Build.VERSION.SDK_INT < 30) {
            aq.c<?> cVar = this.f50033d;
            Intrinsics.d(cVar);
            dVar.setView(cVar.a(application));
            aq.c<?> cVar2 = this.f50033d;
            Intrinsics.d(cVar2);
            int gravity = cVar2.getGravity();
            aq.c<?> cVar3 = this.f50033d;
            Intrinsics.d(cVar3);
            int xOffset = cVar3.getXOffset();
            aq.c<?> cVar4 = this.f50033d;
            Intrinsics.d(cVar4);
            dVar.setGravity(gravity, xOffset, cVar4.getYOffset());
            aq.c<?> cVar5 = this.f50033d;
            Intrinsics.d(cVar5);
            float horizontalMargin = cVar5.getHorizontalMargin();
            aq.c<?> cVar6 = this.f50033d;
            Intrinsics.d(cVar6);
            dVar.setMargin(horizontalMargin, cVar6.getVerticalMargin());
        } else {
            Intrinsics.d(application);
            if (application.getApplicationInfo().targetSdkVersion < 30) {
                aq.c<?> cVar7 = this.f50033d;
                Intrinsics.d(cVar7);
                dVar.setView(cVar7.a(application));
                aq.c<?> cVar8 = this.f50033d;
                Intrinsics.d(cVar8);
                int gravity2 = cVar8.getGravity();
                aq.c<?> cVar9 = this.f50033d;
                Intrinsics.d(cVar9);
                int xOffset2 = cVar9.getXOffset();
                aq.c<?> cVar10 = this.f50033d;
                Intrinsics.d(cVar10);
                dVar.setGravity(gravity2, xOffset2, cVar10.getYOffset());
                aq.c<?> cVar11 = this.f50033d;
                Intrinsics.d(cVar11);
                float horizontalMargin2 = cVar11.getHorizontalMargin();
                aq.c<?> cVar12 = this.f50033d;
                Intrinsics.d(cVar12);
                dVar.setMargin(horizontalMargin2, cVar12.getVerticalMargin());
            }
        }
        return dVar;
    }

    public final int e(CharSequence charSequence) {
        return charSequence.length() > 20 ? 1 : 0;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        aq.a aVar;
        Intrinsics.g(msg, "msg");
        WeakReference<aq.a> weakReference = this.f50032c;
        if (weakReference != null) {
            Intrinsics.d(weakReference);
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        int i11 = msg.what;
        if (i11 != 1) {
            if (i11 == 2 && aVar != null) {
                aVar.cancel();
                return;
            }
            return;
        }
        Object obj = msg.obj;
        if (obj instanceof CharSequence) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            CharSequence charSequence = (CharSequence) obj;
            if (aVar != null) {
                aVar.cancel();
            }
            aq.a aVarD = d(this.f50030a);
            this.f50032c = new WeakReference<>(aVarD);
            Intrinsics.d(aVarD);
            aVarD.setDuration(e(charSequence));
            aVarD.setText(charSequence);
            aVarD.show();
            c(new bq.a());
        }
    }
}
