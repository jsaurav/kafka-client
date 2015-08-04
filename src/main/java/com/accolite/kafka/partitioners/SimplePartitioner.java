package com.accolite.kafka.partitioners;

import org.apache.kafka.clients.producer.internals.Partitioner;

public class SimplePartitioner extends Partitioner {
    public SimplePartitioner () {

    }

    public int partition(Object key, int a_numPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
           partition = Integer.parseInt( stringKey.substring(offset+1)) % a_numPartitions;
        }
       return partition;
  }
}