package poo.demos;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MutableStringTest {

    @Test
    public void append_toEmptyString_producesAppendedString() {
        final MutableString str = new MutableString();
        str.append("SLB");
        Assert.assertEquals("SLB", str.toString());
    }

    @Test
    public void append_toEmptyString_producesAppendedStringWithCorrectLength() {
        final MutableString str = new MutableString();
        str.append("SLB");
        Assert.assertEquals(3, str.toString().length());
    }


    @Test
    public void append_toNonEmptyString_producesCorrectResult() {
        final MutableString str = new MutableString("SLB");
        str.append(", O MAIOR");
        Assert.assertEquals("SLB, O MAIOR", str.toString());
    }

    @Test
    public void setCharAt_producesCorrectResult() {
        final MutableString str = new MutableString("SLB, o MAIOR");
        str.setCharAt(5, 'O');
        Assert.assertEquals("SLB, O MAIOR", str.toString());
    }

    @Test
    public void setCharAt_ModifiesSpecifiedIndex() {
        final MutableString str = new MutableString("SLB, o MAIOR");
        final int IDX = 5;
        str.setCharAt(IDX, 'O');
        Assert.assertEquals('O', str.getCharAt(IDX));
    }
}
