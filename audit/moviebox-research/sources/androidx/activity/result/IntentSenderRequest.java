package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
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
public final class IntentSenderRequest implements Parcelable {
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    private final IntentSender intentSender;
    public static final c Companion = new c(null);

    @JvmField
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f658d;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(PendingIntent pendingIntent) {
            Intrinsics.g(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            Intrinsics.f(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }

        public a(IntentSender intentSender) {
            Intrinsics.g(intentSender, "intentSender");
            this.f655a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f655a, this.f656b, this.f657c, this.f658d);
        }

        public final a b(Intent intent) {
            this.f656b = intent;
            return this;
        }

        public final a c(int i11, int i12) {
            this.f658d = i11;
            this.f657c = i12;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel inParcel) {
            Intrinsics.g(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i11) {
            return new IntentSenderRequest[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i11, int i12) {
        Intrinsics.g(intentSender, "intentSender");
        this.intentSender = intentSender;
        this.fillInIntent = intent;
        this.flagsMask = i11;
        this.flagsValues = i12;
    }

    public /* synthetic */ IntentSenderRequest(IntentSender intentSender, Intent intent, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(intentSender, (i13 & 2) != 0 ? null : intent, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IntentSenderRequest(Parcel parcel) {
        Intrinsics.g(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        Intrinsics.d(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i11) {
        Intrinsics.g(dest, "dest");
        dest.writeParcelable(this.intentSender, i11);
        dest.writeParcelable(this.fillInIntent, i11);
        dest.writeInt(this.flagsMask);
        dest.writeInt(this.flagsValues);
    }
}
