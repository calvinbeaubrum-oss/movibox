package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.d0;
import androidx.media3.common.e0;
import androidx.media3.common.y;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new a();
    public final String key;
    public final String value;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public VorbisComment[] newArray(int i11) {
            return new VorbisComment[i11];
        }
    }

    public VorbisComment(Parcel parcel) {
        this.key = (String) u0.i(parcel.readString());
        this.value = (String) u0.i(parcel.readString());
    }

    public VorbisComment(String str, String str2) {
        this.key = com.google.common.base.a.g(str);
        this.value = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return e0.a(this);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ y getWrappedMetadataFormat() {
        return e0.b(this);
    }

    public int hashCode() {
        return ((527 + this.key.hashCode()) * 31) + this.value.hashCode();
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void populateMediaMetadata(d0.b bVar) {
        String str = this.key;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.N(this.value);
                break;
            case "TITLE":
                bVar.l0(this.value);
                break;
            case "DESCRIPTION":
                bVar.U(this.value);
                break;
            case "ALBUMARTIST":
                bVar.M(this.value);
                break;
            case "ARTIST":
                bVar.O(this.value);
                break;
        }
    }

    public String toString() {
        return "VC: " + this.key + "=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }
}
