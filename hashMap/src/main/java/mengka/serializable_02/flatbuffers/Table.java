package mengka.serializable_02.flatbuffers;

import java.lang.String;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

// All tables in the generated code derive from this class, and add their own accessors.
public class Table {
  protected int bb_pos;
  protected ByteBuffer bb;

  final int SIZEOF_INT = 4;

  // Look up a field in the vtable, return an offset into the object, or 0 if the field is not
  // present.
  protected int __offset(int vtable_offset) {
    int vtable = bb_pos - bb.getInt(bb_pos);
    return vtable_offset < bb.getShort(vtable) ? bb.getShort(vtable + vtable_offset) : 0;
  }

  // Retrieve the relative offset stored at "offset"
  protected int __indirect(int offset) {
    return offset + bb.getInt(offset);
  }

  // Create a java String from UTF-8 data stored inside the flatbuffer.
  protected String __string(int offset) {
    offset += bb_pos;
    offset += bb.getInt(offset);
    return new String(bb.array(), offset + SIZEOF_INT, bb.getInt(offset), Charset.forName("UTF-8"));
  }

  // Get the length of a vector whose offset is stored at "offset" in this object.
  protected int __vector_len(int offset) {
    offset += bb_pos;
    offset += bb.getInt(offset);
    return bb.getInt(offset);
  }

  // Get the start of data of a vector whose offset is stored at "offset" in this object.
  protected int __vector(int offset) {
    offset += bb_pos;
    return offset + bb.getInt(offset) + SIZEOF_INT;  // data starts after the length
  }

  // Initialize any Table-derived type to point to the union at the given offset.
  protected Table __union(Table t, int offset) {
    offset += bb_pos;
    t.bb_pos = offset + bb.getInt(offset);
    t.bb = bb;
    return t;
  }
}
