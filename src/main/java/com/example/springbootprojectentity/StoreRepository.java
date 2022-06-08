package com.example.springbootprojectentity;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

public interface StoreRepository extends DatastoreRepository<StudentDetails, String> {


}
