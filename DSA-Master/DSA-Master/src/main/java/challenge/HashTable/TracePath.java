package challenge.HashTable;

import java.util.*;

public class TracePath {

    public static List<List<String>> tracePath(List<List<String>> paths) {
        Map<String, String> dictionary = new HashMap<>();

        for (List<String> path : paths) {
            dictionary.put(path.get(0), path.get(1));
        }

        Map<String, String> reverseDict = new HashMap<>();

        for (Map.Entry<String , String> entry : dictionary.entrySet()) {
            reverseDict.put(entry.getValue(), entry.getKey());
        }

        String start = null;

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (!reverseDict.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }

        List<List<String>> result = new ArrayList<>();

        String dest = dictionary.get(start);
        while(dest != null && !dest.isEmpty()) {
            List<String> path = new ArrayList<>();
            path.add(start);
            path.add(dest);
            result.add(path);
            start = dest;
            dest = dictionary.get(dest);
        }

        return result;
    }

    public static List<List<String>> convertTo2DList(String[][] inputMaps) {
        List<List<String>> resultList = new ArrayList<>();

        for (String[] inputMap : inputMaps) {
            List<String> list = new ArrayList<>();
            list.add(inputMap[0]);
            list.add(inputMap[1]);
            resultList.add(list);
        }

        return resultList;
    }

    public static void main(String[] args) {
        String[][][] inputMaps = {
                {{"NewYork", "Chicago"}, {"Boston", "Texas"}, {"Missouri", "NewYork"}, {"Texas", "Missouri"}},
                {{"Sydney", "Dubai"}, {"LosAngeles", "Cairo"}, {"Paris", "Rome"}, {"Cairo", "Paris"}, {"Rome", "Tokyo"}, {"Tokyo", "Sydney"}},
                {{"Vienna", "Athens"}, {"London", "Berlin"}, {"Madrid", "Rome"}, {"Paris", "Vienna"}, {"Rome", "Paris"}, {"Athens", "Moscow"}, {"Berlin", "Madrid"}},
                {{"Singapore", "Sydney"}},
                {{"HongKong", "Taipei"}, {"Osaka", "Seoul"}, {"Taipei", "Singapore"}, {"Tokyo", "Osaka"}, {"Beijing", "Shanghai"}, {"Seoul", "Beijing"}, {"Singapore", "KualaLumpur"}, {"Shanghai", "HongKong"}}
        };




        for (int i=0;i<inputMaps.length;i++) {

            List<List<String>> result = convertTo2DList(inputMaps[i]);
            List<List<String>> actual_output = TracePath.tracePath(result);

            System.out.println(Integer.toString(i+1)+". \tInput: " + Arrays.deepToString(inputMaps[i]));
            System.out.println("\tOutput: " + actual_output);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }
}
