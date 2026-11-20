package androidx.media3.extractor.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.d0;
import androidx.media3.common.e0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class EventMessage implements Metadata.Entry {
    public static final String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";
    public static final String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final long f11799id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;
    private static final y ID3_FORMAT = new y.b().k0(MimeTypes.APPLICATION_ID3).I();
    private static final y SCTE35_FORMAT = new y.b().k0(MimeTypes.APPLICATION_SCTE35).I();
    public static final Parcelable.Creator<EventMessage> CREATOR = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EventMessage[] newArray(int i11) {
            return new EventMessage[i11];
        }
    }

    public EventMessage(Parcel parcel) {
        this.schemeIdUri = (String) u0.i(parcel.readString());
        this.value = (String) u0.i(parcel.readString());
        this.durationMs = parcel.readLong();
        this.f11799id = parcel.readLong();
        this.messageData = (byte[]) u0.i(parcel.createByteArray());
    }

    public EventMessage(String str, String str2, long j11, long j12, byte[] bArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j11;
        this.f11799id = j12;
        this.messageData = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.durationMs == eventMessage.durationMs && this.f11799id == eventMessage.f11799id && u0.c(this.schemeIdUri, eventMessage.schemeIdUri) && u0.c(this.value, eventMessage.value) && Arrays.equals(this.messageData, eventMessage.messageData);
    }

    @Override // androidx.media3.common.Metadata.Entry
    @Nullable
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.messageData;
        }
        return null;
    }

    @Override // androidx.media3.common.Metadata.Entry
    @Nullable
    public y getWrappedMetadataFormat() {
        String str = this.schemeIdUri;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return SCTE35_FORMAT;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return ID3_FORMAT;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j11 = this.durationMs;
            int i11 = (((iHashCode + iHashCode2) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f11799id;
            this.hashCode = ((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(d0.b bVar) {
        e0.c(this, bVar);
    }

    public String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.f11799id + ", durationMs=" + this.durationMs + ", value=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.f11799id);
        parcel.writeByteArray(this.messageData);
    }
}
