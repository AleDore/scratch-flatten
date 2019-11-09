package com.alessio.flatten;

/**
 * Utility class that perform flattening operations to an arbitrary array
 */
public class ArrayFlatten{

    /**
     * This method gets source array of object and returns an array of int.
     * The algorithm iterates over array elements and check if element is of the desired type (int or Object[]),
     * for each element it add the results of union between previous elements and next elements.
     * @param source: an arbitary array of Object
     * @return a flattened array of integers
     * @throws Exception when input array is null or array's nested element are different from int or array
     *
     */
    public static int[] flatArray(Object[] source) throws Exception{
        if(source == null) throw new Exception("Input array cannot be null");
        int[] toReturn = new int[]{};

        for (int i=0; i < source.length; i++){
            if (source[i] instanceof Integer){
                toReturn = arrayUnion(toReturn, new int[]{(int)source[i]});
            } else if (source[i] instanceof Object[]){
                toReturn = arrayUnion(toReturn, flatArray((Object[]) source[i]));
            } else{
                throw new Exception("Cannot flat array with nested element types different from Int or Array");
            }
        }
        return toReturn;
    }

    /**
     * This method performs union between two different array mantaining the element's order.
     * @param a1 the previous array elements already flattened
     * @param a2 the next array flattened to unify with a1
     * @return the array that represents the union between a1 and a2
     * @throws Exception
     */
    public static int[] arrayUnion(int[] a1, int[] a2) throws Exception {
        if (a1 == null && a2 == null) throw new Exception("cannot union on null inputs");
        int a1Length = 0;
        if (a1 != null)
            a1Length = a1.length;
        int a2Length = 0;
        if (a2 != null)
            a2Length = a2.length;
        int[] union = new int[a1Length + a2Length];
        int j = 0;
        for(int i=0; a1 != null && i < a1.length; i++){
            union[j] = a1[i];
            j++;
        }
        for(int i=0; a2 != null && i < a2.length; i++){
            union[j] = a2[i];
            j++;
        }
        return union;
    }

}
