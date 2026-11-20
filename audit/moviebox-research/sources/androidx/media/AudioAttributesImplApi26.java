package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class a extends AudioAttributesImplApi21.a {
        @Override // androidx.media.AudioAttributesImplApi21.a, androidx.media.AudioAttributesImpl.a
        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.f8819a.build());
        }
    }

    public AudioAttributesImplApi26() {
    }

    public AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
}
