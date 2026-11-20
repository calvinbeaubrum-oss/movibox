package com.transsion.baselib.helper;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ScreenRotationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f51174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f51175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f51176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f51178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f51179f;

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenRotationHelper(Context context, Function0<Boolean> isCloseAutoRotationCallback, Function1<? super Boolean, Unit> rotationCallback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(isCloseAutoRotationCallback, "isCloseAutoRotationCallback");
        Intrinsics.g(rotationCallback, "rotationCallback");
        this.f51174a = context;
        this.f51175b = isCloseAutoRotationCallback;
        this.f51176c = rotationCallback;
        this.f51178e = LazyKt__LazyJVMKt.b(new Function0<d>() { // from class: com.transsion.baselib.helper.ScreenRotationHelper$orientationListener$2

            /* JADX INFO: renamed from: com.transsion.baselib.helper.ScreenRotationHelper$orientationListener$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
                public AnonymousClass1(Object obj) {
                    super(1, obj, ScreenRotationHelper.class, "autoScreenRotation", "autoScreenRotation(Z)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    ((ScreenRotationHelper) this.receiver).c(z11);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d(this.this$0.d(), new AnonymousClass1(this.this$0));
            }
        });
        this.f51179f = LazyKt__LazyJVMKt.b(new Function0<e>() { // from class: com.transsion.baselib.helper.ScreenRotationHelper$mObserver$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                Handler handler = new Handler();
                Context contextD = this.this$0.d();
                final ScreenRotationHelper screenRotationHelper = this.this$0;
                return new e(handler, contextD, new Function1<Boolean, Unit>() { // from class: com.transsion.baselib.helper.ScreenRotationHelper$mObserver$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11) {
                        screenRotationHelper.f51177d = z11;
                    }
                });
            }
        });
    }

    public final void c(boolean z11) {
        if (!this.f51175b.invoke().booleanValue() && this.f51177d && com.blankj.utilcode.util.c.j()) {
            this.f51176c.invoke(Boolean.valueOf(z11));
        }
    }

    public final Context d() {
        return this.f51174a;
    }

    public final e e() {
        return (e) this.f51179f.getValue();
    }

    public final d f() {
        return (d) this.f51178e.getValue();
    }

    public final void g() {
        this.f51174a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, e());
        this.f51177d = e().a(this.f51174a);
        d dVarF = f();
        if (dVarF.canDetectOrientation()) {
            dVarF.enable();
        }
    }

    public final void h() {
        try {
            Result.Companion companion = Result.Companion;
            this.f51174a.getContentResolver().unregisterContentObserver(e());
            f().disable();
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
