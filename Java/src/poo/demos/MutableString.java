package poo.demos;

import java.util.Arrays;

public class MutableString {

    private char[] contents;

    public MutableString() {
        contents = new char[0];
    }

    public MutableString(String str) {
        contents = str.toCharArray();
    }

    public void append(String strToAppend) {
        char[] newContents = Arrays.copyOf(contents, contents.length + strToAppend.length());
        for(int idx = contents.length; idx < newContents.length; ++idx)
            newContents[idx] = strToAppend.charAt(idx - contents.length);
        contents = newContents;
    }

    public String toString() {
        return new String(contents);
    }

    public void setCharAt(int index, char value) {
        contents[index] = value;
    }

    public char getCharAt(int idx) {
        return contents[idx];
    }
}
