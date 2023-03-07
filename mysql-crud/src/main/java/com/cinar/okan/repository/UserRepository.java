package com.cinar.okan.repository;

import com.cinar.okan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// @repository anotasyonu yazmaya gerek yok çünkü jparepo extend edilirken spring bunun bir repo katmanı olduğunu anlıyor ve instance yi ıoc katmanda tutuyor.
public interface UserRepository extends JpaRepository<User,Long> {


}
