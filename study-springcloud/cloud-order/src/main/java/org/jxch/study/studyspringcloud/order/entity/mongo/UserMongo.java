package org.jxch.study.studyspringcloud.order.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserMongo {

    @Id
    private String id;

    private String name;

    private int age;

    @Builder
    public UserMongo(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
