package com.IvAssessment.IvCodeAssignment;

import com.IvAssessment.IvCodeAssignment.model.MenuItem;
import com.IvAssessment.IvCodeAssignment.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

    Optional<MenuItem> findMenuItemById(Long id);

}