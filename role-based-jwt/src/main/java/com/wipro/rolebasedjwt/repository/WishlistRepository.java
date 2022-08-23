package com.wipro.rolebasedjwt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rolebasedjwt.model.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	
	Page<Wishlist> findAllByUserId(Long id, Pageable pageable);
}
