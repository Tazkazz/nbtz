package lt.tazkazz.nbtz.stream;

import lt.tazkazz.nbtz.tag.Tag;
import lt.tazkazz.nbtz.tag.Type;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.GZIPInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class NBTInputStream implements AutoCloseable {
    private final DataInputStream input;

    public NBTInputStream(DataInputStream input) {
        this.input = input;
    }

    public NBTInputStream(InputStream input, boolean gzip) throws IOException {
        if (gzip) {
            input = new GZIPInputStream(input);
        }
        this.input = new DataInputStream(input);
    }

    public Tag readTag() throws IOException {
        Type type = Type.byType(readByte());
        String name = "";
        if (type != Type.TAG_END) {
            byte[] nameBytes = new byte[readShort()];
            readFully(nameBytes);
            name = new String(nameBytes, UTF_8);
        }
        return readTagContents(type, name);
    }

    public Tag readTagContents(Type type, String name) throws IOException {
        try {
            Tag tag = type.tagClass.getConstructor(String.class).newInstance(name);
            tag.read(this);
            return tag;
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new IOException(e);
        }
    }

    public byte readByte() throws IOException {
        return input.readByte();
    }

    public short readShort() throws IOException {
        return input.readShort();
    }

    public int readInt() throws IOException {
        return input.readInt();
    }

    public float readFloat() throws IOException {
        return input.readFloat();
    }

    public long readLong() throws IOException {
        return input.readLong();
    }

    public double readDouble() throws IOException {
        return input.readDouble();
    }

    public void readFully(byte[] bytes) throws IOException {
        input.readFully(bytes);
    }

    @Override
    public void close() throws Exception {
        input.close();
    }
}
