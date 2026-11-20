package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f8817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8818b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a implements AudioAttributesImpl.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes.Builder f8819a = new AudioAttributes.Builder();

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(int i11) {
            this.f8819a.setLegacyStreamType(i11);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f8819a.build());
        }
    }

    public AudioAttributesImplApi21() {
        this.f8818b = -1;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i11) {
        this.f8817a = audioAttributes;
        this.f8818b = i11;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        int i11 = this.f8818b;
        return i11 != -1 ? i11 : AudioAttributesCompat.b(false, b(), c());
    }

    public int b() {
        return this.f8817a.getFlags();
    }

    public int c() {
        return this.f8817a.getUsage();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f8817a.equals(((AudioAttributesImplApi21) obj).f8817a);
        }
        return false;
    }

    public int hashCode() {
        return this.f8817a.hashCode();
    }

    @NonNull
    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f8817a;
    }
}
