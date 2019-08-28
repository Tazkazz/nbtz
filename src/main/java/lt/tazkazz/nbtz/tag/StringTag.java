package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StringTag extends Tag<String> {
    public StringTag(String name) {
        super(name, "");
    }

    public StringTag(String name, String value) {
        super(name, value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        byte[] bytes = new byte[input.readShort()];
        input.readFully(bytes);
        setValue(new String(bytes, UTF_8));
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        byte[] bytes = getValue().getBytes(UTF_8);
        output.writeShort((short) bytes.length);
        output.writeBytes(bytes);
    }
}
