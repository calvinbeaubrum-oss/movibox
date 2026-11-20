package com.vungle.warren.ui.state;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class BundleOptionsState implements c10.a, Parcelable {
    public static final Parcelable.Creator<BundleOptionsState> CREATOR = new a();
    private Map<String, String> strings = new HashMap();
    private Map<String, Boolean> bools = new HashMap();
    private Map<String, Integer> ints = new HashMap();

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<BundleOptionsState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BundleOptionsState createFromParcel(Parcel parcel) {
            return new BundleOptionsState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BundleOptionsState[] newArray(int i11) {
            return new BundleOptionsState[i11];
        }
    }

    public BundleOptionsState() {
    }

    public BundleOptionsState(Parcel parcel) {
        int i11 = parcel.readInt();
        for (int i12 = 0; i12 < i11; i12++) {
            this.ints.put(parcel.readString(), (Integer) parcel.readValue(String.class.getClassLoader()));
        }
        int i13 = parcel.readInt();
        for (int i14 = 0; i14 < i13; i14++) {
            this.strings.put(parcel.readString(), (String) parcel.readValue(String.class.getClassLoader()));
        }
        int i15 = parcel.readInt();
        for (int i16 = 0; i16 < i15; i16++) {
            this.bools.put(parcel.readString(), (Boolean) parcel.readValue(Boolean.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // c10.a
    public boolean getBoolean(String str, boolean z11) {
        Boolean bool = this.bools.get(str);
        return bool == null ? z11 : bool.booleanValue();
    }

    @Override // c10.a
    public Integer getInt(String str, int i11) {
        Integer num = this.ints.get(str);
        if (num != null) {
            i11 = num.intValue();
        }
        return Integer.valueOf(i11);
    }

    @Override // c10.a
    public String getString(String str) {
        return this.strings.get(str);
    }

    @Override // c10.a
    public void put(String str, int i11) {
        this.ints.put(str, Integer.valueOf(i11));
    }

    @Override // c10.a
    public void put(String str, String str2) {
        this.strings.put(str, str2);
    }

    @Override // c10.a
    public void put(String str, boolean z11) {
        this.bools.put(str, Boolean.valueOf(z11));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.ints.size());
        for (Map.Entry<String, Integer> entry : this.ints.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeValue(entry.getValue());
        }
        parcel.writeInt(this.strings.size());
        for (Map.Entry<String, String> entry2 : this.strings.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeValue(entry2.getValue());
        }
        parcel.writeInt(this.bools.size());
        for (Map.Entry<String, Boolean> entry3 : this.bools.entrySet()) {
            parcel.writeString(entry3.getKey());
            parcel.writeValue(entry3.getValue());
        }
    }
}
