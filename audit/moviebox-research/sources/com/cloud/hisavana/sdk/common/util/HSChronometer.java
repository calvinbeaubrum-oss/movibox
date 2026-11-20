package com.cloud.hisavana.sdk.common.util;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.common.util.HSChronometer;
import com.cloud.hisavana.sdk.z;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class HSChronometer extends Chronometer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f29508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f29509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29510d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f29512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f29513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f29514i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void onFinish();

        void onTick(long j11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HSChronometer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HSChronometer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HSChronometer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f29507a = "HiChronometer";
    }

    public /* synthetic */ HSChronometer(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void d(HSChronometer this$0, Chronometer chronometer) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(chronometer, "chronometer");
        this$0.b(chronometer);
    }

    public final void b(Chronometer chronometer) {
        this.f29509c = this.f29508b - (SystemClock.elapsedRealtime() - getBase());
        if (z.b()) {
            z.a().i(this.f29507a, "-----> onChronometerTick " + this.f29509c);
        }
        if (this.f29509c > 0) {
            f();
            a aVar = this.f29514i;
            if (aVar != null) {
                aVar.onTick(this.f29509c);
                return;
            }
            return;
        }
        e();
        String str = this.f29513h;
        if (str == null) {
            str = "";
        }
        chronometer.setText(str);
        a aVar2 = this.f29514i;
        if (aVar2 != null) {
            aVar2.onTick(this.f29509c);
        }
        a aVar3 = this.f29514i;
        if (aVar3 != null) {
            aVar3.onFinish();
        }
    }

    public final void c(long j11) {
        if (this.f29510d || j11 <= 0) {
            return;
        }
        this.f29508b = j11;
        setBase(SystemClock.elapsedRealtime());
        setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() { // from class: w9.h
            @Override // android.widget.Chronometer.OnChronometerTickListener
            public final void onChronometerTick(Chronometer chronometer) {
                HSChronometer.d(this.f79365a, chronometer);
            }
        });
        this.f29510d = true;
        start();
    }

    public final String countdownText(long j11) {
        this.f29509c = j11;
        int iCeil = (int) Math.ceil(j11 / ((double) 1000));
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        Locale locale = Locale.getDefault();
        String string = getResources().getString(R$string.reward_before_tip);
        Intrinsics.f(string, "resources.getString(R.string.reward_before_tip)");
        String str = String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(iCeil)}, 1));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    public final void e() {
        stop();
        this.f29511f = true;
        this.f29510d = false;
        this.f29509c = 0L;
    }

    public final void f() {
        if (this.f29512g != null) {
            setText(countdownText(this.f29509c));
        }
    }

    public final String getFinishedString() {
        return this.f29513h;
    }

    public final a getTickListener() {
        return this.f29514i;
    }

    public final String getTickStringFormat() {
        return this.f29512g;
    }

    public final boolean isTimeUp() {
        return this.f29511f;
    }

    public final long pauseCountdown() {
        if (this.f29510d) {
            stop();
            this.f29510d = false;
            this.f29509c = this.f29508b - (SystemClock.elapsedRealtime() - getBase());
            if (z.b()) {
                z.a().i(this.f29507a, "pauseCountdown -----> remain countdownDuration: " + this.f29509c);
            }
            if (this.f29509c <= 0) {
                e();
                String str = this.f29513h;
                if (str == null) {
                    str = "";
                }
                setText(str);
                a aVar = this.f29514i;
                if (aVar != null) {
                    aVar.onTick(this.f29509c);
                }
                a aVar2 = this.f29514i;
                if (aVar2 != null) {
                    aVar2.onFinish();
                }
            } else {
                f();
                a aVar3 = this.f29514i;
                if (aVar3 != null) {
                    aVar3.onTick(this.f29509c);
                }
            }
        }
        return this.f29509c;
    }

    public final void resumeCountdown(long j11) {
        if (this.f29510d || j11 <= 0) {
            return;
        }
        if (z.b()) {
            z.a().i(this.f29507a, "resumeCountdown -----> resume countdownDuration: " + this.f29509c);
        }
        c(j11);
    }

    public final void setFinishedString(String str) {
        this.f29513h = str;
    }

    public final void setTickListener(a aVar) {
        this.f29514i = aVar;
    }

    public final void setTickStringFormat(String str) {
        this.f29512g = str;
    }

    public final void startCountDown(int i11, a aVar) {
        startCountdown(((long) i11) * 1000, aVar);
    }

    public final void startCountdown(long j11, a aVar) {
        this.f29514i = aVar;
        if (z.b()) {
            z.a().i(this.f29507a, "startCountDown: " + j11);
        }
        c(j11);
    }
}
