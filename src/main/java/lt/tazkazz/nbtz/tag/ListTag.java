package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListTag<T extends Tag> extends Tag<List<T>> {
    public ListTag(String name) {
        super(name, new ArrayList<>());
    }

    public ListTag(String name, List<T> value) {
        super(name, value);
    }

    public ListTag(List<T> value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        Type listType = Type.byType(input.readByte());
        int size = input.readInt();
        if (listType == Type.TAG_END && size > 0)
            throw new IOException("Invalid list type: " + listType);
        for (int i = 0; i < size; i ++) {
            getValue().add((T) input.readTagContents(listType, ""));
        }
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeByte(getTagType());
        output.writeInt(getValue().size());
        for (T tag : getValue()) {
            output.writeTagContents(tag);
        }
    }

    private byte getTagType() {
        if (getValue().size() == 0) {
            return Type.TAG_END.type;
        }
        return getValue().get(0).getType();
    }
}
