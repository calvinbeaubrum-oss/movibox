package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f8820a = versionedParcel.p(audioAttributesImplBase.f8820a, 1);
        audioAttributesImplBase.f8821b = versionedParcel.p(audioAttributesImplBase.f8821b, 2);
        audioAttributesImplBase.f8822c = versionedParcel.p(audioAttributesImplBase.f8822c, 3);
        audioAttributesImplBase.f8823d = versionedParcel.p(audioAttributesImplBase.f8823d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f8820a, 1);
        versionedParcel.F(audioAttributesImplBase.f8821b, 2);
        versionedParcel.F(audioAttributesImplBase.f8822c, 3);
        versionedParcel.F(audioAttributesImplBase.f8823d, 4);
    }
}
