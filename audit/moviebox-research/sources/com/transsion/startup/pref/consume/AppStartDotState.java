package com.transsion.startup.pref.consume;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class AppStartDotState implements Parcelable {
    public static final String AD_END = "ad_end";
    public static final String AD_LOADING = "ad_loading";
    public static final String AD_RENDERING = "ad_rendering";
    public static final String APP_END = "app_end";
    public static final String APP_START = "app_start";
    public static final String MAIN_CREATE = "main_create";
    public static final String SPLASH_RESUME = "splash_resume";
    public static final String SPLASH_START = "splash_start";
    public static final String TRENDING_CREATE = "trending_create";
    public static final String TRENDING_END = "trending_end";
    public static final String TRENDING_RENDER = "trending_render";
    private final String state;
    private final long timestamp;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<AppStartDotState> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b implements Parcelable.Creator<AppStartDotState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppStartDotState createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AppStartDotState(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AppStartDotState[] newArray(int i11) {
            return new AppStartDotState[i11];
        }
    }

    public AppStartDotState(String state, long j11) {
        Intrinsics.g(state, "state");
        this.state = state;
        this.timestamp = j11;
    }

    public /* synthetic */ AppStartDotState(String str, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? SystemClock.elapsedRealtime() : j11);
    }

    public static /* synthetic */ AppStartDotState copy$default(AppStartDotState appStartDotState, String str, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = appStartDotState.state;
        }
        if ((i11 & 2) != 0) {
            j11 = appStartDotState.timestamp;
        }
        return appStartDotState.copy(str, j11);
    }

    public final String component1() {
        return this.state;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final AppStartDotState copy(String state, long j11) {
        Intrinsics.g(state, "state");
        return new AppStartDotState(state, j11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppStartDotState)) {
            return false;
        }
        AppStartDotState appStartDotState = (AppStartDotState) obj;
        return Intrinsics.b(this.state, appStartDotState.state) && this.timestamp == appStartDotState.timestamp;
    }

    public final String getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + com.transsion.startup.pref.consume.a.a(this.timestamp);
    }

    public String toString() {
        return "AppStartDotState(state=" + this.state + ", timestamp=" + this.timestamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.state);
        out.writeLong(this.timestamp);
    }
}
