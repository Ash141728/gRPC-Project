package com.Insppiron.proto.Repository;

import com.Insppiron.proto.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Integer> {
}
