package m6;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends VersionedParcel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f70858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f70859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f70860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f70862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f70863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f70864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f70865k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    public b(Parcel parcel, int i11, int i12, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f70858d = new SparseIntArray();
        this.f70863i = -1;
        this.f70865k = -1;
        this.f70859e = parcel;
        this.f70860f = i11;
        this.f70861g = i12;
        this.f70864j = i11;
        this.f70862h = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f70859e.writeInt(-1);
        } else {
            this.f70859e.writeInt(bArr.length);
            this.f70859e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f70859e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i11) {
        this.f70859e.writeInt(i11);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f70859e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f70859e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i11 = this.f70863i;
        if (i11 >= 0) {
            int i12 = this.f70858d.get(i11);
            int iDataPosition = this.f70859e.dataPosition();
            this.f70859e.setDataPosition(i12);
            this.f70859e.writeInt(iDataPosition - i12);
            this.f70859e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel b() {
        Parcel parcel = this.f70859e;
        int iDataPosition = parcel.dataPosition();
        int i11 = this.f70864j;
        if (i11 == this.f70860f) {
            i11 = this.f70861g;
        }
        return new b(parcel, iDataPosition, i11, this.f70862h + "  ", this.f13073a, this.f13074b, this.f13075c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f70859e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int i11 = this.f70859e.readInt();
        if (i11 < 0) {
            return null;
        }
        byte[] bArr = new byte[i11];
        this.f70859e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f70859e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i11) {
        while (this.f70864j < this.f70861g) {
            int i12 = this.f70865k;
            if (i12 == i11) {
                return true;
            }
            if (String.valueOf(i12).compareTo(String.valueOf(i11)) > 0) {
                return false;
            }
            this.f70859e.setDataPosition(this.f70864j);
            int i13 = this.f70859e.readInt();
            this.f70865k = this.f70859e.readInt();
            this.f70864j += i13;
        }
        return this.f70865k == i11;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f70859e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f70859e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f70859e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i11) {
        a();
        this.f70863i = i11;
        this.f70858d.put(i11, this.f70859e.dataPosition());
        E(0);
        E(i11);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z11) {
        this.f70859e.writeInt(z11 ? 1 : 0);
    }
}
