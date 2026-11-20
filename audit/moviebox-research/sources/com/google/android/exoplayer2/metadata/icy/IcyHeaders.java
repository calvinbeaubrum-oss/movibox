package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.z1;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new a();
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final String RESPONSE_HEADER_NAME = "icy-name";
    private static final String RESPONSE_HEADER_PUB = "icy-pub";
    private static final String RESPONSE_HEADER_URL = "icy-url";
    private static final String TAG = "IcyHeaders";
    public final int bitrate;

    @Nullable
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;

    @Nullable
    public final String name;

    @Nullable
    public final String url;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IcyHeaders[] newArray(int i11) {
            return new IcyHeaders[i11];
        }
    }

    public IcyHeaders(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, int i12) {
        com.google.android.exoplayer2.util.a.a(i12 == -1 || i12 > 0);
        this.bitrate = i11;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z11;
        this.metadataInterval = i12;
    }

    public IcyHeaders(Parcel parcel) {
        this.bitrate = parcel.readInt();
        this.genre = parcel.readString();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.isPublic = o0.M0(parcel);
        this.metadataInterval = parcel.readInt();
    }

    @Nullable
    public static IcyHeaders parse(Map<String, List<String>> map) {
        boolean z11;
        int i11;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i12;
        List<String> list = map.get(RESPONSE_HEADER_BITRATE);
        boolean z12 = true;
        int i13 = -1;
        if (list != null) {
            String str4 = list.get(0);
            try {
                i12 = Integer.parseInt(str4) * 1000;
                if (i12 > 0) {
                    z11 = true;
                } else {
                    try {
                        s.i(TAG, "Invalid bitrate: " + str4);
                        z11 = false;
                        i12 = -1;
                    } catch (NumberFormatException unused) {
                        s.i(TAG, "Invalid bitrate header: " + str4);
                        i11 = i12;
                        z11 = false;
                    }
                }
                i11 = i12;
            } catch (NumberFormatException unused2) {
                i12 = -1;
            }
        } else {
            z11 = false;
            i11 = -1;
        }
        List<String> list2 = map.get(RESPONSE_HEADER_GENRE);
        if (list2 != null) {
            str = list2.get(0);
            z11 = true;
        } else {
            str = null;
        }
        List<String> list3 = map.get(RESPONSE_HEADER_NAME);
        if (list3 != null) {
            str2 = list3.get(0);
            z11 = true;
        } else {
            str2 = null;
        }
        List<String> list4 = map.get(RESPONSE_HEADER_URL);
        if (list4 != null) {
            str3 = list4.get(0);
            z11 = true;
        } else {
            str3 = null;
        }
        List<String> list5 = map.get(RESPONSE_HEADER_PUB);
        if (list5 != null) {
            zEquals = list5.get(0).equals("1");
            z11 = true;
        } else {
            zEquals = false;
        }
        List<String> list6 = map.get(RESPONSE_HEADER_METADATA_INTERVAL);
        if (list6 != null) {
            String str5 = list6.get(0);
            try {
                int i14 = Integer.parseInt(str5);
                if (i14 > 0) {
                    i13 = i14;
                } else {
                    try {
                        s.i(TAG, "Invalid metadata interval: " + str5);
                        z12 = z11;
                    } catch (NumberFormatException unused3) {
                        i13 = i14;
                        s.i(TAG, "Invalid metadata interval: " + str5);
                    }
                }
                z11 = z12;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z11) {
            return new IcyHeaders(i11, str, str2, str3, zEquals, i13);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.bitrate == icyHeaders.bitrate && o0.c(this.genre, icyHeaders.genre) && o0.c(this.name, icyHeaders.name) && o0.c(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return gh.a.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ m1 getWrappedMetadataFormat() {
        return gh.a.b(this);
    }

    public int hashCode() {
        int i11 = (527 + this.bitrate) * 31;
        String str = this.genre;
        int iHashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(z1.b bVar) {
        String str = this.name;
        if (str != null) {
            bVar.g0(str);
        }
        String str2 = this.genre;
        if (str2 != null) {
            bVar.X(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.name + "\", genre=\"" + this.genre + "\", bitrate=" + this.bitrate + ", metadataInterval=" + this.metadataInterval;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.genre);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        o0.g1(parcel, this.isPublic);
        parcel.writeInt(this.metadataInterval);
    }
}
