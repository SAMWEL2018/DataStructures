package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = new int[]{1, 2, 3, 4, 5};
        //reverseInt(array);
        //rotateToRight(array);
        rotateToLeft(array);
        String value = "my name is samwel";
        reverseString(value);
    }

    public static void reverseInt(int[] value) {
        int start = 0;
        int temp;
        int end = value.length - 1;
        while (start < end) {
            temp = value[start];
            value[start] = value[end];
            value[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(value));
    }

    public static void reverseString(String value) {
        String[] splitString = value.split(" ");
        int start = 0;
        String temp;
        int end = splitString.length - 1;
        while (start < end) {
            temp = splitString[start];
            splitString[start] = splitString[end];
            splitString[end] = temp;
            start++;
            end--;
        }
        System.out.println(value);
    }

    public static void rotateToLeft(int[] array) {
        int firstToLast = array[0];
        int counter = 0;
        while (counter < 1) {
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = firstToLast;
            counter++;
            System.out.println(Arrays.toString(array));

        }
    }

    public static void rotateToRight(int[] array) {

        int counter = 0;
        int lastToFirst = array[array.length - 1];
        while (counter < 1) {
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = lastToFirst;
            counter++;
        }
        System.out.println(Arrays.toString(array));
    }


    public static void multiD() {
        int[][] arr = {{1, 2}, {3, 4}};
        for (int i = 0; i < 2; i++) {
            //  System.out.println("i "+Arrays.toString(arr[i]));
            for (int j = 0; j < 2; j++) {
                System.out.println(arr[i][j]);

            }
        }
    }

    public static int countLfSameOn(String values) {
        int counter = 0;
        int countSubSequentLastAndFirstEqual = 0;
        char[] character = values.toCharArray();
        if (character[0] == character[character.length - 1]) {
            System.out.println(character);
            countSubSequentLastAndFirstEqual++;
        }
        while (counter < character.length - 1) {
            rotateToLeft(character);
            if (character[0] == character[character.length - 1]) {
                System.out.println(character);
                countSubSequentLastAndFirstEqual++;
            }
            //System.out.println(character);
            counter++;
        }
        return countSubSequentLastAndFirstEqual;
    }

    private static void rotateToLeft(char[] character) {
        char firstChar = character[0];
        for (int i = 0; i < character.length - 1; i++) {
            character[i] = character[i + 1];
        }
        character[character.length - 1] = firstChar;
    }

    public static int course(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 1;

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                System.out.println("inside contains");
                count++;
                seen.clear();
            }

            seen.add(c);

        }
        System.out.println("splitter count:" + count + "--array--" + seen.toString());
        return count;

    }

    public static int countOccurrence(String values) {
        values = values.toLowerCase();
        int counter = 0;
        int c = 0;
        List<Character> temp = new ArrayList<Character>();
        ArrayList<String> store = new ArrayList<>();
        char[] data = values.toCharArray();

        for (int i = 0; i < data.length; i++) {
            System.out.println(c++);
            System.out.println("val " + data[i]);


            if ((temp.contains(data[i]) || i == data.length - 1)) {
                counter++;
                store.add(getStringRepresentation(temp));
                System.out.println("hit!!!!!");
                System.out.println("Cleared");
                temp.clear();
            }
            temp.add(data[i]);
            System.out.println("Temp list " + temp.toString());
        }
        System.out.println("Store " + store);
        return counter;

    }

    public static String getStringRepresentation(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public static Map<String, Object> countNullFields(Object o) {

        Map<String, Object> dt = new LinkedHashMap<>();

        Arrays.stream(o.getClass().getDeclaredFields())
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        // System.out.println("try "+field.getName());
                        System.out.println(field);
                        Object value = field.get(o);
                        if (value != null && !String.valueOf(value).isEmpty()) {
                            dt.put(field.getName(), value);
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    // throw new IllegalArgumentException();
                });
        return dt;
    }
    static void pushZerosToEnd(int[] arr, int n) {
        int count = 0;

        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];
        System.out.println("counter " + count);
        while (count < n)
            arr[count++] = 0;
    }

    static void MoveZeroesToEnd(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
//                System.out.println(arr[count++]);
            }
        }
        System.out.println(arr.length);
        while (count < arr.length) {
            arr[count++] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void findSecondLargestElement(int[] arr) {
        int first, second;
        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }

        System.out.println("Second Element " + second);
    }

    static void findTop3Largest(int[] arr) {

        int first, second, third;
        first = second = third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }

        System.out.println("Elements from first " + first + " " + second + " " + third);

    }

    static void findBottom3Smallest(int[] arr) {
        int small, smaller, smallest;
        small = smaller = smallest = Integer.MAX_VALUE;
        System.out.println(smaller);
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < smallest) {
                small = smaller;
                smaller = smallest;
                smallest = arr[i];
            } else if (arr[i] < smaller && arr[i] > smallest) {
                small = smaller;
                smaller = arr[i];
            } else if (arr[i] < small && arr[i] > smaller) {
                small = arr[i];
            }
        }
        System.out.println("From smaller " + smallest + " " + smaller + " " + small);
    }

    public static void reverseString(int[] arr) {

    }
}