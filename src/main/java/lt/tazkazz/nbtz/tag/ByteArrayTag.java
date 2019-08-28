package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class ByteArrayTag extends Tag<byte[]> {
    public ByteArrayTag(String name) {
        super(name, new byte[0]);
    }

    public ByteArrayTag(String name, byte[] value) {
        super(name, value);
    }

    public ByteArrayTag(byte[] value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        byte[] bytes = new byte[input.readInt()];
        input.readFully(bytes);
        setValue(bytes);
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeInt(getValue().length);
        output.writeBytes(getValue());
    }
}
