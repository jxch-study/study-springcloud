package org.jxch.study.studyspringcloud.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class RockDBTest {

    @Autowired
    public RocksDB rocksDB;

    @Test
    public void put() throws RocksDBException {
        rocksDB.put("key".getBytes(), "value".getBytes());
    }

    @Test
    public void get() throws RocksDBException {
        String value = new String(rocksDB.get("key".getBytes()));
        log.info(value);
    }

    @Test
    public void del() throws RocksDBException {
        rocksDB.delete("key".getBytes());
    }

}
