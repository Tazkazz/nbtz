package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompoundTag extends Tag<Map<String, Tag>> {
    public CompoundTag(String name) {
        super(name, new HashMap<>());
    }

    public CompoundTag(String name, Map<String, Tag> value) {
        super(name, value);
    }

    public CompoundTag(Map<String, Tag> value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        while (true) {
            Tag tag = input.readTag();
            if (tag instanceof EndTag) break;
            getValue().put(tag.getName(), tag);
        }
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        for (Tag tag : getValue().values()) {
            output.writeTag(tag);
        }
        output.writeByte(Type.TAG_END.type);
    }
}
