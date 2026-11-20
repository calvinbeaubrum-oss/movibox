package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.b0;
import androidx.media3.common.f0;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();

    @Nullable
    public final String customCacheKey;
    public final byte[] data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f10832id;

    @Nullable
    public final byte[] keySetId;

    @Nullable
    public final String mimeType;
    public final List<StreamKey> streamKeys;
    public final Uri uri;

    /* JADX INFO: compiled from: source.java */
    public static class UnsupportedRequestException extends IOException {
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<DownloadRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i11) {
            return new DownloadRequest[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f10834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f10835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public List<StreamKey> f10836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public byte[] f10837e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public String f10838f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public byte[] f10839g;

        public b(String str, Uri uri) {
            this.f10833a = str;
            this.f10834b = uri;
        }

        public DownloadRequest a() {
            String str = this.f10833a;
            Uri uri = this.f10834b;
            String str2 = this.f10835c;
            List listOf = this.f10836d;
            if (listOf == null) {
                listOf = ImmutableList.of();
            }
            return new DownloadRequest(str, uri, str2, listOf, this.f10837e, this.f10838f, this.f10839g, null);
        }

        public b b(@Nullable String str) {
            this.f10838f = str;
            return this;
        }

        public b c(@Nullable byte[] bArr) {
            this.f10839g = bArr;
            return this;
        }

        public b d(@Nullable byte[] bArr) {
            this.f10837e = bArr;
            return this;
        }

        public b e(@Nullable String str) {
            this.f10835c = f0.t(str);
            return this;
        }

        public b f(@Nullable List<StreamKey> list) {
            this.f10836d = list;
            return this;
        }
    }

    public DownloadRequest(Parcel parcel) {
        this.f10832id = (String) u0.i(parcel.readString());
        this.uri = Uri.parse((String) u0.i(parcel.readString()));
        this.mimeType = parcel.readString();
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) u0.i(parcel.createByteArray());
    }

    private DownloadRequest(String str, Uri uri, @Nullable String str2, List<StreamKey> list, @Nullable byte[] bArr, @Nullable String str3, @Nullable byte[] bArr2) {
        int iC0 = u0.C0(uri, str2);
        if (iC0 == 0 || iC0 == 2 || iC0 == 1) {
            z3.a.b(str3 == null, "customCacheKey must be null for type: " + iC0);
        }
        this.f10832id = str;
        this.uri = uri;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : u0.f81843f;
    }

    public /* synthetic */ DownloadRequest(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2, a aVar) {
        this(str, uri, str2, list, bArr, str3, bArr2);
    }

    public DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithKeySetId(@Nullable byte[] bArr) {
        return new DownloadRequest(this.f10832id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        List listEmptyList;
        z3.a.a(this.f10832id.equals(downloadRequest.f10832id));
        if (this.streamKeys.isEmpty() || downloadRequest.streamKeys.isEmpty()) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = new ArrayList(this.streamKeys);
            for (int i11 = 0; i11 < downloadRequest.streamKeys.size(); i11++) {
                StreamKey streamKey = downloadRequest.streamKeys.get(i11);
                if (!listEmptyList.contains(streamKey)) {
                    listEmptyList.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f10832id, downloadRequest.uri, downloadRequest.mimeType, listEmptyList, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f10832id.equals(downloadRequest.f10832id) && this.uri.equals(downloadRequest.uri) && u0.c(this.mimeType, downloadRequest.mimeType) && this.streamKeys.equals(downloadRequest.streamKeys) && Arrays.equals(this.keySetId, downloadRequest.keySetId) && u0.c(this.customCacheKey, downloadRequest.customCacheKey) && Arrays.equals(this.data, downloadRequest.data);
    }

    public final int hashCode() {
        int iHashCode = ((this.f10832id.hashCode() * 961) + this.uri.hashCode()) * 31;
        String str = this.mimeType;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.streamKeys.hashCode()) * 31) + Arrays.hashCode(this.keySetId)) * 31;
        String str2 = this.customCacheKey;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.data);
    }

    public b0 toMediaItem() {
        return new b0.c().d(this.f10832id).i(this.uri).b(this.customCacheKey).e(this.mimeType).f(this.streamKeys).a();
    }

    public String toString() {
        return this.mimeType + ":" + this.f10832id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f10832id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i12 = 0; i12 < this.streamKeys.size(); i12++) {
            parcel.writeParcelable(this.streamKeys.get(i12), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
    }
}
