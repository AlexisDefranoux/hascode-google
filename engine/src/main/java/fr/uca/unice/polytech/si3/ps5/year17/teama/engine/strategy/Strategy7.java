package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Cache;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.EndPoint;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Video;

import java.util.*;

public class Strategy7 extends Strategy {

    public Strategy7(ControllerState controllerState) {
        super(controllerState);
        main();
    }

    protected void main() {
        Comparator<Integer> valueComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s1.compareTo(s2)*(-1);
            }
        };

        HashMap<Video, Integer> sortedOnValuesMap =  new HashMap<>();


        //for(int y=0; y<2; y++){
            for(Cache cache: caches){

                sortedOnValuesMap.clear();

                for(EndPoint endPoint : cache.getEndPoints().keySet()){
                    endPoint.getRequestTimeSave(cache.getEndPoints().get(endPoint),sortedOnValuesMap);
                }
                Strategy7.MapValueComparator<Video, Integer> mapComparator = new Strategy7.MapValueComparator<>(sortedOnValuesMap,valueComparator);
                Map<Video, Integer> treeMap = new TreeMap<>(mapComparator);
                treeMap.putAll(sortedOnValuesMap);

                for(Video video : treeMap.keySet()){
                    if (cache.addVideoHolder(video)){
                        cache.sendToEndpoint(video);
                    }

                    //cache.addVideoHolder(video);
                }
            }
      //  }

    }
    public class MapValueComparator<K, V> implements Comparator<K>{

        private final Map<K, V> mapToSort;
        private final Comparator<V> valueComparator;

        public MapValueComparator(Map<K, V> mapToSort, Comparator<V> valueComparator){
            this.mapToSort = mapToSort;
            this.valueComparator = valueComparator;
        }

        @Override
        public int compare(K key1, K key2) {
            return valueComparator.compare(mapToSort.get(key1), mapToSort.get(key2));
        }
    }
}


