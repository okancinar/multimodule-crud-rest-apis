package com.cinar.okan.Repository;

import com.cinar.okan.Entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long>, CrudRepository<User, Long>, PagingAndSortingRepository<User,Long> {
}
