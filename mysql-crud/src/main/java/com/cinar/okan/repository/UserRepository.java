package com.cinar.okan.repository;

import com.cinar.okan.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// @repository anotasyonu yazmaya gerek yok çünkü jparepo extend edilirken spring bunun bir repo katmanı olduğunu anlıyor ve instance yi ıoc katmanda tutuyor.
public interface UserRepository extends JpaRepository<User,Long>, PagingAndSortingRepository<User,Long> {
    Page<User> findAll(Pageable pageable);


}
