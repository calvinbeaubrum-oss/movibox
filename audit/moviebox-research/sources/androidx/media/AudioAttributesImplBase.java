package androidx.media;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8823d;

    /* JADX INFO: compiled from: source.java */
    public static class a implements AudioAttributesImpl.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8824a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8825b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8826c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8827d = -1;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final a b(int i11) {
            switch (i11) {
                case 0:
                    this.f8825b = 1;
                    break;
                case 1:
                    this.f8825b = 4;
                    break;
                case 2:
                    this.f8825b = 4;
                    break;
                case 3:
                    this.f8825b = 2;
                    break;
                case 4:
                    this.f8825b = 4;
                    break;
                case 5:
                    this.f8825b = 4;
                    break;
                case 6:
                    this.f8825b = 1;
                    this.f8826c |= 4;
                    break;
                case 7:
                    this.f8826c = 1 | this.f8826c;
                    this.f8825b = 4;
                    break;
                case 8:
                    this.f8825b = 4;
                    break;
                case 9:
                    this.f8825b = 4;
                    break;
                case 10:
                    this.f8825b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i11 + " for AudioAttributesCompat");
                    break;
            }
            this.f8824a = AudioAttributesImplBase.e(i11);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f8825b, this.f8826c, this.f8824a, this.f8827d);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(int i11) {
            if (i11 == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.f8827d = i11;
            return b(i11);
        }
    }

    public AudioAttributesImplBase() {
        this.f8820a = 0;
        this.f8821b = 0;
        this.f8822c = 0;
        this.f8823d = -1;
    }

    public AudioAttributesImplBase(int i11, int i12, int i13, int i14) {
        this.f8821b = i11;
        this.f8822c = i12;
        this.f8820a = i13;
        this.f8823d = i14;
    }

    public static int e(int i11) {
        switch (i11) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 9:
            default:
                return 0;
            case 10:
                return 11;
        }
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        int i11 = this.f8823d;
        return i11 != -1 ? i11 : AudioAttributesCompat.b(false, this.f8822c, this.f8820a);
    }

    public int b() {
        return this.f8821b;
    }

    public int c() {
        int i11 = this.f8822c;
        int iA = a();
        if (iA == 6) {
            i11 |= 4;
        } else if (iA == 7) {
            i11 |= 1;
        }
        return i11 & 273;
    }

    public int d() {
        return this.f8820a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f8821b == audioAttributesImplBase.b() && this.f8822c == audioAttributesImplBase.c() && this.f8820a == audioAttributesImplBase.d() && this.f8823d == audioAttributesImplBase.f8823d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8821b), Integer.valueOf(this.f8822c), Integer.valueOf(this.f8820a), Integer.valueOf(this.f8823d)});
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f8823d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f8823d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.c(this.f8820a));
        sb2.append(" content=");
        sb2.append(this.f8821b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f8822c).toUpperCase());
        return sb2.toString();
    }
}
