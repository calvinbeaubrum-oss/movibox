package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.d0;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();

    @Nullable
    public final String description;

    @Deprecated
    public final String value;
    public final ImmutableList<String> values;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame[] newArray(int i11) {
            return new TextInformationFrame[i11];
        }
    }

    private TextInformationFrame(Parcel parcel) {
        this((String) z3.a.e(parcel.readString()), parcel.readString(), ImmutableList.copyOf((String[]) z3.a.e(parcel.createStringArray())));
    }

    public /* synthetic */ TextInformationFrame(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Deprecated
    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        this(str, str2, ImmutableList.of(str3));
    }

    public TextInformationFrame(String str, @Nullable String str2, List<String> list) {
        super(str);
        z3.a.a(!list.isEmpty());
        this.description = str2;
        ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) list);
        this.values = immutableListCopyOf;
        this.value = immutableListCopyOf.get(0);
    }

    private static List<Integer> parseId3v2point4TimestampFrameForDate(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return u0.c(this.f11800id, textInformationFrame.f11800id) && u0.c(this.description, textInformationFrame.description) && this.values.equals(textInformationFrame.values);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f11800id.hashCode()) * 31;
        String str = this.description;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.values.hashCode();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.media3.extractor.metadata.id3.Id3Frame, androidx.media3.common.Metadata.Entry
    public void populateMediaMetadata(d0.b bVar) {
        String str = this.f11800id;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b11 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b11 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b11 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b11 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b11 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b11 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b11 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b11 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b11 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b11 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b11 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b11 = Ascii.VT;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b11 = Ascii.FF;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b11 = Ascii.SI;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b11 = 17;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b11 = 19;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b11 = Ascii.NAK;
                }
                break;
        }
        try {
            switch (b11) {
                case 0:
                case 10:
                    bVar.N(this.values.get(0));
                    break;
                case 1:
                case 11:
                    bVar.S(this.values.get(0));
                    break;
                case 2:
                case 12:
                    String str2 = this.values.get(0);
                    bVar.e0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).d0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    bVar.O(this.values.get(0));
                    break;
                case 4:
                case 18:
                    bVar.M(this.values.get(0));
                    break;
                case 5:
                case 19:
                    bVar.T(this.values.get(0));
                    break;
                case 6:
                case 20:
                    String[] strArrO1 = u0.o1(this.values.get(0), "/");
                    bVar.o0(Integer.valueOf(Integer.parseInt(strArrO1[0]))).n0(strArrO1.length > 1 ? Integer.valueOf(Integer.parseInt(strArrO1[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.l0(this.values.get(0));
                    break;
                case 8:
                case 15:
                    bVar.p0(this.values.get(0));
                    break;
                case 9:
                case 21:
                    bVar.f0(Integer.valueOf(Integer.parseInt(this.values.get(0))));
                    break;
                case 13:
                    List<Integer> id3v2point4TimestampFrameForDate = parseId3v2point4TimestampFrameForDate(this.values.get(0));
                    int size = id3v2point4TimestampFrameForDate.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.d0(id3v2point4TimestampFrameForDate.get(2));
                            }
                        }
                        bVar.e0(id3v2point4TimestampFrameForDate.get(1));
                    }
                    bVar.f0(id3v2point4TimestampFrameForDate.get(0));
                    break;
                case 14:
                    List<Integer> id3v2point4TimestampFrameForDate2 = parseId3v2point4TimestampFrameForDate(this.values.get(0));
                    int size2 = id3v2point4TimestampFrameForDate2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.g0(id3v2point4TimestampFrameForDate2.get(2));
                            }
                        }
                        bVar.h0(id3v2point4TimestampFrameForDate2.get(1));
                    }
                    bVar.i0(id3v2point4TimestampFrameForDate2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f11800id + ": description=" + this.description + ": values=" + this.values;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f11800id);
        parcel.writeString(this.description);
        parcel.writeStringArray((String[]) this.values.toArray(new String[0]));
    }
}
