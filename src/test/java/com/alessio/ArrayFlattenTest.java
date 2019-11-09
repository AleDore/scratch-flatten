package com.alessio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


import com.alessio.flatten.ArrayFlatten;


/**
 * Unit test for Array flattening.
 */
public class ArrayFlattenTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testUnionArray() throws Exception{
        int[] a1 = new int[]{1, 2};
        int[] a2 = new int[]{4};
        int[] result = ArrayFlatten.arrayUnion(a1,a2);
        int[] resultAssertion = new int[]{1, 2, 4};
        assertArrayEquals("Identical integer arrays", result, resultAssertion);
    }

    @Test
    public void testUnionNullSafe() throws Exception{
        int[] a1 = new int[]{1, 2};
        int[] a2 = null;
        int[] result = ArrayFlatten.arrayUnion(a1,a2);
        int[] resultAssertion = new int[]{1, 2};
        assertArrayEquals("Identical integer arrays", result, resultAssertion);
    }

    @Test
    public void testUnionException() throws Exception{
        int[] a1 = null;
        int[] a2 = null;
        thrown.expect(Exception.class);
        thrown.expectMessage("cannot union on null inputs");
        ArrayFlatten.arrayUnion(a1, a2);

    }

    @Test
    public void testUnionEmpty() throws Exception{
        int[] a1 = new int[0];
        int[] a2 = new int[0];
        int[] result = ArrayFlatten.arrayUnion(a1,a2);
        int[] resultAssertion = new int[]{};
        assertArrayEquals("same empty array", result, resultAssertion);
    }

    @Test
    public void testArrayElementTypes() throws Exception{
        Object[] array = { new Object[]{ 1, 2, new Object[]{ "5" }}, 4 };
        thrown.expect(Exception.class);
        thrown.expectMessage("Cannot flat array with nested element types different from Int or Array");
        ArrayFlatten.flatArray(array);
    }

    @Test
    public void testNullArray() throws Exception{
        Object[] array = null;
        thrown.expect(Exception.class);
        thrown.expectMessage("Input array cannot be null");
        ArrayFlatten.flatArray(array);
    }

    @Test
    public void testSimpleArrayFlattening() throws Exception{
        Object[] array = { new Object[]{ 1, 2, new Object[]{ 3 }}, 4 };
        int[] expected = new int[]{1, 2, 3, 4};
        assertArrayEquals("array flattened is equal to [1, 2, 3, 4]", expected, ArrayFlatten.flatArray(array));
    }

    @Test
    public void testEmptyArrayFlattening() throws Exception{
        Object[] array = { };
        int[] expected = new int[]{};
        assertArrayEquals("array flattened is equal to []", expected, ArrayFlatten.flatArray(array));
    }

    @Test
    public void testNestedEmptyArraysFlattening() throws Exception{
        Object[] array = { new Object[] {}, new Object[] {new Object[]{}} };
        int[] expected = new int[]{};
        assertArrayEquals("array flattened is equal to []", expected, ArrayFlatten.flatArray(array));
    }

}
