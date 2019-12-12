package serverlet;



import com.riscure.functions.Strings;
import com.riscure.signalanalysis.Data;
import com.riscure.signalanalysis.TraceSet;
import  com.riscure.signalanalysis.inspector.HostData;

public class Trace {
    public static final int HIGH = 1;
    public static final int HIGH_AND_LOW = 0;
    public static final int LOW = 2;
    private boolean aggregatesValid;
    public byte[] data;
    public String dataString;
    private Trace fastHigh;
    private Trace fastLow;
    private boolean hasIllegalValues;
    private boolean isReal;
    private float max;
    private float min;
    @Deprecated
    public float[] sample;
    public float sampleFrequency;
    private Data samples;
    public int shifted;
    public String title;
    public TraceSet ts;

    @Deprecated
    public void setSample(int i, float f) {
        forceSample();
        this.sample[i] = f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float getLow(int r9, int r10) {
        /*
        r8 = this;
        r5 = com.riscure.signalanalysis.TraceSet.a;
        r6 = r8.getSample();
        r0 = r9 + 15;
        r1 = r0 & -16;
        if (r1 <= r10) goto L_0x000d;
    L_0x000c:
        r1 = r10;
    L_0x000d:
        r0 = r10 & -16;
        if (r0 >= r1) goto L_0x0012;
    L_0x0011:
        r0 = r1;
    L_0x0012:
        r2 = r8.fastLow;
        if (r2 == 0) goto L_0x0018;
    L_0x0016:
        if (r0 != r1) goto L_0x002f;
    L_0x0018:
        r3 = r6[r9];
        r2 = r9 + 1;
        r4 = r2;
    L_0x001d:
        if (r4 >= r10) goto L_0x006c;
    L_0x001f:
        r2 = r6[r4];
        if (r5 != 0) goto L_0x0065;
    L_0x0023:
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 >= 0) goto L_0x006a;
    L_0x0027:
        r2 = r6[r4];
    L_0x0029:
        r3 = r4 + 1;
        if (r5 == 0) goto L_0x0067;
    L_0x002d:
        if (r5 == 0) goto L_0x0065;
    L_0x002f:
        r2 = r8.fastLow;
        r3 = r1 >> 4;
        r4 = r0 >> 4;
        r2 = r2.getLow(r3, r4);
    L_0x0039:
        if (r9 >= r1) goto L_0x0049;
    L_0x003b:
        r3 = r6[r9];
        r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r5 != 0) goto L_0x0063;
    L_0x0041:
        if (r3 >= 0) goto L_0x0045;
    L_0x0043:
        r2 = r6[r9];
    L_0x0045:
        r9 = r9 + 1;
        if (r5 == 0) goto L_0x0039;
    L_0x0049:
        r1 = r2;
        r2 = r1;
    L_0x004b:
        r7 = r0;
        r0 = r2;
        r2 = r7;
    L_0x004e:
        if (r2 >= r10) goto L_0x005e;
    L_0x0050:
        r1 = r6[r2];
        if (r5 != 0) goto L_0x0061;
    L_0x0054:
        r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r1 >= 0) goto L_0x005a;
    L_0x0058:
        r0 = r6[r2];
    L_0x005a:
        r1 = r2 + 1;
        if (r5 == 0) goto L_0x005f;
    L_0x005e:
        return r0;
    L_0x005f:
        r2 = r1;
        goto L_0x004e;
    L_0x0061:
        r0 = r1;
        goto L_0x005e;
    L_0x0063:
        r0 = r3;
        goto L_0x004b;
    L_0x0065:
        r0 = r2;
        goto L_0x005e;
    L_0x0067:
        r4 = r3;
        r3 = r2;
        goto L_0x001d;
    L_0x006a:
        r2 = r3;
        goto L_0x0029;
    L_0x006c:
        r2 = r3;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.riscure.signalanalysis.Trace.getLow(int, int):float");
    }

    public int getNumberOfSamples() {
        return this.samples.getN();
    }

    public void setSampleFrequency(float f) {
        this.sampleFrequency = f;
    }

    public Trace(String str, byte[] bArr, float[] fArr, float f) {
        this.title = null;
        this.sample = null;
        this.data = null;
        this.shifted = HIGH_AND_LOW;
        this.dataString = null;
        this.ts = null;
        this.sampleFrequency = 1.0f;
        this.aggregatesValid = false;
        this.hasIllegalValues = false;
        this.isReal = false;
        this.max = 0.0f;
        this.min = 0.0f;
        this.fastLow = null;
        this.fastHigh = null;
        this.title = str;
        this.data = bArr;
        setSample(fArr);
        this.sampleFrequency = f;
        computeDataString();
        forceSample();
    }

    public void forceSample() {
        if (this.samples.getN() > 0) {
            this.sample = getSample();
            if (!TraceSet.a) {
                return;
            }
        }
        this.sample = null;
    }

    public Trace(String str, byte[] bArr, Data data, float f) {
        this.title = null;
        this.sample = null;
        this.data = null;
        this.shifted = HIGH_AND_LOW;
        this.dataString = null;
        this.ts = null;
        this.sampleFrequency = 1.0f;
        this.aggregatesValid = false;
        this.hasIllegalValues = false;
        this.isReal = false;
        this.max = 0.0f;
        this.min = 0.0f;
        this.fastLow = null;
        this.fastHigh = null;
        this.title = str;
        this.data = bArr;
        this.samples = data;
        this.sampleFrequency = f;
        computeDataString();
    }

    @Deprecated
    public Trace(String str, byte[] bArr, float[] fArr, boolean z) {
        this(str, bArr, fArr);
        if (z) {
            makeFastRead(HIGH_AND_LOW);
        }
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
        computeDataString();
    }

    public void getSampleRange(float[] fArr, int i, int i2, boolean z) {
        boolean z2 = TraceSet.a;
        if (z) {
            makeFastRead(HIGH_AND_LOW);
        }
        float[] sample = getSample();
        if (sample != null) {
            int i3 = this.shifted + i;
            int i4 = i2 + this.shifted;
            if (i3 < 0) {
                i3 = HIGH_AND_LOW;
            }
            if (i4 > sample.length) {
                i4 = sample.length;
            }
            if (i4 > i3) {
                int i5;
                int i6 = (i3 + 15) & -16;
                if (i6 > i4) {
                    i6 = i4;
                }
                int i7 = i4 & -16;
                if (i7 < i6) {
                    i7 = i6;
                }
                if (this.fastLow == null || i7 == i6) {
                    float f = sample[i3];
                    fArr[HIGH] = f;
                    fArr[HIGH_AND_LOW] = f;
                    i5 = i3 + HIGH;
                    while (i5 < i4) {
                        if (!z2) {
                            if (sample[i5] > fArr[HIGH_AND_LOW]) {
                                fArr[HIGH_AND_LOW] = sample[i5];
                            }
                            if (sample[i5] < fArr[HIGH]) {
                                fArr[HIGH] = sample[i5];
                            }
                            i5 += HIGH;
                            if (z2) {
                                break;
                            }
                        }
                        return;
                    }
                    if (!z2) {
                        return;
                    }
                }
                fArr[HIGH_AND_LOW] = this.fastHigh.getHigh(i6 >> 4, i7 >> 4);
                fArr[HIGH] = this.fastLow.getLow(i6 >> 4, i7 >> 4);
                i5 = i3;
                while (i5 < i6) {
                    i3 = (sample[i5] > fArr[HIGH_AND_LOW] ? 1 : (sample[i5] == fArr[HIGH_AND_LOW] ? 0 : -1));
                    if (z2) {
                        i7 = i3;
                        break;
                    }
                    if (i3 > 0) {
                        fArr[HIGH_AND_LOW] = sample[i5];
                    }
                    if (sample[i5] < fArr[HIGH]) {
                        fArr[HIGH] = sample[i5];
                    }
                    i3 = i5 + HIGH;
                    if (z2) {
                        break;
                    }
                    i5 = i3;
                }
                while (i7 < i4) {
                    if (sample[i7] > fArr[HIGH_AND_LOW]) {
                        fArr[HIGH_AND_LOW] = sample[i7];
                    }
                    if (sample[i7] < fArr[HIGH]) {
                        fArr[HIGH] = sample[i7];
                    }
                    i7 += HIGH;
                    if (z2) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float getHigh(int r9, int r10) {
        /*
        r8 = this;
        r5 = com.riscure.signalanalysis.TraceSet.a;
        r6 = r8.getSample();
        r0 = r9 + 15;
        r1 = r0 & -16;
        if (r1 <= r10) goto L_0x000d;
    L_0x000c:
        r1 = r10;
    L_0x000d:
        r0 = r10 & -16;
        if (r0 >= r1) goto L_0x0012;
    L_0x0011:
        r0 = r1;
    L_0x0012:
        r2 = r8.fastHigh;
        if (r2 == 0) goto L_0x0018;
    L_0x0016:
        if (r0 != r1) goto L_0x002f;
    L_0x0018:
        r3 = r6[r9];
        r2 = r9 + 1;
        r4 = r2;
    L_0x001d:
        if (r4 >= r10) goto L_0x006c;
    L_0x001f:
        r2 = r6[r4];
        if (r5 != 0) goto L_0x0065;
    L_0x0023:
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x006a;
    L_0x0027:
        r2 = r6[r4];
    L_0x0029:
        r3 = r4 + 1;
        if (r5 == 0) goto L_0x0067;
    L_0x002d:
        if (r5 == 0) goto L_0x0065;
    L_0x002f:
        r2 = r8.fastHigh;
        r3 = r1 >> 4;
        r4 = r0 >> 4;
        r2 = r2.getHigh(r3, r4);
    L_0x0039:
        if (r9 >= r1) goto L_0x0049;
    L_0x003b:
        r3 = r6[r9];
        r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r5 != 0) goto L_0x0063;
    L_0x0041:
        if (r3 <= 0) goto L_0x0045;
    L_0x0043:
        r2 = r6[r9];
    L_0x0045:
        r9 = r9 + 1;
        if (r5 == 0) goto L_0x0039;
    L_0x0049:
        r1 = r2;
        r2 = r1;
    L_0x004b:
        r7 = r0;
        r0 = r2;
        r2 = r7;
    L_0x004e:
        if (r2 >= r10) goto L_0x005e;
    L_0x0050:
        r1 = r6[r2];
        if (r5 != 0) goto L_0x0061;
    L_0x0054:
        r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r1 <= 0) goto L_0x005a;
    L_0x0058:
        r0 = r6[r2];
    L_0x005a:
        r1 = r2 + 1;
        if (r5 == 0) goto L_0x005f;
    L_0x005e:
        return r0;
    L_0x005f:
        r2 = r1;
        goto L_0x004e;
    L_0x0061:
        r0 = r1;
        goto L_0x005e;
    L_0x0063:
        r0 = r3;
        goto L_0x004b;
    L_0x0065:
        r0 = r2;
        goto L_0x005e;
    L_0x0067:
        r4 = r3;
        r3 = r2;
        goto L_0x001d;
    L_0x006a:
        r2 = r3;
        goto L_0x0029;
    L_0x006c:
        r2 = r3;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.riscure.signalanalysis.Trace.getHigh(int, int):float");
    }

    public void setSample(float[] fArr) {
        this.samples = HostData.createFloat(fArr);
    }

    private void computeDataString() {
        boolean z = TraceSet.a;
        if (this.data != null) {
            StringBuffer stringBuffer = new StringBuffer(this.data.length * 3);
            int i = HIGH_AND_LOW;
            while (i < this.data.length) {
                String toHexString = Integer.toHexString(this.data[i] & 255);
                if (!z) {
                    if (toHexString.length() == HIGH) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(toHexString.toUpperCase() + Strings.DEFAULT_SEPARATOR);
                    i += HIGH;
                    if (z) {
                        break;
                    }
                }
                return;
            }
            this.dataString = stringBuffer.toString();
        }
    }

    public void setShifted(int i) {
        this.shifted = i;
    }

    public int getPreferredCoding() {
        if (!this.aggregatesValid) {
            updateAggregates();
        }
        if (this.hasIllegalValues) {
            return HIGH_AND_LOW;
        }
        if (this.isReal) {
            return 20;
        }
        if (this.max > 32767.0f || this.min < -32768.0f) {
            return 4;
        }
        if (this.max > 127.0f || this.min < -128.0f) {
            return LOW;
        }
        return HIGH;
    }

    public float[] getSample() {
        return this.samples.getFloatData();
    }

    public float getSample(int i) {
        float[] sample = getSample();
        int i2 = this.shifted + i;
        if (i2 < 0 || i2 >= sample.length) {
            return 0.0f;
        }
        return sample[i2];
    }

    public TraceSet getTraceSet() {
        return this.ts;
    }

    public Data getSampleData() {
        return this.samples;
    }

    @Deprecated
    public Trace(String str, byte[] bArr, float[] fArr, float f, boolean z) {
        this(str, bArr, fArr, f);
        if (z) {
            makeFastRead(HIGH_AND_LOW);
        }
    }

    public boolean canBeLog() {
        return getLow(HIGH_AND_LOW, this.samples.getN()) > 0.0f;
    }

    public String getTitle() {
        return this.title;
    }

    public int getShifted() {
        return this.shifted;
    }

    public Trace(float[] fArr) {
        this.title = null;
        this.sample = null;
        this.data = null;
        this.shifted = HIGH_AND_LOW;
        this.dataString = null;
        this.ts = null;
        this.sampleFrequency = 1.0f;
        this.aggregatesValid = false;
        this.hasIllegalValues = false;
        this.isReal = false;
        this.max = 0.0f;
        this.min = 0.0f;
        this.fastLow = null;
        this.fastHigh = null;
        setSample(fArr);
        forceSample();
    }

    public String getDataString() {
        return this.dataString;
    }

    @Deprecated
    public void setSample(float[] fArr, boolean z) {
        setSample(fArr);
        if (z) {
            makeFastRead(HIGH_AND_LOW);
        }
    }

    public float getSampleFrequency() {
        return this.sampleFrequency;
    }

    public void setTraceSet(TraceSet traceSet) {
        this.ts = traceSet;
    }

    private void updateAggregates() {
        boolean z = TraceSet.a;
        float[] sample = getSample();
        int i = HIGH_AND_LOW;
        while (i < sample.length) {
            float f = sample[i];
            if (!z) {
                if (f > this.max) {
                    this.max = f;
                }
                if (f < this.min) {
                    this.min = f;
                }
                if (f != ((float) ((int) f))) {
                    this.isReal = true;
                }
                if (Float.isNaN(f) || Float.isInfinite(f) || f == Float.POSITIVE_INFINITY) {
                    this.hasIllegalValues = true;
                }
                i += HIGH;
                if (z) {
                    break;
                }
            }
            return;
        }
        this.aggregatesValid = true;
    }

    public byte[] getData() {
        return this.data;
    }

    @Deprecated
    public void getSampleRange(float[] fArr, int i, int i2) {
        getSampleRange(fArr, i, i2, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void makeFastRead(int r14) {
        /*
        r13 = this;
        r12 = 2;
        r3 = 0;
        r1 = -1;
        r11 = 1;
        r6 = com.riscure.signalanalysis.TraceSet.a;
        if (r14 != 0) goto L_0x0010;
    L_0x0008:
        r0 = r13.fastHigh;
        if (r0 == 0) goto L_0x0010;
    L_0x000c:
        r0 = r13.fastLow;
        if (r0 != 0) goto L_0x001c;
    L_0x0010:
        if (r14 != r11) goto L_0x0016;
    L_0x0012:
        r0 = r13.fastHigh;
        if (r0 != 0) goto L_0x001c;
    L_0x0016:
        if (r14 != r12) goto L_0x001d;
    L_0x0018:
        r0 = r13.fastLow;
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        return;
    L_0x001d:
        r7 = r13.getSample();
        if (r7 == 0) goto L_0x001c;
    L_0x0023:
        r0 = r7.length;
        if (r0 == 0) goto L_0x001c;
    L_0x0026:
        r0 = r7.length;
        r4 = (double) r0;
        r8 = 4625196817309499392; // 0x4030000000000000 float:0.0 double:16.0;
        r4 = r4 / r8;
        r4 = java.lang.StrictMath.ceil(r4);
        r4 = (int) r4;
        switch(r14) {
            case 0: goto L_0x0034;
            case 1: goto L_0x00a2;
            case 2: goto L_0x00cf;
            default: goto L_0x0033;
        };
    L_0x0033:
        goto L_0x001c;
    L_0x0034:
        r8 = new float[r4];
        r9 = new float[r4];
        r0 = r1;
        r2 = r3;
    L_0x003a:
        r5 = r7.length;
        if (r2 >= r5) goto L_0x008d;
    L_0x003d:
        r10 = r7[r2];
        r5 = r2 & 15;
        if (r6 != 0) goto L_0x0100;
    L_0x0043:
        if (r5 != 0) goto L_0x004d;
    L_0x0045:
        r0 = r0 + 1;
        r8[r0] = r10;
        r9[r0] = r10;
        if (r6 == 0) goto L_0x005d;
    L_0x004d:
        r5 = r8[r0];
        r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x0055;
    L_0x0053:
        r8[r0] = r10;
    L_0x0055:
        r5 = r9[r0];
        r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x005d;
    L_0x005b:
        r9[r0] = r10;
    L_0x005d:
        r5 = r13.max;
        r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x0065;
    L_0x0063:
        r13.max = r10;
    L_0x0065:
        r5 = r13.min;
        r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x006d;
    L_0x006b:
        r13.min = r10;
    L_0x006d:
        r5 = (int) r10;
        r5 = (float) r5;
        r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r5 == 0) goto L_0x0075;
    L_0x0073:
        r13.isReal = r11;
    L_0x0075:
        r5 = java.lang.Float.isNaN(r10);
        if (r5 != 0) goto L_0x0087;
    L_0x007b:
        r5 = java.lang.Float.isInfinite(r10);
        if (r5 != 0) goto L_0x0087;
    L_0x0081:
        r5 = 2139095040; // 0x7f800000 float:Infinity double:1.0568533725E-314;
        r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r5 != 0) goto L_0x0089;
    L_0x0087:
        r13.hasIllegalValues = r11;
    L_0x0089:
        r2 = r2 + 1;
        if (r6 == 0) goto L_0x003a;
    L_0x008d:
        r0 = r4;
    L_0x008e:
        if (r0 <= r11) goto L_0x009e;
    L_0x0090:
        r0 = new com.riscure.signalanalysis.Trace;
        r0.<init>(r8, r11);
        r13.fastHigh = r0;
        r0 = new com.riscure.signalanalysis.Trace;
        r0.<init>(r9, r12);
        r13.fastLow = r0;
    L_0x009e:
        r13.aggregatesValid = r11;
        if (r6 == 0) goto L_0x001c;
    L_0x00a2:
        r8 = new float[r4];
        r0 = r1;
        r2 = r3;
    L_0x00a6:
        r5 = r7.length;
        if (r2 >= r5) goto L_0x00c3;
    L_0x00a9:
        r9 = r7[r2];
        r5 = r2 & 15;
        if (r6 != 0) goto L_0x00fe;
    L_0x00af:
        if (r5 != 0) goto L_0x00b7;
    L_0x00b1:
        r0 = r0 + 1;
        r8[r0] = r9;
        if (r6 == 0) goto L_0x00bf;
    L_0x00b7:
        r5 = r8[r0];
        r5 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x00bf;
    L_0x00bd:
        r8[r0] = r9;
    L_0x00bf:
        r2 = r2 + 1;
        if (r6 == 0) goto L_0x00a6;
    L_0x00c3:
        r0 = r4;
    L_0x00c4:
        if (r0 <= r11) goto L_0x001c;
    L_0x00c6:
        r0 = new com.riscure.signalanalysis.Trace;
        r0.<init>(r8, r11);
        r13.fastHigh = r0;
        if (r6 == 0) goto L_0x001c;
    L_0x00cf:
        r2 = new float[r4];
    L_0x00d1:
        r0 = r7.length;
        if (r3 >= r0) goto L_0x00f2;
    L_0x00d4:
        r0 = r3 & 15;
        if (r6 != 0) goto L_0x00f3;
    L_0x00d8:
        if (r0 != 0) goto L_0x00e2;
    L_0x00da:
        r1 = r1 + 1;
        r0 = r7[r3];
        r2[r1] = r0;
        if (r6 == 0) goto L_0x00ee;
    L_0x00e2:
        r0 = r7[r3];
        r5 = r2[r1];
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x00ee;
    L_0x00ea:
        r0 = r7[r3];
        r2[r1] = r0;
    L_0x00ee:
        r3 = r3 + 1;
        if (r6 == 0) goto L_0x00d1;
    L_0x00f2:
        r0 = r4;
    L_0x00f3:
        if (r0 <= r11) goto L_0x001c;
    L_0x00f5:
        r0 = new com.riscure.signalanalysis.Trace;
        r0.<init>(r2, r12);
        r13.fastLow = r0;
        goto L_0x001c;
    L_0x00fe:
        r0 = r5;
        goto L_0x00c4;
    L_0x0100:
        r0 = r5;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.riscure.signalanalysis.Trace.makeFastRead(int):void");
    }

    public Trace(String str, byte[] bArr, float[] fArr) {
        this.title = null;
        this.sample = null;
        this.data = null;
        this.shifted = HIGH_AND_LOW;
        this.dataString = null;
        this.ts = null;
        this.sampleFrequency = 1.0f;
        this.aggregatesValid = false;
        this.hasIllegalValues = false;
        this.isReal = false;
        this.max = 0.0f;
        this.min = 0.0f;
        this.fastLow = null;
        this.fastHigh = null;
        this.title = str;
        this.data = bArr;
        setSample(fArr);
        computeDataString();
        forceSample();
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Deprecated
    public Trace(float[] fArr, int i) {
        this.title = null;
        this.sample = null;
        this.data = null;
        this.shifted = HIGH_AND_LOW;
        this.dataString = null;
        this.ts = null;
        this.sampleFrequency = 1.0f;
        this.aggregatesValid = false;
        this.hasIllegalValues = false;
        this.isReal = false;
        this.max = 0.0f;
        this.min = 0.0f;
        this.fastLow = null;
        this.fastHigh = null;
        setSample(fArr);
        makeFastRead(i);
    }

    public Trace(String str, byte[] bArr, Data data) {
        this.title = null;
        this.sample = null;
        this.data = null;
        this.shifted = HIGH_AND_LOW;
        this.dataString = null;
        this.ts = null;
        this.sampleFrequency = 1.0f;
        this.aggregatesValid = false;
        this.hasIllegalValues = false;
        this.isReal = false;
        this.max = 0.0f;
        this.min = 0.0f;
        this.fastLow = null;
        this.fastHigh = null;
        this.title = str;
        this.data = bArr;
        this.samples = data;
        computeDataString();
    }
}