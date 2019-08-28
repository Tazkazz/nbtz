package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class ByteTag extends Tag<Byte> {
    public ByteTag(String name) {
        super(name, (byte) 0);
    }

    public ByteTag(String name, byte value) {
        super(name, value);
    }

    public ByteTag(byte value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        setValue(input.readByte());
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeByte(getValue());
    }
}
