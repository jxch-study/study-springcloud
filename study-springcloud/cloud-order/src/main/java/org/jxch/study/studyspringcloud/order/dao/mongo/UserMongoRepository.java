package org.jxch.study.studyspringcloud.order.dao.mongo;

import org.jxch.study.studyspringcloud.order.entity.mongo.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserMongo, String> {

    UserMongo findByName(String name);

}
