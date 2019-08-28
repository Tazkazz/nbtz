package lt.tazkazz.nbtz.stream;

import lt.tazkazz.nbtz.tag.Tag;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class NBTOutputStream implements AutoCloseable {
    private final DataOutputStream output;

    public NBTOutputStream(DataOutputStream output) {
        this.output = output;
    }

    public NBTOutputStream(OutputStream output, boolean gzip) throws IOException {
        if (gzip) {
            output = new GZIPOutputStream(output);
        }
        this.output = new DataOutputStream(output);
    }

    public void writeTag(Tag tag) throws IOException {
        String name = tag.getName();
        byte[] nameBytes = name.getBytes(UTF_8);
        writeByte(tag.getType());
        writeShort((short) nameBytes.length);
        writeBytes(nameBytes);
        writeTagContents(tag);
    }

    public void writeTagContents(Tag tag) throws IOException {
        tag.write(this);
    }

    public void writeByte(byte value) throws IOException {
        output.writeByte(value);
    }

    public void writeShort(short value) throws IOException {
        output.writeShort(value);
    }

    public void writeInt(int value) throws IOException {
        output.writeInt(value);
    }

    public void writeFloat(float value) throws IOException {
        output.writeFloat(value);
    }

    public void writeLong(long value) throws IOException {
        output.writeLong(value);
    }

    public void writeDouble(double value) throws IOException {
        output.writeDouble(value);
    }

    public void writeBytes(byte[] value) throws IOException {
        output.write(value);
    }

    @Override
    public void close() throws Exception {
        output.close();
    }
}
