package org.jxch.study.studyspringcloud.order.config;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Value("${rocksdb.path}")
    private String rocksDBPath;

    @Bean
    public RocksDB rocksDB() throws RocksDBException {
        Options options = new Options().setCreateIfMissing(true);
        return RocksDB.open(options, rocksDBPath);
    }

}
