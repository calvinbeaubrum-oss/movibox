package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"BanParcelableUsage"})
public final class NavBackStackEntryState implements Parcelable {
    private final Bundle args;
    private final int destinationId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f12154id;
    private final Bundle savedState;
    public static final b Companion = new b(null);

    @JvmField
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<NavBackStackEntryState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavBackStackEntryState createFromParcel(Parcel inParcel) {
            Intrinsics.g(inParcel, "inParcel");
            return new NavBackStackEntryState(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavBackStackEntryState[] newArray(int i11) {
            return new NavBackStackEntryState[i11];
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

    public NavBackStackEntryState(Parcel inParcel) {
        Intrinsics.g(inParcel, "inParcel");
        String string = inParcel.readString();
        Intrinsics.d(string);
        Intrinsics.f(string, "inParcel.readString()!!");
        this.f12154id = string;
        this.destinationId = inParcel.readInt();
        this.args = inParcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        Bundle bundle = inParcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        Intrinsics.d(bundle);
        Intrinsics.f(bundle, "inParcel.readBundle(javaClass.classLoader)!!");
        this.savedState = bundle;
    }

    public NavBackStackEntryState(NavBackStackEntry entry) {
        Intrinsics.g(entry, "entry");
        this.f12154id = entry.g();
        this.destinationId = entry.f().u();
        this.args = entry.d();
        Bundle bundle = new Bundle();
        this.savedState = bundle;
        entry.j(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Bundle getArgs() {
        return this.args;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final String getId() {
        return this.f12154id;
    }

    public final Bundle getSavedState() {
        return this.savedState;
    }

    public final NavBackStackEntry instantiate(Context context, NavDestination destination, Lifecycle.State hostLifecycleState, f fVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(destination, "destination");
        Intrinsics.g(hostLifecycleState, "hostLifecycleState");
        Bundle bundle = this.args;
        if (bundle == null) {
            bundle = null;
        } else {
            bundle.setClassLoader(context.getClassLoader());
        }
        return NavBackStackEntry.f12139o.a(context, destination, bundle, hostLifecycleState, fVar, this.f12154id, this.savedState);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.f12154id);
        parcel.writeInt(this.destinationId);
        parcel.writeBundle(this.args);
        parcel.writeBundle(this.savedState);
    }
}
